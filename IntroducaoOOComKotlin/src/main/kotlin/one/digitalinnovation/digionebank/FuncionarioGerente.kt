package one.digitalinnovation.digionebank

class FuncionarioGerente(
    nome:String,
    sobrenome:String,
    salario:Double,
    bonus:Double?=0.0,
    val senha:String):Funcionario(nome,sobrenome,salario,6.0),Logavel {
    override fun calculoBonus(): Double {
        return (salario* bonus!!)/100
    }

    override fun login(): Boolean = "senha123" == senha
}