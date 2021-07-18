package one.digitalinnovation.digionebank.testes

import one.digitalinnovation.digionebank.Cliente
import one.digitalinnovation.digionebank.TipoDeCliente

fun main() {
    val pedro = Cliente("Pedro","ramos",TipoDeCliente.PF,"senha123")
    println(pedro)
    AutenticacaoTeste().autentica(pedro)
}