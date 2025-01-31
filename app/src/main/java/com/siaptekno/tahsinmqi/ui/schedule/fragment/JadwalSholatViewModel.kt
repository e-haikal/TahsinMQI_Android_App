package com.siaptekno.tahsinmqi.ui.schedule.fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.siaptekno.tahsinmqi.data.response.ScheduleResponse
import com.siaptekno.tahsinmqi.data.retrofit.ScheduleApiConfig
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class JadwalSholatViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    private val _schedule = MutableLiveData<ScheduleResponse>()
    val schedule: LiveData<ScheduleResponse> = _schedule

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    fun fetchSchedule() {
        // Get the current date in the format required by the API
        val currentDate = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())

        viewModelScope.launch {
            try {
                val response = withContext(Dispatchers.IO) {
                    ScheduleApiConfig.getApiService().getSchedule(currentDate).execute()
                }
                if (response.isSuccessful) {
                    response.body()?.let {
                        _schedule.postValue(it)
                    }
                } else {
                    _error.postValue("Failed to fetch schedule: ${response.message()}")
                }
            } catch (e: HttpException) {
                _error.postValue("Network error: ${e.message()}")
            } catch (e: Exception) {
                _error.postValue("An error occurred: ${e.message}")
            }
        }
    }
}