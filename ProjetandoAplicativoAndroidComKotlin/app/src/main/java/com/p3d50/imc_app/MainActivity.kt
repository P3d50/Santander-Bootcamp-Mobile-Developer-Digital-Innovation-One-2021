package com.p3d50.imc_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.widget.doAfterTextChanged
import kotlinx.android.synthetic.main.main_constraint.*;

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_constraint)
        setListeners()
        Log.w("lifecycle","onCreate - Criando a tela")
    }


    private fun setListeners(){
        editTextAltura?.doAfterTextChanged {

        }

        editTextPeso?.doAfterTextChanged {

        }


        buttonCalcular?.setOnClickListener {
            calcularIMC(
                editTextPeso.text.toString(),
                editTextAltura.text.toString()
            )
            Log.i("mainActivity","buttonCalcular")
        }

        buttonLimpar?.setOnClickListener {
            limpar()
        }
    }

    private fun limpar(){
        textViewIMC.setTextSize(1,80.0F)
        textViewIMC.text = "IMC"
    }

    private fun calcularIMC(peso:String, altura:String){
     val peso = peso.toFloatOrNull();
     val altura = altura.toFloatOrNull();
     if(peso!=null && altura != null){
         val imc = peso / (altura*altura)
         textViewIMC.setTextSize(1,40.0F)
         textViewIMC.text = "Seu IMC é:\n  %.2f".format(imc)
     }
    }

override fun onStart() {
    super.onStart()
    Log.w("lifecycle","onStart - Tela visível")
}

override fun onResume() {
    super.onResume()
    Log.w("lifecycle","onResume - interação com a tela disponível")
}

override fun onStop() {
    super.onStop()
    Log.w("lifecycle","onStop - Tela não visível, mas ainda existe")
}

override fun onPause() {
    super.onPause()
    Log.w("lifecycle","onPause - a tela perdeu o foco - interação com a deta indisponível")
}

override fun onDestroy() {
    super.onDestroy()
    Log.w("lifecycle","onDestroy - Tela destruída")

}

override fun onRestart() {
    super.onRestart()
    Log.w("lifecycle","onRestart - Tela retomando o foco")
}

}