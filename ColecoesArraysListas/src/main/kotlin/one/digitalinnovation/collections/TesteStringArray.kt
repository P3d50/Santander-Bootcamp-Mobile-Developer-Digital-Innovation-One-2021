package one.digitalinnovation.collections

fun main(){
    val nomes = Array(3){""}
    nomes[0] = "Pedro"
    nomes[1] = "Rafaela"
    nomes[2] = "Andrea"

    for(nome in nomes){
        println(nome)
    }
    nomes.sort()
    nomes.forEach {
        println(it)
    }

    val nomes2 = arrayOf("Janaina", "Maria", "Bruna")
    nomes2.forEach {
        println(it)
    }
}