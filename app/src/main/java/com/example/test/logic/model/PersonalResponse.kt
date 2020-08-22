package com.example.test.logic.model

data class PersonalResponse(val status:String,val personal: Personal)

data class Personal(var id:String, var age:Int, val tel:String, val basicInform: BasicInform)

data class BasicInform(var headImage:Int, var name:String, var sex:String)
