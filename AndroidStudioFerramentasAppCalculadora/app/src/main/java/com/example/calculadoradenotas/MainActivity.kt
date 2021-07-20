package com.example.calculadoradenotas

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val btnCalcular:Button = buttonCalcular

        btnCalcular.setOnClickListener {
            val nota1:Int = editTextNota1.text.toString().toInt()
            val nota2:Int = editTextNota2.text.toString().toInt()
            val faltas:Int = editTextFaltas.text.toString().toInt()
            val resultado:TextView = textResultado
            var media = (nota1+nota2)/2
            var aprovado:String

            resultado.setTextSize(20, 50.0F)

            if(media>=6 && faltas<=10){
                aprovado ="Aluno aprovado"
                resultado.setTextColor(Color.GREEN)
            }else{
                aprovado = "Aluno reprovado"
                resultado.setTextColor(Color.BLACK)

            }

                resultado.setText("""
                   Média: $media
                   Quantidade de faltas: $faltas
                   Aproveitamento acadêmico: $aprovado
                """.trimIndent())

        }




    }
}