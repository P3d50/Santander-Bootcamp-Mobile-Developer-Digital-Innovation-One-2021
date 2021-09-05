package com.p3d50.applicationcontentprovider.database

import android.content.ContentProvider
import android.content.ContentValues
import android.content.Context
import android.content.UriMatcher
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.media.UnsupportedSchemeException
import android.net.Uri
import android.provider.BaseColumns._ID
import com.p3d50.applicationcontentprovider.database.PersonsDatabaseHelper.Companion.TABLE_PERSONS

class PeopleProvider : ContentProvider() {


    private lateinit var mUriMatcher: UriMatcher
    private lateinit var dbHelper: PersonsDatabaseHelper
    override fun onCreate(): Boolean {
        mUriMatcher = UriMatcher(UriMatcher.NO_MATCH)
        mUriMatcher.addURI(AUTHORITY, "persons", PERSONS)
        mUriMatcher.addURI(AUTHORITY,"persons/#", PERSONS_BY_ID)
        if(context!=null) {
            dbHelper = PersonsDatabaseHelper(context as Context)
        }
        return true
    }

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<String>?): Int {
        if(mUriMatcher.match(uri)== PERSONS_BY_ID){
            val db: SQLiteDatabase = dbHelper.writableDatabase
            val linesAffect: Int = db.delete(TABLE_PERSONS,"$_ID=?",arrayOf(uri.lastPathSegment))
            db.close()
            context?.contentResolver?.notifyChange(uri,null)
            return linesAffect
        }else{
            throw UnsupportedSchemeException("Uri inválida para exclusão")
        }

    }

    override fun getType(uri: Uri): String? = throw  UnsupportedSchemeException("Uri não suportada")

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        if(mUriMatcher.match(uri)== PERSONS){
            val db: SQLiteDatabase= dbHelper.writableDatabase
            val id = db.insert(TABLE_PERSONS,null,values)
            val insertUri = Uri.withAppendedPath(BASE_URI,id.toString())
            db.close()
            context?.contentResolver?.notifyChange(uri,null)
            return insertUri

        }else{
            throw UnsupportedSchemeException("Uri inválida para inserção")
        }
    }


    override fun query(
        uri: Uri, projection: Array<String>?, selection: String?,
        selectionArgs: Array<String>?, sortOrder: String?
    ): Cursor? {

        return when{
            mUriMatcher.match(uri)== PERSONS -> {
                val db:SQLiteDatabase = dbHelper.writableDatabase
                val cursor:Cursor = db.query(TABLE_PERSONS,projection,selection,selectionArgs,null,null,sortOrder)
                cursor.setNotificationUri(context?.contentResolver,uri)
                cursor

            }
            mUriMatcher.match(uri)== PERSONS_BY_ID ->{
                val db:SQLiteDatabase = dbHelper.writableDatabase
                val cursor = db.query(TABLE_PERSONS,projection,"$_ID=?", arrayOf(uri.lastPathSegment),null,null,sortOrder)
                cursor.setNotificationUri((context as Context).contentResolver,uri)
                cursor

            }
            else ->{
                throw  UnsupportedSchemeException("Uri não suportada")
            }
        }
    }

    override fun update(
        uri: Uri, values: ContentValues?, selection: String?,
        selectionArgs: Array<String>?
    ): Int {
        if(mUriMatcher.match(uri)== PERSONS_BY_ID){
            val db:SQLiteDatabase = dbHelper.writableDatabase
            val linesAffect = db.update(TABLE_PERSONS,values,"$_ID", arrayOf(uri.lastPathSegment))
            db.close()
            context?.contentResolver?.notifyChange(uri,null)
            return linesAffect
        }else{
            throw UnsupportedSchemeException("Uri não suportada")
        }
    }

    companion object{
        const val AUTHORITY = "com.p3d50.applicationcontentprovider.provider"
        val BASE_URI =Uri.parse("content://$AUTHORITY")
        val URI_PERSONS = Uri.withAppendedPath(BASE_URI,"persons")
        const val PERSONS = 1
        const val PERSONS_BY_ID = 2
    }
}