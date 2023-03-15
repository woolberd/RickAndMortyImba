package com.example.rickandmortyimba.ui.fragments.episode

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickandmortyimba.databinding.FragmentEpisodeBinding
import com.example.rickandmortyimba.ui.adapters.EpisodeAdapter

class EpisodeFragment : Fragment() {

    private var viewModel: EpisodeViewModel? = null
    private lateinit var binding: FragmentEpisodeBinding
    private val episodeAdapter = EpisodeAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEpisodeBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[EpisodeViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupObserves()
    }

    private fun initialize() {
        binding.episodeRecView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = episodeAdapter
        }
    }

    private fun setupObserves() {
        viewModel?.fetchEpisode()?.observe(viewLifecycleOwner) {
            episodeAdapter.setList(it.results)
        }
    }
}