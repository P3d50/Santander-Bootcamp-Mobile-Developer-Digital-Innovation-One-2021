package one.digitalinnovation.digionebank

import java.math.BigDecimal

class Conta(
    val agencia:String,
    val numero:String,
    var saldo:BigDecimal) {

    fun depositar(valor:BigDecimal){
    }

    fun saque(valor:BigDecimal){
    }
}

