package com.example.rickandmortyimba.ui.fragments.characters

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.rickandmortyimba.models.CharacterModel
import com.example.rickandmortyimba.repositories.CharacterRepository

class CharacterViewModel : ViewModel() {

   private val characterRepository = CharacterRepository()

    fun fetchCharacters() = characterRepository.fetchCharacters().cachedIn(viewModelScope)

    fun fetchCharacter(id: Int): MutableLiveData<CharacterModel>{
        return characterRepository.fetchCharacter(id)
    }
}