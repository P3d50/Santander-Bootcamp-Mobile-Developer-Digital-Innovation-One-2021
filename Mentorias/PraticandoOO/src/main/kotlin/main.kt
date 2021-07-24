import cliente.ClientePF
import cliente.ClientePJ
import cliente.Endereco
import conta.ContaCorrente
import conta.ContaPoupanca

fun main() {
    
    var conta1 = ContaCorrente(1,"12")
    var conta2 = ContaPoupanca(2,"12")
    println("*****************************")
    conta1.depositar(79.0)
    conta1.sacar(50.0)
    println("*****************************")
    conta2.depositar(79.0)
    conta2.sacar(50.0)

    val endereco1 = Endereco("Anibal Correia", 1993,"JD. Paulista","Sala 2")
    val endereco2 = endereco1.copy(complemento = "Sala1")

    val cliente = ClientePJ(endereco1,conta1,"84.879.239/0001-73","P3d50")
    cliente.imprimirDados()
    println("*****************************")

    val clientePF = ClientePF(endereco2,conta2,"Pedro Marcos Ramos",30,"34434434454")
    clientePF.imprimirDados()

}