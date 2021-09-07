package com.p3d50.applicationcontentproviderclient

import android.database.Cursor
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    lateinit var personsRecyclerView: RecyclerView
    lateinit var personsRefreshButton: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        personsRefreshButton = findViewById(R.id.person_button_refresh)
        personsRecyclerView = findViewById(R.id.person_list)

        personsRefreshButton.setOnClickListener {
                getContentProvider()
        }
    }

    private fun getContentProvider(){
        try{
            val url ="content://com.p3d50.applicationcontentprovider.provider/persons"
            val data = Uri.parse(url)
            val cursor:Cursor? = contentResolver.query(data,null,null,null,"first_name")
            personsRecyclerView.apply {
                layoutManager = LinearLayoutManager(this@MainActivity)
                adapter = PersonAdapter(cursor as Cursor)
            }
        }catch (ex:Exception){
            ex.printStackTrace()
        }
    }
}