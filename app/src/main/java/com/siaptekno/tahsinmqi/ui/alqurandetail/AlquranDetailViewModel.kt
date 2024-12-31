package com.siaptekno.tahsinmqi.ui.alqurandetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.siaptekno.tahsinmqi.data.AlquranDetailRepository
import com.siaptekno.tahsinmqi.data.responsedetail.Data
import com.siaptekno.tahsinmqi.data.retrofit.AlquranDetailApiConfig
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.awaitResponse

class AlquranDetailViewModel(private val repository: AlquranDetailRepository) : ViewModel() {

    private val _surahDetail = MutableLiveData<Data>()
    val surahDetail: LiveData<Data> get() = _surahDetail

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> get() = _errorMessage

    fun fetchSurahDetail(surah: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = AlquranDetailApiConfig.getApiService().getSpecificSurah(surah).awaitResponse()
                if (response.isSuccessful && response.body() != null) {
                    _surahDetail.postValue(response.body()!!.data)
                } else {
                    _errorMessage.postValue("Failed to fetch Surah details")
                }
            } catch (e: Exception) {
                _errorMessage.postValue(e.message ?: "An error occurred")
            }
        }
    }
}
