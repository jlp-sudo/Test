package com.example.test.logic.network

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.await
import java.lang.RuntimeException
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

object TestNetwork {
    private val dailyService=ServiceCreator.create(DailyService::class.java)
    suspend fun getDailyData(id:String)= dailyService.getDailyData(id).await()
    private val saleService=ServiceCreator.create(SaleService::class.java)
    suspend fun getSaleData(id: String) = saleService.getSaleData(id).await()
    private val personalService=ServiceCreator.create(PersonalService::class.java)
    suspend fun getPersonalData(id:String)= personalService.getPersonalData(id).await()

    private suspend fun <T> Call<T>.await(): T {
        return suspendCoroutine { continuation -> enqueue(object : Callback<T> {
            override fun onFailure(call: Call<T>, t: Throwable) {
                continuation.resumeWithException(t)
            }

            override fun onResponse(call: Call<T>, response: Response<T>) {
                val body=response.body()
                if (body != null) continuation.resume(body)
                else continuation.resumeWithException(RuntimeException("response body is null"))
            }

        }) }
    }


}