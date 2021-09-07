package com.p3d50.applicationcontentprovider

import android.database.Cursor

interface PersonClickedListener {

    fun personClickedItem(cursor:Cursor)
    fun personRemoveItem(cursor:Cursor)
}