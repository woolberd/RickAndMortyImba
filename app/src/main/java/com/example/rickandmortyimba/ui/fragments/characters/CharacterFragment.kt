package com.example.rickandmortyimba.ui.fragments.characters

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickandmortyimba.databinding.FragmentCharacterBinding
import com.example.rickandmortyimba.ui.adapters.CharacterAdapter

class CharacterFragment : Fragment() {

    private var viewModel: CharacterViewModel? = null
    private lateinit var binding: FragmentCharacterBinding
    private val characterAdapter = CharacterAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCharacterBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[CharacterViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupObserves()
    }

    private fun initialize() {
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = characterAdapter
        }
    }

    private fun setupObserves() {
        viewModel?.fetchCharacters()?.observe(viewLifecycleOwner) {
            characterAdapter?.setList(it.results)
        }
    }

}