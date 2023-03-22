package com.example.rickandmortyimba.ui.fragments.location

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.rickandmortyimba.R
import com.example.rickandmortyimba.base.BaseFragment
import com.example.rickandmortyimba.databinding.FragmentDetailLocationBinding

class LocationDetailFragment
    : BaseFragment<FragmentDetailLocationBinding, LocationViewModel>(R.layout.fragment_detail_location) {

    override val binding by viewBinding (FragmentDetailLocationBinding::bind)
    override val viewModel: LocationViewModel by viewModels()
    private val args by navArgs<LocationDetailFragmentArgs>()

    override fun setupObserves() {
        viewModel.fetchLocation(args.id).observe(viewLifecycleOwner){
            binding.firstTvLocation.text = it.name
            binding.secondTvLocation.text = it.type
        }
    }

    override fun setupListener() {
        binding.arrowBackLocation.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}