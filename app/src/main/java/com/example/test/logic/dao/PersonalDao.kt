package com.example.test.logic.dao

import android.content.ContentValues
import com.example.test.TestApplication.Companion.context
import com.example.test.logic.model.Daily
import com.example.test.logic.model.Personal

object PersonalDao {

    fun savePersonalInform(personal: Personal) {
        val name="personal"
        val dbHelper=PersonalSql(context,name,1)
        val db=dbHelper.writableDatabase
        val value=ContentValues().apply {
            put("id",personal.id)
            put("name",personal.basicInform.name)
            put("image",personal.basicInform.headImage)
            put("age",personal.age)
            put("sex",personal.basicInform.sex)
        }
        db.insert("name",null,value)
    }
    fun getPersonalInform( personalList: List<Personal>) {
        val name="personal"
        val dbHelper=PersonalSql(context, "$name.db",1)
        val db=dbHelper.writableDatabase
        val cursor=db.query(name,null,null,null,null,null,null)
        var i=0
        if (cursor.moveToFirst()) {
            do {
                personalList[i].id=cursor.getString(cursor.getColumnIndex("id"))
                personalList[i].basicInform.name=cursor.getString(cursor.getColumnIndex("content"))
                personalList[i].basicInform.headImage=cursor.getInt(cursor.getColumnIndex("headImage"))
                personalList[i].age=cursor.getInt(cursor.getColumnIndex("age"))
                personalList[i].basicInform.sex=cursor.getString(cursor.getColumnIndex("sex"))
                i++
            }while (cursor.moveToNext())
        }
        cursor.close()
    }

}