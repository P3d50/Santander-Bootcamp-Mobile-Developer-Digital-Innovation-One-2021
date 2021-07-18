package one.digitalinnovation.digionebank;

import java.math.BigDecimal

abstract class Funcionario(
     nome:String,
     sobrenome:String,
    var salario:Double,
    var bonus:Double?=0.0) : Pessoa(nome,sobrenome){
        abstract fun calculoBonus():Double

        override fun toString():String{
            return "$nome $sobrenome, salário: R$ $salario, bonus: $bonus % - R$ ${this.calculoBonus()}, salário com bonus: R$ ${salario+this.calculoBonus()}"
        }
    }
