package com.example.rickandmortyimba.ui.fragments.characters.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rickandmortyimba.models.CharacterModel
import com.example.rickandmortyimba.repositories.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharacterDetailViewModel @Inject constructor(
    private val characterRepository: CharacterRepository
) : ViewModel(){

    fun fetchCharacter(id: Int): MutableLiveData<CharacterModel> {
        return characterRepository.fetchCharacter(id)
    }
}