package com.example.rickandmortyimba.ui.fragments.location.detail

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.rickandmortyimba.R
import com.example.rickandmortyimba.base.BaseFragment
import com.example.rickandmortyimba.databinding.FragmentDetailLocationBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LocationDetailFragment
    : BaseFragment<FragmentDetailLocationBinding, LocationDetailViewModel>(R.layout.fragment_detail_location) {

    override val binding by viewBinding (FragmentDetailLocationBinding::bind)
    override val viewModel: LocationDetailViewModel by viewModels()
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