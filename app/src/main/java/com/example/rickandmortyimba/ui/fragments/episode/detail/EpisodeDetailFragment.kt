package com.example.rickandmortyimba.ui.fragments.episode.detail

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.rickandmortyimba.R
import com.example.rickandmortyimba.base.BaseFragment
import com.example.rickandmortyimba.databinding.FragmentDetailEpisodeBinding
import com.example.rickandmortyimba.ui.fragments.episode.EpisodeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EpisodeDetailFragment
    : BaseFragment<FragmentDetailEpisodeBinding, EpisodeDetailViewModel>(R.layout.fragment_detail_episode) {

    override val binding by viewBinding(FragmentDetailEpisodeBinding::bind)
    override val viewModel: EpisodeDetailViewModel by viewModels()
    private val args by navArgs<EpisodeDetailFragmentArgs>()

    override fun setupObserves() {
        viewModel.fetchEpisode(args.id).observe(viewLifecycleOwner) {
            binding.firstTvEpisode.text = it.episode
            binding.secondTvEpisode.text = it.airDate
        }
    }

    override fun setupListener() {
        binding.arrowBackEpisode.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}