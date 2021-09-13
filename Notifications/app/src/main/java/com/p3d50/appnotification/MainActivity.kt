package com.p3d50.appnotification

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.google.firebase.messaging.FirebaseMessaging

class MainActivity : AppCompatActivity() {

    lateinit var buttonSend:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonSend = findViewById(R.id.button_send_notification)
        buttonSend.setOnClickListener {
            this.showNotification("1234","Bootcamp Android", "Kotlin Android Curso")
        }
        Log.i("TokenMessagingService",FirebaseMessaging.getInstance().token.toString())
    }
}