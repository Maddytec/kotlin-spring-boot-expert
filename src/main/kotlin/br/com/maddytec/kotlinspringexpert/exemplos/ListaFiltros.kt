package br.com.maddytec.kotlinspringexpert.exemplos

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import kotlin.random.Random

@Configuration
class ListaFiltros {

    //@Bean
    fun main(){
        var n = 10
        var listaOfNumber =  List(n) { Random.nextInt(0,n) }
        var listaOfDouble =  List(n) {Random.nextDouble(0.0, n.toDouble())};
        var listaOfNames = listOf("Alef", "Ariel","Bruno", "Carlos","Eduardo","Fabio","Gabriel","Madson", "Marcos", "Pablo", "Vitor")
        println("Lista de numeros: " + listaOfNumber)
        println("Lista de double: " + listaOfDouble)
        println("Lista de numeros maiores que o numero cinco: " + listaMaiorCinco(listaOfNumber))
        println("Lista de numeros pares: " + listaNumeroPar(listaOfNumber))
        println("Lista de numeros impares: " + listaNumeroImpar(listaOfNumber))
        println("Lista de numeros multiplicados por dois: " + listaNumeroMultiplicadoPorDois(listaOfNumber))
        println("Media dos valores da lista: " + listaSomaNumero(listaOfNumber) / listaOfNumber.size)
        println("Lista de nomes que começam com a letra informada: " + listaNomesQueComecamComLetraInformada("M", listaOfNames))
        println("Calculo da raiz quadrada dos numeros da Lista: " + listaNumeroRaizQuadrada(listaOfDouble))
    }

    fun listaMaiorCinco(lista: List<Int>) = lista.filter{it >= 5}

    fun listaNumeroPar(lista: List<Int>) = lista.filter { it % 2 == 0}

    fun listaNumeroMultiplicadoPorDois(lista: List<Int>) = lista.map { it * 2 }

    fun listaNumeroRaizQuadrada(lista: List<Double>) = lista.map { Math.sqrt(it) }

    fun listaSomaNumero(lista: List<Int>) = lista.reduce{ soma, numero -> soma + numero}

    fun listaNomesQueComecamComLetraInformada(letra: String, lista: List<String>) = lista.filter { it.startsWith(letra) }

    fun listaNumeroImpar(lista: List<Int>) = lista.filter { it % 2 != 0 }

}