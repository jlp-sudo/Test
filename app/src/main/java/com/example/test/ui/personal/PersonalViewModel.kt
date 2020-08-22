package com.example.test.ui.personal

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.test.logic.Repository
import com.example.test.logic.model.Personal

class PersonalViewModel:ViewModel() {
    private val searchLiveData= MutableLiveData<String>()
    val personalList=ArrayList<Personal>()

    val personalLiveData = Transformations.switchMap(searchLiveData){
            id->
        Repository.getPersonalData(id)
    }

    fun getPersonalData(id: String) {
        searchLiveData.value=id
    }

    fun getPersonaInform(personalList: List<Personal>) =Repository.getPersonalInform(personalList)

}