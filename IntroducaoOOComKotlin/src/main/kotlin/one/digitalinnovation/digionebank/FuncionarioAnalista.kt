package one.digitalinnovation.digionebank

import java.math.BigDecimal

class FuncionarioAnalista(
    nome:String,
    sobrenome:String,
    salario:Double,
):Funcionario(nome, sobrenome, salario,5.0) {
    override fun calculoBonus(): Double {
        return (salario* bonus!!)/100
    }


}