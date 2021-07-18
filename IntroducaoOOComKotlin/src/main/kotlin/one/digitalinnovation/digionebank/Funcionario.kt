package one.digitalinnovation.digionebank;

import java.math.BigDecimal

abstract class Funcionario(
     nome:String,
     sobrenome:String,
    var salario:BigDecimal) : Pessoa(nome,sobrenome){
        abstract fun calculoBonus():Float
    }
