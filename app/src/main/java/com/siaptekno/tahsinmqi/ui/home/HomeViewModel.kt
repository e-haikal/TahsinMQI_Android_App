package com.siaptekno.tahsinmqi.ui.home

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.text.SimpleDateFormat
import java.util.Locale

class HomeViewModel : ViewModel() {
    private val _currentTime = MutableLiveData<String>()
    val currentTime: LiveData<String> get() = _currentTime

    private val timeFormat = SimpleDateFormat("hh:mm a", Locale.getDefault())
    private val handler = Handler(Looper.getMainLooper())
    private val timeUpdateRunnable = object : Runnable {
        override fun run() {
            // Update the current time
            _currentTime.value = timeFormat.format(System.currentTimeMillis())
            handler.postDelayed(this, 1000L) // Schedule next update after 1 second
        }
    }

    init {
        startClockUpdate()
    }

    private fun startClockUpdate() {
        handler.post(timeUpdateRunnable) // Start the initial update
    }

    override fun onCleared() {
        super.onCleared()
        handler.removeCallbacks(timeUpdateRunnable) // Stop updates to avoid memory leaks
    }
}