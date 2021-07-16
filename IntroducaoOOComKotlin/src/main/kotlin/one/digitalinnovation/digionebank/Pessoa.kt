package one.digitalinnovation.digionebank

class Pessoa {

    var nome:String = "Pedro"
    var sobrenome:String ="Ramos"
    var cpf:String = "478.899.999.00"
    private set

}

fun main(){
    val pedro = Pessoa()
    println("Dados pessoais:\n Nome: ${pedro.nome} ${pedro.sobrenome} \n CPF: ${pedro.cpf}  ")

}