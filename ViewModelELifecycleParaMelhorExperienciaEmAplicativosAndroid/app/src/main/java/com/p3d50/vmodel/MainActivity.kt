package com.p3d50.vmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    lateinit var txtEditContador:EditText
    lateinit var txtContador: TextView
    lateinit var buttonDados: Button
    lateinit var buttonMostrar: Button

    lateinit var mainViewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initDados()
        initClick()

    }

    private fun initDados() {
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        txtEditContador = findViewById(R.id.editTextContador)

        buttonDados = findViewById(R.id.buttonDados)
        buttonMostrar = findViewById(R.id.buttonMostrar)
        mainViewModel.mainViewModelContador.observe(this, Observer  { valor -> txtEditContador.setText(valor)
        } )
    }




    private fun initClick() {
        buttonDados.setOnClickListener {
            mainViewModel.contador()
        }

        buttonMostrar.setOnClickListener {
            Toast.makeText(applicationContext,"Valor contador: ${mainViewModel.mainViewModelContador.value}",Toast.LENGTH_SHORT).show()
        }
    }





}