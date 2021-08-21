package com.p3d50.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val rvList:RecyclerView by lazy{
        findViewById<RecyclerView>(R.id.rv_list)
    }

    private val adapter = ContactAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindViews()
        updateList()
    }

    private fun bindViews(){
        rvList.adapter = adapter
        rvList.layoutManager = LinearLayoutManager(this)
    }

    private fun updateList(){
        adapter.updateList(
            arrayListOf(
                Contact("Pedro Marcos",
                        "11944444444",
                        "img.png"
                ),
                Contact("Andrea Sales",
                    "11944444444",
                    "img.png"
                )
            )
        )
    }

    private fun showToast(message:String) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater:MenuInflater = menuInflater
        inflater.inflate(R.menu.menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId){
            R.id.action_settings-> {
                showToast("Settings")
                true
            }
            R.id.action_exit -> {
                showToast("Exit")
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}