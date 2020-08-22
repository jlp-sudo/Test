package com.example.test.logic.network

import com.example.test.logic.model.SaleResponse
import retrofit2.Call
import retrofit2.http.GET


interface SaleService {
    @GET("")
    fun getSaleData(id:String): Call<SaleResponse>
}