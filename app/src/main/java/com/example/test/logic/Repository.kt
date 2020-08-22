package com.example.test.logic

import androidx.lifecycle.liveData
import com.example.test.logic.dao.DailyDao
import com.example.test.logic.dao.PersonalDao
import com.example.test.logic.dao.SaleDao
import com.example.test.logic.model.Daily
import com.example.test.logic.model.Personal
import com.example.test.logic.model.Sale
import com.example.test.logic.network.Receive
import com.example.test.logic.network.Send
import com.example.test.logic.network.TestNetwork
import kotlinx.coroutines.Dispatchers
import java.lang.RuntimeException
import java.time.Period
import kotlin.coroutines.CoroutineContext

object Repository {
    fun getDailyData(id:String)= fire(Dispatchers.IO) {

        val dailyResponse = TestNetwork.getDailyData(id)
        if (dailyResponse.status == "ok") {
            val daily = dailyResponse.daily
            Result.success(daily)
        } else {
            Result.failure(RuntimeException("Response status id ${dailyResponse.status}"))
        }
    }

    fun getSaleData(id: String)= fire(Dispatchers.IO) {
        val saleResponse = TestNetwork.getSaleData(id)
        if (saleResponse.status == "ok") {
            val sale = saleResponse.sale
            Result.success(sale)
        } else {
            Result.failure(RuntimeException("Response status id ${saleResponse.status}"))
        }

    }

    fun getPersonalData(id: String) = fire(Dispatchers.IO){
        val personalResponse=TestNetwork.getPersonalData(id)
        if (personalResponse.status == "ok") {
            val personal = personalResponse.personal
            Result.success(personal)
        } else {
            Result.failure(RuntimeException("Response status id ${personalResponse.status}"))
        }
    }

    fun savePersonal(personal: Personal)=PersonalDao.savePersonalInform(personal)
    fun saveDaily(daily:Daily)=DailyDao.savedDailyInform(daily)
    fun saveSale(sale:Sale)=SaleDao.saveSaleInform(sale)
    fun getDailyInform( dailyList: List<Daily>) =DailyDao.getDailyInform(dailyList)
    fun getPersonalInform(personalList: List<Personal>)=PersonalDao.getPersonalInform(personalList)
    fun getSaleInform(saleList:List<Sale>)=SaleDao.getSaleInform(saleList)

    fun sendMsg(msg:String)=Send.send(msg)
    fun receiveMsg():String=Receive.receive()

    private fun <T> fire(context:CoroutineContext,block:suspend ()->Result<T>)= liveData<Result<T>>(context) {
        val result = try {
            block()
        } catch (e: Exception) {
            Result.failure<T>(e)
        }
        emit(result)
    }
}