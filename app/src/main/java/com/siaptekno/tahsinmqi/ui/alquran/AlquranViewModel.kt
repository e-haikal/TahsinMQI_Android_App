package com.siaptekno.tahsinmqi.ui.alquran

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.siaptekno.tahsinmqi.data.AlquranRepository
import com.siaptekno.tahsinmqi.data.response.DataItem

//Handle the data fetching and expose it to the Fragment
class AlquranViewModel(private val repository: AlquranRepository) : ViewModel() {

    private val _listSurah = MutableLiveData<List<DataItem>>()
    val listSurah: LiveData<List<DataItem>> get() = _listSurah

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> get() = _errorMessage

    fun fetchListSurah() {
        repository.getListSurah(
            onSuccess = { response ->
                _listSurah.value = response.data
            },
            onFailure = { error ->
                _errorMessage.value = error
            }
        )
    }
}