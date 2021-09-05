package com.p3d50.vmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    var mainViewModelContador= MutableLiveData<String>().apply{value=contador.toString()}
    private var contador: Int =0

    private fun setMainViewModelContador(){
        mainViewModelContador.value =contador.toString()
    }

    private fun validaContador() {
        contador++
        if (contador>5)
        {
            contador=0
        }

        setMainViewModelContador()
    }
    fun contador(){
        validaContador()
    }

}