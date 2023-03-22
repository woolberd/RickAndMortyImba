package com.example.rickandmortyimba.ui.fragments.episode

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.rickandmortyimba.R
import com.example.rickandmortyimba.base.BaseFragment
import com.example.rickandmortyimba.databinding.FragmentEpisodeBinding
import com.example.rickandmortyimba.ui.adapters.EpisodeAdapter
import kotlinx.coroutines.launch

class EpisodeFragment :
    BaseFragment<FragmentEpisodeBinding, EpisodeViewModel>(R.layout.fragment_episode) {

    override val binding by viewBinding(FragmentEpisodeBinding::bind)
    override val viewModel: EpisodeViewModel by viewModels()
    private val episodeAdapter = EpisodeAdapter(this::onEpisodeItemClick)

    override fun initialize() {
        binding.episodeRecView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = episodeAdapter
        }
    }

    override fun setupObserves() {
        lifecycleScope.launch {
            viewModel.fetchEpisodes().collect {
                episodeAdapter.submitData(it)
            }
        }
    }

    private fun onEpisodeItemClick(id: Int) {
        findNavController().navigate(
            EpisodeFragmentDirections.actionEpisodeFragmentToDetailEpisodeFragment(
                id
            )
        )
    }
}