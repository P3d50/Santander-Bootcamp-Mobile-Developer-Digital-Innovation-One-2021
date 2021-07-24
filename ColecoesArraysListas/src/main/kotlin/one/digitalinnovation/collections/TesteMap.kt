package one.digitalinnovation.collections

fun main(){

    val pair:Pair<String,Double> = Pair("João",100.0)
    val map1 = mapOf(pair)
    map1.forEach{(k,v) ->println("""
        Chave:$k
        Valor:$v
    """.trimIndent())}

    val map2 = mapOf(
        "Pedro" to 2500.0,
        "Maria" to 3000.0)
        .forEach { (k,v)->println("Chave:$k - valor: $v") }
}