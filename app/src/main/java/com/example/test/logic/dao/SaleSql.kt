package com.example.test.logic.dao

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import com.example.test.TestApplication.Companion.context

class SaleSql(context: Context,name:String,version:Int):SQLiteOpenHelper(context,name,null,version) {

    private val createInform="create table sale ("+
            "pId text primary key autoincrement,"+
            "pName text,"+
            "pImage Image,"+
            "intro text,"+
            "price real)"
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(createInform)
        Toast.makeText(context,"create sale!",Toast.LENGTH_SHORT).show()
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }

}