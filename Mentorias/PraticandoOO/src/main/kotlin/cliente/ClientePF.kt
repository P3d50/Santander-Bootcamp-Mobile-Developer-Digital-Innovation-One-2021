package cliente

import conta.Conta

class ClientePF(
    endereco:Endereco,
    conta:Conta,
    val nome:String,
    val idade:Int,
    val cpf:String,
    ):Cliente(endereco,conta){

    val segmento: Segmento
        get() = if (conta.getSaldo()> 50){
            Segmento.VAN_GOGH
        }else{
            Segmento.CLASSICO
        }

    override fun imprimirDados() {
        println("""
            Nome:$nome
            Conta:${conta.numero}
            Segmento:$segmento
            ${endereco}
        """.trimIndent())
    }
}