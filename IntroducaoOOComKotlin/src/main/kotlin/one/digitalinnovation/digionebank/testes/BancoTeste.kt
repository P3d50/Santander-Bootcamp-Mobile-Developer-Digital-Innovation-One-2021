package one.digitalinnovation.digionebank.testes

import one.digitalinnovation.digionebank.Banco

fun main(){
    val digOneBank = Banco(nome ="DigOneBank",numero = 777)
    println(digOneBank.toString())

    val digOtherBank = digOneBank.copy(nome ="DigOtherBank")
    println(digOtherBank.toString())

}