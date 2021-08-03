package com.p3d50.imc_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_constraint)
        Log.w("lifecycle","onCreate - Criando a tela")
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