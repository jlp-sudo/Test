package com.example.test.logic.dao

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import com.example.test.TestApplication.Companion.context

class DailySql(context: Context, name:String, version:Int):SQLiteOpenHelper(context,name,null,version) {
    private val createDaily="create table daily ("+
            "sId text primary key autoincrement,"+
            "content text,"+
            "shareImage Image)"
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(createDaily)
        Toast.makeText(context,"create daily!",Toast.LENGTH_SHORT).show()
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }

}