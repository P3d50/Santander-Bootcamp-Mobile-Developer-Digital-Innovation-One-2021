package cliente

import conta.Conta

abstract class Cliente(
    val endereco:Endereco,
    val conta: Conta,
) {
    abstract fun imprimirDados()
}