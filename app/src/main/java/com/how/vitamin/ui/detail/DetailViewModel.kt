package com.how.vitamin.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.how.vitamin.data.repository.Repository
import com.how.vitamin.ui.HouseType
import kotlinx.coroutines.Dispatchers
import com.how.vitamin.model.Character

class DetailViewModel(house: HouseType, private val repository: Repository) : ViewModel() {

    val characterList : LiveData<List<Character>> = liveData(Dispatchers.IO) {
        isLoading.postValue(true)
        emit(repository.getCharacters(house.name))
        isLoading.postValue(false)
    }

    val isLoading = MutableLiveData<Boolean>()

}