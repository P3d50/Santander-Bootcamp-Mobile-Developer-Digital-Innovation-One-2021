package one.digitalinnovation.collections

fun main(){
    val joao = Funcionario("João",1000.0,"CLT")
    val maria = Funcionario("Maria",4000.0,"CLT")
    val pedro = Funcionario("Pedro",1500.0,"PJ")
    val repositorio = Repositorio<Funcionario>()
    repositorio.create(joao.nome,joao)
    repositorio.create(maria.nome,maria)
    repositorio.create(pedro.nome,pedro)
    println(repositorio.findById(joao.nome))
    println("************************")
    repositorio.findAll().forEach { println(it) }
    println("************************")
    repositorio.remove(maria.nome)
    repositorio.findAll().forEach { println(it) }


}