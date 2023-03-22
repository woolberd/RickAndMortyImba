package com.example.rickandmortyimba.ui.fragments.location

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.rickandmortyimba.R
import com.example.rickandmortyimba.base.BaseFragment
import com.example.rickandmortyimba.databinding.FragmentLocationBinding
import com.example.rickandmortyimba.ui.adapters.LocationAdapter
import kotlinx.coroutines.launch

class LocationFragment
    : BaseFragment<FragmentLocationBinding, LocationViewModel>(R.layout.fragment_location) {

    override val binding by viewBinding(FragmentLocationBinding::bind)
    override val viewModel: LocationViewModel by viewModels()
    private val locationAdapter = LocationAdapter(this::onLocationItemClick)

    override fun initialize() {
        binding.locationRecView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = locationAdapter
        }
    }

    override fun setupObserves() {
        lifecycleScope.launch {
            viewModel.fetchLocations().collect {
                locationAdapter.submitData(it)
            }
        }
    }

    private fun onLocationItemClick(id: Int) {
        findNavController().navigate(
            LocationFragmentDirections.actionLocationFragmentToDetailLocationFragment(
                id
            )
        )
    }
}