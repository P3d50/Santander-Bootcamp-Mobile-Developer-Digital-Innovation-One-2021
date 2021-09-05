package com.p3d50.applicationcontentprovider.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns._ID

class PersonsDatabaseHelper(context:Context):SQLiteOpenHelper(context,"databasePersons",null,1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE IF NOT EXISTS $TABLE_PERSONS(" +
                "$_ID INTEGER NOT NULL PRIMARY KEY," +
                "$FIRST_NAME TEXT NOT NULL," +
                "$LAST_NAME TEXT NOT NULL," +
                "$CPF TEXT(13) NOT NULL," +
                "$BIRTHDATE TEXT)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }


    companion object{
        const val TABLE_PERSONS:String = "PERSONS"
        const val FIRST_NAME:String = "first_name"
        const val LAST_NAME:String = "last_name"
        const val CPF:String="cpf"
        const val BIRTHDATE ="birthdate"

    }
}