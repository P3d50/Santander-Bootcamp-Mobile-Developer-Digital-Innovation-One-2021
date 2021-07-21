package one.digitalinnovation.collections

fun main(){
    val salarios = DoubleArray(3)
    salarios[0] = 3000.0
    salarios[1] = 1000.0
    salarios[2] = 5000.0

    salarios.forEach {
        println("Salário: $it")
    }

    salarios.sort()
    salarios.forEachIndexed { index, salario ->
        salarios[index] = salario*1.1
        println("Salário: ${salarios[index]}")
    }
}