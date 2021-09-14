package br.com.maddytec.kotlinspringexpert

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinSpringExpertApplication

fun main(args: Array<String>) {
	runApplication<KotlinSpringExpertApplication>(*args)
}