package br.com.maddytec.kotlinspringexpert.service

import br.com.maddytec.kotlinspringexpert.model.Promocao

interface PromocaoService {

    fun novaPromocao(promocao: Promocao): Promocao

    fun getPromocao(): List<Promocao>

    fun getPromocaoFiltro(local: String, descricao: String): List<Promocao>

    fun atualizarPromocao(id: Long, promocao: Promocao)

    fun removePromocao(id:Long)

    fun getPromocaoById(id: Long): Promocao?
}