package one.digitalinnovation.collections

data class Funcionario(
    val nome:String,
    val salario:Double,
    val tipoContratacao:String
){
    override fun toString():String{
        return """
            Nome:$nome
            Salário:$salario
            Tipo de contratação:$tipoContratacao
            
        """.trimIndent()
    }
}