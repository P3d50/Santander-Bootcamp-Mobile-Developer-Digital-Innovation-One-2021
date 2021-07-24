package conta

class ContaPoupanca(pNumero:Int, pAgengia:String): Conta(pNumero,pAgengia){
    override fun taxaDeSaque():Double{
        return 0.0
    }
}