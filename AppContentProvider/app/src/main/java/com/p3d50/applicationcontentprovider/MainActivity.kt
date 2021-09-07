package com.p3d50.applicationcontentprovider

import android.database.Cursor
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.BaseColumns._ID
import androidx.loader.app.LoaderManager
import androidx.loader.content.CursorLoader
import androidx.loader.content.Loader
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.p3d50.applicationcontentprovider.database.PeopleProvider.Companion.URI_PERSONS
import com.p3d50.applicationcontentprovider.database.PersonsDatabaseHelper.Companion.FIRST_NAME

class MainActivity : AppCompatActivity(),LoaderManager.LoaderCallbacks<Cursor> {

    lateinit var personRecyclerView: RecyclerView
    lateinit var personAdd:FloatingActionButton

    lateinit var adapter: PersonAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        personAdd = findViewById(R.id.person_add)
        personAdd.setOnClickListener{
            PersonDetailFragment().show(supportFragmentManager,"dialog")
        }
        personRecyclerView = findViewById(R.id.person_recycler)

        adapter= PersonAdapter(object :PersonClickedListener{
            override fun personClickedItem(cursor:Cursor){
                val id:Long = cursor.getLong(cursor.getColumnIndex(_ID))
                val fragment=PersonDetailFragment.newInstance(id)
                fragment.show(supportFragmentManager,"dialog")
            }

            override fun personRemoveItem(cursor: Cursor) {
                val id:Long = cursor.getLong(cursor.getColumnIndex(_ID))
                contentResolver.delete(Uri.withAppendedPath(URI_PERSONS,id.toString()),null,null)
            }
        })

        adapter.setHasStableIds(true)
        personRecyclerView = findViewById(R.id.person_recycler)
        personRecyclerView.layoutManager = LinearLayoutManager(this)
        personRecyclerView.adapter = adapter

        LoaderManager.getInstance(this).initLoader(0,null,this)

    }

    override fun onCreateLoader(id: Int, args: Bundle?): Loader<Cursor> = CursorLoader(this, URI_PERSONS,null,null,null,FIRST_NAME)


    override fun onLoadFinished(loader: Loader<Cursor>, data: Cursor?) {
        if(data!=null){ adapter.setCursor(data) }
    }

    override fun onLoaderReset(loader: Loader<Cursor>) {
        adapter.setCursor(null)
    }
}