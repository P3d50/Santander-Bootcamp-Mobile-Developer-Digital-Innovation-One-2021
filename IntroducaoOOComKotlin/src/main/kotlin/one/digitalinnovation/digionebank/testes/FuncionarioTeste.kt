package one.digitalinnovation.digionebank.testes

import one.digitalinnovation.digionebank.FuncionarioAnalista
import one.digitalinnovation.digionebank.FuncionarioGerente
import java.math.BigDecimal

fun main(){
    val pedro = FuncionarioAnalista("Pedro","Ramos", 5648.0)
    println("Dados do funcionário - ${pedro.toString()}")

    val andrea = FuncionarioGerente("Andrea","Sales",9000.0,6.0)
    println("Dados do funcionário - ${andrea.toString()}")
}