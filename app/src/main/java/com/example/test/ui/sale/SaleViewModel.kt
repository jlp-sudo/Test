package com.example.test.ui.sale

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.test.logic.Repository
import com.example.test.logic.model.Sale

class SaleViewModel:ViewModel() {
    private val searchLiveData=MutableLiveData<String>()

    val saleList=ArrayList<Sale>()
    val saleLiveData = Transformations.switchMap(searchLiveData){
        id->Repository.getSaleData(id)
    }

    fun getSaleData(id: String) {
        searchLiveData.value=id
    }

    fun getSaleInform(saleList:List<Sale>)=Repository.getSaleInform(saleList)

    fun sendMsg(msg:String)= Repository.sendMsg(msg)
    fun receiveMsg():String= Repository.receiveMsg()
}