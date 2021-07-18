package one.digitalinnovation.digionebank

import java.math.BigDecimal

abstract class Pessoa(
     val nome: String,
     val sobrenome: String,
){

    override fun toString() = "$nome $sobrenome"

}