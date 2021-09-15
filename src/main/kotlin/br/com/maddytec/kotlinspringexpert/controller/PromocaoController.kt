package br.com.maddytec.kotlinspringexpert.controller

import br.com.maddytec.kotlinspringexpert.model.Promocao
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.concurrent.ConcurrentHashMap

@RestController
@RequestMapping("promocao")
class PromocaoController {

        val inicialPromocoes = arrayListOf(
            Promocao(1, "Viagem 1", "teste 1", true, 5, 1500.00,),
            Promocao(2, "Viagem 2", "teste 2", true, 15, 4000.00,),
            Promocao(3, "Viagem 3", "teste 3", false, 8, 2000.00,),
            Promocao(4, "Viagem 4", "teste 4", false, 7, 1900.00,),
            Promocao(5, "Viagem 5", "teste 5", true, 3, 1400.00,)
        )

    var promocoes = ConcurrentHashMap<Long, Promocao>(inicialPromocoes.associateBy(Promocao::id))

    @GetMapping
    fun getPromocao(@RequestParam(required = false, defaultValue = "") localFilter: String) = promocoes.filter {
            it.value.local.contains(localFilter, true)
        }.map(Map.Entry<Long, Promocao>::value ).toList()


    @GetMapping("/{id}")
    fun getPromocao(@PathVariable id: Long) = promocoes[id]

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun novaPromocao(@RequestBody promocao: Promocao): Promocao{
      promocoes[promocao.id] = promocao
      return promocao;
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun atualizarPromocao(@PathVariable id: Long, @RequestBody promocao: Promocao){
        promocoes.remove(id)
        promocoes[promocao.id] = promocao
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun removePromocao(@PathVariable id: Long){
        promocoes.remove(id)
    }
}