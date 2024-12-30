package com.siaptekno.tahsinmqi.ui.alqurandetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.siaptekno.tahsinmqi.data.AlquranDetailRepository
import com.siaptekno.tahsinmqi.data.Result
import com.siaptekno.tahsinmqi.data.responsedetail.AlquranDetailResponse


class AlquranDetailViewModel(private val alquranDetailRepository: AlquranDetailRepository) : ViewModel() {

    // LiveData to hold and observe the API result (loading, success, error)
    private val _alquranDetail = MutableLiveData<Result<AlquranDetailResponse>>()
    val alquranDetail: LiveData<Result<AlquranDetailResponse>> = _alquranDetail

    // Fetch Surah details based on the Surah number
    fun getSurahDetail(surah: Int) {
        _alquranDetail.value = Result.Loading // Show loading state
        alquranDetailRepository.getSurahDetail(surah, ::onSuccess, ::onFailure) // Fetch details from repository
    }

    // Success callback to handle response
    private fun onSuccess(response: AlquranDetailResponse) {
        _alquranDetail.value = Result.Success(response) // Update LiveData with success data
    }

    // Failure callback to handle error
    private fun onFailure(error: String) {
        _alquranDetail.value = Result.Error(error) // Update LiveData with error message
    }
}