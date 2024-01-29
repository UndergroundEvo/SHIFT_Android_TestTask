package com.shift.persongeneratorxml.db

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase

class DbManager(val context: Context) {
    val myDbHelper = DbHelper(context)
    var db: SQLiteDatabase? = null

    fun openDb(){
        db = myDbHelper.writableDatabase
    }
    fun insertToDb(key: String,
                   name: String,
                   email: String,
                   birthday: String,
                   address: String,
                   number: String,
                   password: String,
                   thumbnail: String,
                   picture: String
    ){
        val values = ContentValues().apply {
            put(DbName.COLUMN_KEY, key)
            put(DbName.COLUMN_NAME, name)
            put(DbName.COLUMN_EMAIL, email)
            put(DbName.COLUMN_BIRTHDAY, birthday)
            put(DbName.COLUMN_ADDRESS, address)
            put(DbName.COLUMN_NUMBER, number)
            put(DbName.COLUMN_PASSWORD, password)
            put(DbName.COLUMN_THUMBNAIL, thumbnail)
            put(DbName.COLUMN_PICTURE, picture)
        }
        db?.insert(DbName.TABLE_NAME,null, values)
    }

    @SuppressLint("Range") /*💀🔫*/
    fun readFromDb() : ArrayList<String>{
        val dataList = ArrayList<String>()
        val cursor = db?.query(
            DbName.TABLE_NAME,
            null,
            null,
            null,
            null,
            null,
            null
        )
        with(cursor){
            while (this?.moveToNext()!!){
                var dataText = cursor?.getString(cursor.getColumnIndex(DbName.COLUMN_KEY))
                dataList.add(dataText.toString())
                dataText = cursor?.getString(cursor.getColumnIndex(DbName.COLUMN_NAME))
                dataList.add(dataText.toString())
                dataText = cursor?.getString(cursor.getColumnIndex(DbName.COLUMN_EMAIL))
                dataList.add(dataText.toString())
                dataText = cursor?.getString(cursor.getColumnIndex(DbName.COLUMN_BIRTHDAY))
                dataList.add(dataText.toString())
                dataText = cursor?.getString(cursor.getColumnIndex(DbName.COLUMN_ADDRESS))
                dataList.add(dataText.toString())
                dataText = cursor?.getString(cursor.getColumnIndex(DbName.COLUMN_NUMBER))
                dataList.add(dataText.toString())
                dataText = cursor?.getString(cursor.getColumnIndex(DbName.COLUMN_PASSWORD))
                dataList.add(dataText.toString())
                dataText = cursor?.getString(cursor.getColumnIndex(DbName.COLUMN_THUMBNAIL))
                dataList.add(dataText.toString())
                dataText = cursor?.getString(cursor.getColumnIndex(DbName.COLUMN_PICTURE))
                dataList.add(dataText.toString())
            }
        }
        cursor?.close()
        return dataList
    }
    fun closeDb(){
        myDbHelper.close()
    }
}