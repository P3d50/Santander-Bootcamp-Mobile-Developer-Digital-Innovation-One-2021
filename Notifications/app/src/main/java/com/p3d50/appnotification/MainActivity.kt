package com.p3d50.appnotification

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var buttonSend:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonSend = findViewById(R.id.button_send_notification)
        buttonSend.setOnClickListener {
            this.showNotification("123","Bootcamp Android", "Kotlin Android Curso")
        }
    }
}