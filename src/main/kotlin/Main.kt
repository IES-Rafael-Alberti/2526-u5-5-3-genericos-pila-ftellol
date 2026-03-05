package org.iesra.revilofe

class Pila<T>: Iterable<T> {
    val elementos = mutableListOf<T>()

    fun push(elemento: T) {
        elementos.add(elemento)
    }

    fun pop(): T {
        return elementos.removeAt(elementos.size - 1)
    }

    fun peek(): T {
        return elementos[elementos.size - 1]
    }

    fun isEmpty(): Boolean {
        return elementos.isEmpty()
    }

    fun size(): Int {
        return elementos.size
    }

    override fun iterator(): Iterator<T> {
        return object : Iterator<T> {

            var index = elementos.size - 1

            override fun hasNext(): Boolean {
                return index >= 0
            }

            override fun next(): T {
                val valor = elementos[index]
                index = index - 1
                return valor
            }
        }
    }
}

fun <T> reverse(lista: List<T>): List<T> {
    val pila = Pila<T>()

    val listaIterador = lista.iterator()

    while (listaIterador.hasNext()) {
        pila.push(listaIterador.next())
    }

    val resultado = mutableListOf<T>()

    for (elemento in pila) {
        resultado.add(elemento)
    }

    return resultado
}

fun main() {
    val numbers = listOf("one", "two", "three", "four")
    val numbersRev = reverse(numbers)

    if (listOf("four", "three", "two", "one") != numbersRev) {
        println("Error")
    } else {
        println("Correcto")
    }

    println(numbersRev)
}
