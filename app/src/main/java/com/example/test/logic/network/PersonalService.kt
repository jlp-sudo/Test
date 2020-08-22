package com.example.test.logic.network

import com.example.test.logic.model.PersonalResponse
import retrofit2.Call
import retrofit2.http.GET

interface PersonalService {
    @GET("")
    fun getPersonalData(id:String): Call<PersonalResponse>
}