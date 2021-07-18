package one.digitalinnovation.digionebank

class FuncionarioGerente(
    nome:String,
    sobrenome:String,
    salario:Double,
    bonus:Double?=0.0):Funcionario(nome,sobrenome,salario,6.0) {
    override fun calculoBonus(): Double {
        return (salario* bonus!!)/100
    }
}