package com.example.test.logic.model

data class SaleResponse(val status:String ,val sale: Sale)

data class Sale(val product: Product,val basicInform: BasicInform)

data class Product(var pId:String, var productName:String, var productIntro:String, var productImage:Int, var productPrice:Float)
