package br.com.maddytec.kotlinspringexpert.model

data class Promocao(
    var id: Long,
    var descricao: String,
    var local: String,
    var isAllInclusive: Boolean,
    var quantidadeDias: Int,
    var preco: Double
    )