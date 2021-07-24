package one.digitalinnovation.collections

fun main() {
    val salarios = doubleArrayOf(1000.0, 2444.4, 4000.4)

    for(salario in salarios){
        println(salario)
    }

    println("Salário máximo:${salarios.maxOrNull()}")
    println("Salário mímino:${salarios.minOrNull()}")
    println("Média salarial:${salarios.average()}")
    val salariosMaiorQue2500 = salarios.filter{it>2500}
    salariosMaiorQue2500.forEach(){
        println(it)
    }

    println(salarios.count { it in 2000.0 .. 5000.0 })
    println(salarios.find { it == 2481.0 })
    println(salarios.find { it == 2444.4 })
    println(salarios.any { it ==1000.0 })
    println(salarios.any { it ==500.0 })


}