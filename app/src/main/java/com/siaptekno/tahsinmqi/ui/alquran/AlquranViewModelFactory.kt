package com.siaptekno.tahsinmqi.ui.alquran

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.siaptekno.tahsinmqi.data.AlquranRepository

class AlquranViewModelFactory(private val repository: AlquranRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AlquranViewModel::class.java)) {
            return AlquranViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
