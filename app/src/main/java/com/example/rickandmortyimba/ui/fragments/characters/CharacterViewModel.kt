package com.example.rickandmortyimba.ui.fragments.characters

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.rickandmortyimba.models.CharacterModel
import com.example.rickandmortyimba.repositories.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val characterRepository: CharacterRepository
) : ViewModel() {

    fun fetchCharacters() = characterRepository.fetchCharacters()
//        .cachedIn(viewModelScope)

    fun getAll() = characterRepository.getAll()
}