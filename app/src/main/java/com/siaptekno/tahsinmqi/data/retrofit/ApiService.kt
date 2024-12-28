package com.siaptekno.tahsinmqi.data.retrofit

import com.siaptekno.tahsinmqi.data.response.ScheduleResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("sholat/jadwal/1504/{date}")
    fun getSchedule(
        @Path("date") date: String,
    ): Call<ScheduleResponse>
}