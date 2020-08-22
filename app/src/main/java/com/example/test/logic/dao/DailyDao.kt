package com.example.test.logic.dao

import android.content.ContentValues
import com.example.test.TestApplication.Companion.context
import com.example.test.logic.model.Daily
import java.sql.Time

object DailyDao {
    fun savedDailyInform(daily: Daily) {
        val name="daily"
        val dbHelper=DailySql(context,name,1)
        val db=dbHelper.writableDatabase
        val value= ContentValues().apply{
            put("sId",daily.share.sId)
            put("content",daily.share.content)
            put("shareImage",daily.share.shareImage)
        }
        db.insert(name,null,value)
    }

    fun getDailyInform(dailyList: List<Daily>) {
        val name="daily"
        val dbHelper=DailySql(context, "$name.db",1)
        val db=dbHelper.writableDatabase
        val cursor=db.query("daily",null,null,null,null,null,null)
        var i=0
        if (cursor.moveToFirst()) {
            do {
                dailyList[i].share.sId=cursor.getString(cursor.getColumnIndex("sId"))
                dailyList[i].share.content=cursor.getString(cursor.getColumnIndex("content"))
                dailyList[i].share.shareImage=cursor.getInt(cursor.getColumnIndex("shareImage"))
                i++
            }while (cursor.moveToNext())
        }
        cursor.close()
    }
}
