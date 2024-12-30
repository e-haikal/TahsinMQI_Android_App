package com.siaptekno.tahsinmqi.ui.alqurandetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.siaptekno.tahsinmqi.data.AlquranDetailRepository

class AlquranDetailFactory(private val repository: AlquranDetailRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AlquranDetailViewModel::class.java)) {
            return AlquranDetailViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
