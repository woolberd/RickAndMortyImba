package com.example.rickandmortyimba.ui.fragments.characters

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.rickandmortyimba.R
import com.example.rickandmortyimba.base.BaseFragment
import com.example.rickandmortyimba.databinding.FragmentDetailCharacterBinding
import com.example.rickandmortyimba.extention.setImage

class CharacterDetailFragment
    : BaseFragment<FragmentDetailCharacterBinding, CharacterViewModel>(R.layout.fragment_detail_character) {

    override val binding by viewBinding(FragmentDetailCharacterBinding::bind)
    override val viewModel: CharacterViewModel by viewModels()
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