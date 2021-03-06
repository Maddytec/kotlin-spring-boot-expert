package br.com.maddytec.kotlinspringexpert.controller

import br.com.maddytec.kotlinspringexpert.exception.ErrorHandler
import br.com.maddytec.kotlinspringexpert.exception.NotFoundExceptionHandler
import br.com.maddytec.kotlinspringexpert.model.Promocao
import br.com.maddytec.kotlinspringexpert.model.ResponseJson
import br.com.maddytec.kotlinspringexpert.service.PromocaoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cache.annotation.Cacheable
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatus.*
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import org.springframework.web.bind.annotation.ResponseStatus as ResponseStatus

@RestController
@RequestMapping("promocao")
class PromocaoController {

    @Autowired
    lateinit var promocaoService: PromocaoService

    @GetMapping
    fun getPromocao(): ResponseEntity<List<Promocao>> {
       var listaPromocao = promocaoService.getPromocao()

        if(listaPromocao == null || listaPromocao.isEmpty()){
            return ResponseEntity(listaPromocao, NOT_FOUND)
        }

        return ResponseEntity(listaPromocao, OK)

    }

    @GetMapping("/valor/{valor}")
    @ResponseStatus(OK)
    fun findByPrecoAte(@PathVariable valor: Double): List<Promocao> {
        var listaPromocao = promocaoService.findByPrecoAte(valor)

        if(listaPromocao == null || listaPromocao.isEmpty()) {
            throw NotFoundExceptionHandler("Promoção não encontrada com valor menor ou iguala ${valor}")
        }

        return listaPromocao

    }



    @GetMapping("/filtro")
    fun getPromocaoPorFiltro(
        @RequestParam(required = false, defaultValue = "") local: String,
        @RequestParam(required = false, defaultValue = "") descricao: String
    ): ResponseEntity<List<Promocao>> {

        var listaPromocao = promocaoService.getPromocaoFiltro(local, descricao)

        if(listaPromocao == null || listaPromocao.isEmpty()){
            return ResponseEntity(listaPromocao, NOT_FOUND)
        }

        return ResponseEntity(listaPromocao, OK)
    }

    @GetMapping("/paginacao")
    fun getPromocaoPaginacao(
        @RequestParam(required = false, defaultValue = "0") page: Int,
        @RequestParam(required = false, defaultValue = "3") size: Int ): ResponseEntity<List<Promocao>> {

        val listaPromocao = promocaoService.getPromocaoPaginacao(page, size)

        if(listaPromocao == null || listaPromocao.isEmpty()){
            return ResponseEntity(listaPromocao, NOT_FOUND)
        }

        return ResponseEntity(listaPromocao, OK)

    }


    @GetMapping("{id}")
    @ResponseStatus(OK)
    fun getPromocao(@PathVariable id: Long): Promocao {
        var promocao = promocaoService.getPromocaoById(id)?:
        throw NotFoundExceptionHandler("Promoção ${id} não encontrada.")
       return promocao
    }

    @PostMapping
    fun novaPromocao(@RequestBody promocao: Promocao): ResponseEntity<ResponseJson> {
        promocaoService.novaPromocao(promocao)
       var responseJson = ResponseJson("OK", Date())
      return ResponseEntity.ok(responseJson);
    }

    @PutMapping("/{id}")
    @ResponseStatus(ACCEPTED)
    fun atualizarPromocao(@PathVariable id: Long, @RequestBody promocao: Promocao) {
        promocaoService.getPromocaoById(id) ?: throw NotFoundExceptionHandler("Promoção ${id} não encontrada.")
        promocaoService.atualizarPromocao(id, promocao)
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(ACCEPTED)
    fun removePromocao(@PathVariable id: Long){
       promocaoService.getPromocaoById(id) ?: throw NotFoundExceptionHandler("Promoção ${id} não encontrada.")
       promocaoService.removePromocao(id)
    }
}