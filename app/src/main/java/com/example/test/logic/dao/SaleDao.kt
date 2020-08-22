package com.example.test.logic.dao

import android.content.ContentValues
import com.example.test.TestApplication.Companion.context
import com.example.test.logic.model.Personal
import com.example.test.logic.model.Sale

object SaleDao {
    fun saveSaleInform(sale: Sale) {
        val name="sale"
        val dbHelper = DailySql(context, name, 1)
        val db = dbHelper.writableDatabase
        val value = ContentValues().apply {
            put("pId", sale.product.pId)
            put("pName", sale.product.productName)
            put("pImage", sale.product.productImage)
            put("intro", sale.product.productIntro)
            put("price", sale.product.productPrice)
        }
        db.insert(name,null,value)
    }
    fun getSaleInform(saleList: List<Sale>) {
        val name="sale"
        val dbHelper=SaleSql(context, "$name.db",1)
        val db=dbHelper.writableDatabase
        val cursor=db.query(name,null,null,null,null,null,null)
        var i=0
        if (cursor.moveToFirst()) {
            do {
                saleList[i].product.pId=cursor.getString(cursor.getColumnIndex("pId"))
                saleList[i].product.productName=cursor.getString(cursor.getColumnIndex("pName"))
                saleList[i].product.productImage=cursor.getInt(cursor.getColumnIndex("pImage"))
                saleList[i].product.productIntro=cursor.getString(cursor.getColumnIndex("intro"))
                saleList[i].product.productPrice=cursor.getFloat(cursor.getColumnIndex("price"))
            }while (cursor.moveToNext())
        }
        cursor.close()
    }
}