package br.com.maddytec.kotlinspringexpert.controller

import br.com.maddytec.kotlinspringexpert.model.Promocao
import br.com.maddytec.kotlinspringexpert.service.PromocaoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("promocao")
class PromocaoController {

    @Autowired
    lateinit var promocaoService: PromocaoService

    @GetMapping
    fun getPromocao() = promocaoService.getPromocao()

    @GetMapping("/filtro")
    fun getPromocaoPorLocal(
        @RequestParam(required = false, defaultValue = "") local: String,
        @RequestParam(required = false, defaultValue = "") descricao: String
    ) = promocaoService.getPromocaoFiltro(local, descricao)


    @GetMapping("/{id}")
    fun getPromocao(@PathVariable id: Long) = promocaoService.getPromocaoById(id)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun novaPromocao(@RequestBody promocao: Promocao): Promocao{
        promocaoService.novaPromocao(promocao)
      return promocao;
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun atualizarPromocao(@PathVariable id: Long, @RequestBody promocao: Promocao){
        promocaoService.atualizarPromocao(id, promocao)
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun removePromocao(@PathVariable id: Long){
        promocaoService.removePromocao(id)
    }
}