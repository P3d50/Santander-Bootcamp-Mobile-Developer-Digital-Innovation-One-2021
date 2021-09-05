package com.p3d50.vmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var txtEditContador:EditText
    lateinit var txtContador: TextView
    lateinit var buttonDados: Button
    lateinit var buttonMostrar: Button

    var contador:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initDados()
        initContador()
        initClick()
        validaContador()
    }

    private fun validaContador() {
        if (contador>5)
        {
            contador=0
        }
    }

    private fun initClick() {
        buttonDados.setOnClickListener {
            this.contador++
            validaContador()
            initContador()
        }

        buttonMostrar.setOnClickListener {
            Toast.makeText(this,"Valor contador: $contador",Toast.LENGTH_SHORT).show()
        }
    }

    private fun initContador() {
        txtEditContador.setText(contador.toString())
    }

    private fun initDados() {
        txtEditContador = findViewById(R.id.editTextContador)

        txtContador = findViewById(R.id.textContador)
        buttonDados = findViewById(R.id.buttonDados)
        buttonMostrar = findViewById(R.id.buttonMostrar)
    }


}