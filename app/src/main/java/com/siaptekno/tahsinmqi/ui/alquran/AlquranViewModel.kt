package com.siaptekno.tahsinmqi.ui.alquran

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.siaptekno.tahsinmqi.data.response.DataItem
import com.siaptekno.tahsinmqi.data.retrofit.AlquranApiConfig
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.awaitResponse

class AlquranViewModel : ViewModel() {

    private val _listSurah = MutableLiveData<List<DataItem>>()
    val listSurah: LiveData<List<DataItem>> get() = _listSurah

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> get() = _errorMessage

    init {
        fetchSurahList()
    }

    // Fetch the list of Surahs from the API
    private fun fetchSurahList() {
        _isLoading.value = true
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = AlquranApiConfig.getApiService().getListSurah().awaitResponse()
                if (response.isSuccessful) {
                    response.body()?.data?.let {
                        _listSurah.postValue(it)
                    } ?: _errorMessage.postValue("No data available")
                } else {
                    _errorMessage.postValue("Failed to load data: ${response.message()}")
                }
            } catch (e: Exception) {
                _errorMessage.postValue("Error: ${e.message}")
            } finally {
                _isLoading.postValue(false)
            }
        }
    }
}