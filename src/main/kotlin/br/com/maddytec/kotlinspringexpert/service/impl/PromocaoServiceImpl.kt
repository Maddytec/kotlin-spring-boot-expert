package br.com.maddytec.kotlinspringexpert.service.impl

import br.com.maddytec.kotlinspringexpert.model.Promocao
import br.com.maddytec.kotlinspringexpert.repository.PromocaoRepository
import br.com.maddytec.kotlinspringexpert.service.PromocaoService
import org.springframework.stereotype.Service
import java.util.concurrent.ConcurrentHashMap

@Service
class PromocaoServiceImpl(val promocaoRepository: PromocaoRepository): PromocaoService {

    override fun novaPromocao(promocao: Promocao) = promocaoRepository.save(promocao)

    override fun getPromocao() = promocaoRepository.findAll().toList()

    override fun getPromocaoById(id: Long) = promocaoRepository.findById(id).orElseGet(null)

    override fun getPromocaoFiltro(local: String, descricao: String) = promocaoRepository.findAll().filter {
        it.local.contains(local, true) && it.descricao.contains(descricao, true) }

    override fun atualizarPromocao(id: Long, promocao: Promocao) {
        promocao.id = id
        promocaoRepository.save(promocao)
    }

    override fun removePromocao(id: Long) {
        promocaoRepository.deleteById(id)
    }
}