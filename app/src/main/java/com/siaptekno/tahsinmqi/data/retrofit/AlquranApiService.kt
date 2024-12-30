package com.siaptekno.tahsinmqi.data.retrofit

import com.siaptekno.tahsinmqi.data.response.AlquranResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface AlquranApiService {
    // Fetch the list of Surahs
    @GET("surah")
    fun getListSurah(): Call<AlquranResponse>

    // Fetch a specific Surah detail
    @GET("surah/{surah}")
    fun getSpecificSurah(@Path("surah") surah: Int): Call<AlquranResponse>
}