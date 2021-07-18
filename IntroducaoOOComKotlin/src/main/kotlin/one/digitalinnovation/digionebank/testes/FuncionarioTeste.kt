package one.digitalinnovation.digionebank.testes

import one.digitalinnovation.digionebank.Funcionario
import java.math.BigDecimal

fun main(){
    val pedro = Funcionario("Pedro","Ramos", BigDecimal(564345))
    println("Dados do funcionário - ${pedro.toString()}")
}