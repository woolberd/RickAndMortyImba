package com.example.rickandmortyimba.ui.fragments.characters.detail

import android.content.Context
import android.net.ConnectivityManager
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.rickandmortyimba.R
import com.example.rickandmortyimba.base.BaseFragment
import com.example.rickandmortyimba.databinding.FragmentDetailCharacterBinding
import com.example.rickandmortyimba.extention.setImage
import com.example.rickandmortyimba.ui.fragments.characters.CharacterViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterDetailFragment
    : BaseFragment<FragmentDetailCharacterBinding, CharacterDetailViewModel>(R.layout.fragment_detail_character) {

    override val binding by viewBinding(FragmentDetailCharacterBinding::bind)
    override val viewModel: CharacterDetailViewModel by viewModels()
    private val args by navArgs<CharacterDetailFragmentArgs>()

    override fun setupObserves() {
        viewModel.fetchCharacter(args.id).observe(viewLifecycleOwner){
            binding.characterDetailName.text = it.name
            binding.characterDetailImage.setImage(it.image)
        }
    }

    override fun setupListener() {
        binding.arrowBackCharacter.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}