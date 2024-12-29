package com.siaptekno.tahsinmqi.data

import com.siaptekno.tahsinmqi.data.response.AlquranResponse
import com.siaptekno.tahsinmqi.data.retrofit.AlquranApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//Encapsulate the logic for fetching data from the API in a repository
class AlquranRepository(private val apiService: AlquranApiService) {

    fun getListSurah(onSuccess: (AlquranResponse) -> Unit, onFailure: (String) -> Unit) {
        apiService.getListSurah().enqueue(object : Callback<AlquranResponse> {
            override fun onResponse(call: Call<AlquranResponse>, response: Response<AlquranResponse>) {
                if (response.isSuccessful && response.body() != null) {
                    onSuccess(response.body()!!)
                } else {
                    onFailure("Failed to load data")
                }
            }

            override fun onFailure(call: Call<AlquranResponse>, t: Throwable) {
                onFailure(t.message ?: "Unknown error")
            }
        })
    }
}