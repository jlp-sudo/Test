package com.example.test.logic.model

import android.location.Location
import java.sql.Time

data class DailyResponse(val status:String ,val daily: Daily)

data class Daily(val basicInform: BasicInform, val share: Share)

data class Share(var sId:String, var content:String, var shareImage:Int, val location: Location)
