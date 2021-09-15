package br.com.maddytec.kotlinspringexpert.model

data class Promocao(
    val id: Long,
    val descricao: String,
    val local: String,
    val isAllInclusive: Boolean,
    val quantidadeDias: Int,
    val preco: Double
    )