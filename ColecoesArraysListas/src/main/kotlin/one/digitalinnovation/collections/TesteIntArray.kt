package one.digitalinnovation.collections

fun main(){
    val values = IntArray(5)
    values[0] = 5
    values[1] = 4
    values[2] = 3
    values[3] = 2
    values[4] = 1

    for (valor in values){
        println(valor)
    }

    values.forEach{
        println(it)
    }

    values.sort()
    for(valor in values){
        println(valor)
    }
}


