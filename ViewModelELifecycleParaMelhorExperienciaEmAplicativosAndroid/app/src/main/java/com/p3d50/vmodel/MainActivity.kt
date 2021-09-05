package com.p3d50.vmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
        logar(valor="onCreate")
        initDados()
        initContador()
        initClick()
        validaContador()
    }

    override fun onStart(){
        logar(valor="onStart")
        super.onStart()
    }

    override fun onResume(){
        logar(valor="onResume")
        super.onResume()
    }

    override fun onPause() {
        logar(valor="onPause")
        super.onPause()
    }

    override fun onStop() {
        logar(valor="onStop")
        super.onStop()
    }

    override fun onDestroy() {
        logar(valor="onDestroy")
        super.onDestroy()
    }


    private  fun logar(tag:String="Ciclo de vida", valor:String){
        Log.d(tag,valor)
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