package conta

import MovimentaçãoFinanceira

abstract class Conta(

    val numero:Int,
    val agencia:String,
    private var _valorSaldo:Double=0.0): MovimentaçãoFinanceira {

    init {
        printSaldo()
    }

    fun getSaldo():Double{
        return this._valorSaldo
    }

    fun instanceTypeName():String{
        return this.javaClass.name.drop(6)
    }

    fun printSaldo(){
        println("${instanceTypeName()}: $numero - Agencia: $agencia - Saldo atual: $_valorSaldo ")
    }

    private fun temSaldo(valor: Double): Boolean {
        return (_valorSaldo - valor) >= 0

    }

    abstract fun taxaDeSaque():Double

    override fun depositar(valor:Double){
        _valorSaldo+=valor
        println("Depósito de $valor para ${instanceTypeName()}: $numero " )
        printSaldo()
    }

    override fun sacar(valor:Double){
        val valorTaxa = valor*taxaDeSaque()
       if(temSaldo(valor)){
           println("""
        Saque                      ${instanceTypeName()}
        valor solicitato:          $valor
        taxa de saque:             ${taxaDeSaque()}%
        valor da taxa de saque: R$ ${valorTaxa} 
        """.trimIndent())
            this._valorSaldo-=valor
            this._valorSaldo-=valorTaxa
       }else{
           println("""
               Saque de R$ $valor não realizado por falta de saldo
               Saldo atual: R$ $this._valorSaldo
           """.trimIndent())
       }
        printSaldo()
    }

}



