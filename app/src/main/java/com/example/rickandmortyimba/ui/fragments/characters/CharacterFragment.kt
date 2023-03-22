package com.example.rickandmortyimba.ui.fragments.characters

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.rickandmortyimba.R
import com.example.rickandmortyimba.base.BaseFragment
import com.example.rickandmortyimba.databinding.FragmentCharacterBinding
import com.example.rickandmortyimba.ui.adapters.CharacterAdapter
import kotlinx.coroutines.launch

class CharacterFragment
    : BaseFragment<FragmentCharacterBinding, CharacterViewModel>(R.layout.fragment_character) {

    override val binding by viewBinding(FragmentCharacterBinding::bind)
    override val viewModel: CharacterViewModel by viewModels()
    private val characterAdapter = CharacterAdapter(this::onCharacterItemClick)

    override fun initialize() {
        binding.characterRecView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = characterAdapter
        }
    }

    override fun setupObserves() {
        lifecycleScope.launch {
            viewModel.fetchCharacters().collect {
                characterAdapter.submitData(it)
            }
        }
    }

    private fun onCharacterItemClick(id: Int) {
        findNavController().navigate(
            CharacterFragmentDirections.actionCharacterFragmentToDetailCharacterFragment(
                id
            )
        )
    }
}
