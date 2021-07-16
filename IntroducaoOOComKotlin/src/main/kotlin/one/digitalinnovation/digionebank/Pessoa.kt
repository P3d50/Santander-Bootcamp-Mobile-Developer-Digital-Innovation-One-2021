package one.digitalinnovation.digionebank

class Pessoa {

    var nome:String = "Pedro"
    var sobrenome:String ="Ramos"
    var cpf:String = "478.899.999.00"
    private set

    constructor(){

    }

    override fun toString() = "Nome: $nome $sobrenome, CPF: $cpf"

}

fun main(){
    val pedro = Pessoa()
    println("Dados do cliente - ${pedro.toString()}")

}