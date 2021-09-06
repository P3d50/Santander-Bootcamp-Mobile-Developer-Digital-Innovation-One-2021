package com.p3d50.applicationcontentprovider

import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.loader.app.LoaderManager
import androidx.loader.content.CursorLoader
import androidx.loader.content.Loader
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.p3d50.applicationcontentprovider.database.PeopleProvider.Companion.URI_PERSONS
import com.p3d50.applicationcontentprovider.database.PersonsDatabaseHelper.Companion.FIRST_NAME

class MainActivity : AppCompatActivity(),LoaderManager.LoaderCallbacks<Cursor> {

    lateinit var personRecyclerView: RecyclerView
    lateinit var personAdd:FloatingActionButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        personAdd = findViewById(R.id.person_add)
        personRecyclerView = findViewById(R.id.person_recycler)
    }

    override fun onCreateLoader(id: Int, args: Bundle?): Loader<Cursor> = CursorLoader(this, URI_PERSONS,null,null,null,FIRST_NAME)


    override fun onLoadFinished(loader: Loader<Cursor>, data: Cursor?) {
        if(data!=null){

        }
    }

    override fun onLoaderReset(loader: Loader<Cursor>) {
        TODO("Not yet implemented")
    }
}