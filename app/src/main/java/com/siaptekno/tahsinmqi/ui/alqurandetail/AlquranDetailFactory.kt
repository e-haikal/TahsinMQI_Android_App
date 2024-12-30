package com.siaptekno.tahsinmqi.ui.alqurandetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.siaptekno.tahsinmqi.data.AlquranDetailRepository
import com.siaptekno.tahsinmqi.data.retrofit.AlquranDetailApiConfig

class AlquranDetailFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val apiService = AlquranDetailApiConfig.getApiService() // Create the API service
        val repository = AlquranDetailRepository(apiService) // Create the repository
        return AlquranDetailViewModel(repository) as T // Return the ViewModel
    }
}