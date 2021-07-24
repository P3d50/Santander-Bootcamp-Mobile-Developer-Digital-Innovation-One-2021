package cliente

import conta.Conta
import conta.ContaCorrente

class ClientePJ(
    endereco:Endereco,
    conta: ContaCorrente,
    val cnpj:String,
    val razaoSocial:String):Cliente(endereco,conta) {

    override fun imprimirDados() {
        println("""
            Razão social: $razaoSocial
            Conta:${conta.numero}
            CNPJ:$cnpj
            $endereco
        """.trimIndent())
    }
}