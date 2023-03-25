package com.example.rickandmortyimba.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyimba.databinding.ItemEpisodeBinding
import com.example.rickandmortyimba.models.EpisodeModel

class EpisodeAdapter(
    val onEpisodeItemClick: (id : Int) -> Unit
) : ListAdapter<EpisodeModel, EpisodeAdapter.EpisodeViewHolder>(diffUtil) {

    inner class EpisodeViewHolder(private val binding: ItemEpisodeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                getItem(adapterPosition)?.let { it1 -> onEpisodeItemClick(it1.id) }
            }
        }

        fun onBind(episodeModel: EpisodeModel?) {
            binding.tvEpisode.text = episodeModel?.episode
            binding.tvAirDate.text = episodeModel?.airDate
            binding.tvCreatedEpisode.text = episodeModel?.created
            binding.tvNameEpisode.text = episodeModel?.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeViewHolder {
        return EpisodeViewHolder(
            ItemEpisodeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: EpisodeViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    companion object {
        private val diffUtil = object : DiffUtil.ItemCallback<EpisodeModel>() {
            override fun areItemsTheSame(
                oldItem: EpisodeModel,
                newItem: EpisodeModel
            )
                    : Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: EpisodeModel,
                newItem: EpisodeModel
            )
                    : Boolean {
                return oldItem.id == newItem.id
            }
        }
    }
}