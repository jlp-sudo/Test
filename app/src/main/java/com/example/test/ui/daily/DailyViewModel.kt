package com.example.test.ui.daily

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.test.logic.Repository
import com.example.test.logic.model.Daily
import com.example.test.logic.network.Receive
import com.example.test.logic.network.Send

class DailyViewModel:ViewModel() {
    private val searchLiveData= MutableLiveData<String>()
    val dailyList=ArrayList<Daily>()

    val dailyLiveData = Transformations.switchMap(searchLiveData){
        id->Repository.getDailyData(id)
    }

    fun getDailyData(id: String) {
        searchLiveData.value=id
    }

    fun getDailyInform(dailyList: List<Daily>) =Repository.getDailyInform(dailyList)


}