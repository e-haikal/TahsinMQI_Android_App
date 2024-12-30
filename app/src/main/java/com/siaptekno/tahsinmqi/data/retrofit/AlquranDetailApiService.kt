package com.siaptekno.tahsinmqi.data.retrofit

import com.siaptekno.tahsinmqi.data.responsedetail.AlquranDetailResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface AlquranDetailApiService {
    // Fetch the list of Surahs
    @GET("surah")
    fun getListSurah(): Call<AlquranDetailResponse>

    // Fetch a specific Surah detail
    @GET("surah/{surah}")
    fun getSpecificSurah(@Path("surah") surah: Int): Call<AlquranDetailResponse>
}
