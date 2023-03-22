package com.example.rickandmortyimba.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyimba.databinding.ItemLocationBinding
import com.example.rickandmortyimba.models.LocationModel

class LocationAdapter(
    val onLocationItemClick: (id : Int) -> Unit
) : PagingDataAdapter<LocationModel, LocationAdapter.LocationViewHolder>(diffUtil) {

    inner class LocationViewHolder(private val binding: ItemLocationBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                getItem(absoluteAdapterPosition)?.let { it1 -> onLocationItemClick(it1.id) }
            }
        }

        fun onBind(locationModel: LocationModel?) {
            binding.tvCreated.text = locationModel?.created
            binding.tvName.text = locationModel?.name
            binding.tvDimension.text = locationModel?.dimension
            binding.tvType.text = locationModel?.type
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {
        return LocationViewHolder(
            ItemLocationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    companion object {
        private val diffUtil = object : DiffUtil.ItemCallback<LocationModel>() {
            override fun areItemsTheSame(
                oldItem: LocationModel,
                newItem: LocationModel
            )
                    : Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: LocationModel,
                newItem: LocationModel
            )
                    : Boolean {
                return oldItem.id == newItem.id
            }
        }
    }
}