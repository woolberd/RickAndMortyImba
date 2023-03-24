package com.example.rickandmortyimba.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyimba.databinding.ItemCharacterBinding
import com.example.rickandmortyimba.extention.setImage
import com.example.rickandmortyimba.models.CharacterModel

class CharacterAdapter(
    val onCharacterItemClick: (id : Int) -> Unit
) : ListAdapter<CharacterModel, CharacterAdapter.CharacterViewHolder>(diffUtil) {

    inner class CharacterViewHolder(private val binding: ItemCharacterBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                getItem(adapterPosition)?.let { it1 -> onCharacterItemClick(it1.id) }
            }
        }

        fun onBind(characterModel: CharacterModel?) {
            binding.itemName.text = characterModel?.name
            binding.tvFirstSeeAddress.text = characterModel?.status
            binding.tvAddress.text = characterModel?.gender
            binding.actionImage.setImage(characterModel!!.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder(
            ItemCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    companion object{
        private val diffUtil = object : DiffUtil.ItemCallback<CharacterModel>(){
            override fun areItemsTheSame(
                oldItem: CharacterModel,
                newItem: CharacterModel
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: CharacterModel,
                newItem: CharacterModel
            ): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }
}