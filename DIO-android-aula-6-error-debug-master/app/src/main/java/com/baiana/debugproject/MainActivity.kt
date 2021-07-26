package com.baiana.debugproject

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var click = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setLogListeners()

        val currentThread = Thread.currentThread()
        currentThread.setUncaughtExceptionHandler { _, throwable ->
            val cause = throwable.cause
            println("$cause")
        }

    }

    private fun setLogListeners() {
        //todo altere os logs e adicione mais possibilidade de exceptions
        debugBTN?.setOnClickListener { Log.d("click", "Opa! cliquei no debug ") }
        errorBTN?.setOnClickListener {
            ++click
            Log.e("click","Opa! cliquei no error :$click")
            indexOutOfBoundTryCatch()
        }
        infoBTN?.setOnClickListener { Log.i("click", "Opa! cliquei no info") }
        warningBTN?.setOnClickListener { Log.w("click", "Opa! cliquei no warning") }
        verboseBTN?.setOnClickListener { Log.v("click", "Opa! cliquei no verbose") }
    }

    private fun indexOutOfBoundTryCatch() {
        var message: String = ""
        try {
            val list = listOf<Int>(2, 1, 4)
            val crashInt: Int = list[2]
            message = "Sobrevivi ao try"
        } catch (e: IndexOutOfBoundsException) {
            message = "entrei no catch certo :)"
        } finally {
            inputEDT?.setText(message)
            val t = 35
        }
    }
}