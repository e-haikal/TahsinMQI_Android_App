package com.siaptekno.tahsinmqi.data

import com.siaptekno.tahsinmqi.data.responsedetail.AlquranDetailResponse
import com.siaptekno.tahsinmqi.data.retrofit.AlquranDetailApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AlquranDetailRepository(private val apiService: AlquranDetailApiService) {

    // Fetch specific Surah details
    fun getSurahDetail(
        surah: Int,
        onSuccess: (AlquranDetailResponse) -> Unit,
        onFailure: (String) -> Unit
    ) {
        apiService.getSpecificSurah(surah).enqueue(object : Callback<AlquranDetailResponse> {
            override fun onResponse(
                call: Call<AlquranDetailResponse>,
                response: Response<AlquranDetailResponse>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    onSuccess(response.body()!!)
                } else {
                    onFailure("Failed to load data")
                }
            }

            override fun onFailure(call: Call<AlquranDetailResponse>, t: Throwable) {
                onFailure(t.message ?: "Unknown error")
            }
        })
    }
}