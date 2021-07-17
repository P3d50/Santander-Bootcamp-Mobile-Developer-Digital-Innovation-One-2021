package one.digitalinnovation.digionebank.testes

import one.digitalinnovation.digionebank.TipoDeCliente


fun main(){
    TipoDeCliente.values().forEach {println("${it.name} - ${it.descricao}") }
}