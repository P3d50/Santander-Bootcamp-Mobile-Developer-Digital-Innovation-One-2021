package one.digitalinnovation.digionebank

class Cliente(
    nome:String,
    cpf:String,
    val clienteTipo:TipoDeCliente,
    val senha:String):Pessoa(nome, cpf),Logavel {
    override fun login(): Boolean = "senha123" == senha

    override fun toString(): String = """
        nome: $nome
        sobrenome: $sobrenome
        tipo: ${clienteTipo.descricao}
    """.trimIndent()

}