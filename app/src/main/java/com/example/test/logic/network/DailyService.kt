package com.example.test.logic.network

import com.example.test.logic.model.DailyResponse
import retrofit2.Call
import retrofit2.http.GET

interface DailyService {
    @GET("")
    fun getDailyData(id:String): Call<DailyResponse>
}