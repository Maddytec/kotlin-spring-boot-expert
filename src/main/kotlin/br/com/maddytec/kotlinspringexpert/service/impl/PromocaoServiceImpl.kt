package br.com.maddytec.kotlinspringexpert.service.impl

import br.com.maddytec.kotlinspringexpert.model.Promocao
import br.com.maddytec.kotlinspringexpert.service.PromocaoService
import org.springframework.stereotype.Service
import java.util.concurrent.ConcurrentHashMap

@Service
class PromocaoServiceImpl: PromocaoService {

    val inicialPromocoes = arrayListOf(
        Promocao(1, "Visita ao Pelourinho e Elevador Lacerda", "Bahia", false, 1, 1000.00,),
        Promocao(2, "Viagem 2", "teste 2", true, 15, 4000.00,),
        Promocao(3, "Viagem 3", "teste 3", false, 8, 2000.00,),
        Promocao(4, "Visita as Praias do Litoral Norte", "Bahia", false, 3, 3000.00,),
        Promocao(5, "Viagem 5", "teste 5", true, 3, 1400.00,)
    )

    var promocoes = ConcurrentHashMap<Long, Promocao>(inicialPromocoes.associateBy(Promocao::id))

    override fun novaPromocao(promocao: Promocao): Promocao {
        promocoes[promocao.id] = promocao
        return promocao
    }

    override fun getPromocao() = promocoes.map(Map.Entry<Long, Promocao>::value)

    override fun getPromocaoById(id: Long) = promocoes[id]

    override fun getPromocaoFiltro(local: String, descricao: String) = promocoes.filter {
        it.value.local.contains(local, true)
                && it.value.descricao.contains(descricao, true)
        }.map(Map.Entry<Long, Promocao>::value).toList()

    override fun atualizarPromocao(id: Long, promocao: Promocao) {
        promocoes.remove(id)
        promocao.id = id
        promocoes[id] = promocao
    }

    override fun removePromocao(id: Long) {
        promocoes.remove(id)
    }
}