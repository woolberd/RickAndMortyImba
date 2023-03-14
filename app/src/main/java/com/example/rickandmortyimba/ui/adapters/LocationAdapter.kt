package com.example.rickandmortyimba.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyimba.databinding.ItemLocationBinding
import com.example.rickandmortyimba.models.LocationModel

class LocationAdapter : RecyclerView.Adapter<LocationAdapter.LocationViewHolder>() {
    private var list: List<LocationModel> = ArrayList()

    fun setList(list: List<LocationModel>) {
        this.list = list
        notifyDataSetChanged()
    }

    class LocationViewHolder(private val binding: ItemLocationBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(locationModel: LocationModel) {
            binding.tvCreated.text = locationModel.created
            binding.tvName.text = locationModel.name
            binding.tvDimension.text = locationModel.dimension
            binding.tvType.text = locationModel.type
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {
        return LocationViewHolder(
            ItemLocationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size
}