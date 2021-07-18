package one.digitalinnovation.digionebank.testes

import one.digitalinnovation.digionebank.FuncionarioAnalista
import one.digitalinnovation.digionebank.FuncionarioGerente
import one.digitalinnovation.digionebank.ImprimeRelatorioFuncionario

fun main(){
    val pedro = FuncionarioAnalista("Pedro","Ramos", 5648.0)
    ImprimeRelatorioFuncionario.imprime(pedro)

    val andrea = FuncionarioGerente("Andrea","Sales",9000.0,6.0,"senha123")
    ImprimeRelatorioFuncionario.imprime(andrea)
    AutenticacaoTeste().autentica(andrea)
}