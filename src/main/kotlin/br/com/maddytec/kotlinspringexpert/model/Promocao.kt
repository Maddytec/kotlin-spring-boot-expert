package br.com.maddytec.kotlinspringexpert.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Promocao(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 1,
    var descricao: String = "",
    var local: String = "",
    var isAllInclusive: Boolean = false,
    var quantidadeDias: Int = 0,
    var preco: Double = 0.0
    )