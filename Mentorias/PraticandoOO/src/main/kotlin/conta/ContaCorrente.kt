package conta

class ContaCorrente(pNumero:Int, pAgencia:String): Conta(pNumero,pAgencia){
    override fun taxaDeSaque():Double{
        return 0.05
    }
}