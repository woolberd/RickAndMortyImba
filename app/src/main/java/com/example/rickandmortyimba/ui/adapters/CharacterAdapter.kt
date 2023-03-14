package com.example.rickandmortyimba.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rickandmortyimba.databinding.ItemCharacterBinding
import com.example.rickandmortyimba.models.CharacterModel

class CharacterAdapter : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    private var list: List<CharacterModel> = ArrayList()

    fun setList(list: List<CharacterModel>) {
        this.list = list
        notifyDataSetChanged()
    }

    class CharacterViewHolder(private val binding: ItemCharacterBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(characterModel: CharacterModel) {
            binding.itemName.text = characterModel.name
            binding.tvFirstSeeAddress.text = characterModel.status
            binding.tvAddress.text = characterModel.gender
            Glide.with(binding.actionImage.context).load(characterModel.image).into(binding.actionImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder(
            ItemCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}