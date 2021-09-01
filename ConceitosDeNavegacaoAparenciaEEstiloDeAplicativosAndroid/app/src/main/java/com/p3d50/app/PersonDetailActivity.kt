package com.p3d50.app

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class PersonDetailActivity:AppCompatActivity() {

    private var contact: Contact? = null

    override fun onCreate(savedInstanceState:Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.contact_detail)

        initToolbar()
        getExtras()
        bindViews()
    }

    private fun initToolbar(){
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun getExtras(){
        contact = intent.getParcelableExtra(EXTRA_CONTACT)!!
    }

    private  fun bindViews(){
        findViewById<TextView>(R.id.textViewName).text = contact?.name
        findViewById<TextView>(R.id.textViewPhone).text = contact?.phone
    }
    companion object{
        const val EXTRA_CONTACT:String = "EXTRA_CONTACT"
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}