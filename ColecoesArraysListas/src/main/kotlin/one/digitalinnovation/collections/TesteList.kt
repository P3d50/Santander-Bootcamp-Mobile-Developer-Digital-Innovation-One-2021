package one.digitalinnovation.collections

fun main(){
    val joao = Funcionario("João",1000.0,"CLT")
    val maria = Funcionario("Maria",4000.0,"CLT")
    val pedro = Funcionario("Pedro",1500.0,"PJ")

    val funcionarios = listOf(joao,maria,pedro)
    funcionarios.forEach(){println(it.toString())}
    println("***************************")

    println(funcionarios.find{it.nome=="Maria"})
    println("***************************")

    funcionarios.sortedBy { it.salario }
        .forEach{println(it)}
    println("***************************")

    funcionarios.groupBy { it.tipoContratacao }
        .forEach{println(it)}
    

}

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