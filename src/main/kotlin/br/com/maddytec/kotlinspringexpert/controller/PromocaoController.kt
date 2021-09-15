package br.com.maddytec.kotlinspringexpert.controller

import br.com.maddytec.kotlinspringexpert.model.Promocao
import br.com.maddytec.kotlinspringexpert.service.PromocaoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatus.*
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
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

    @GetMapping("/filtro")
    fun getPromocaoPorLocal(
        @RequestParam(required = false, defaultValue = "") local: String,
        @RequestParam(required = false, defaultValue = "") descricao: String
    ): ResponseEntity<List<Promocao>> {

        var listaPromocao = promocaoService.getPromocaoFiltro(local, descricao)

        if(listaPromocao == null || listaPromocao.isEmpty()){
            return ResponseEntity(listaPromocao, NOT_FOUND)
        }

        return ResponseEntity(listaPromocao, OK)
    }


    @GetMapping("{id}")
    fun getPromocao(@PathVariable id: Long): ResponseEntity<Promocao> {
        var promocao = promocaoService.getPromocaoById(id)
        var status = if( promocao == null) NOT_FOUND else OK
        return ResponseEntity(promocao, status)

    }

    @PostMapping
    fun novaPromocao(@RequestBody promocao: Promocao): ResponseEntity<Map<String, Promocao>> {
        promocaoService.novaPromocao(promocao)
       var map = mapOf("promocao" to promocao)
      return ResponseEntity.ok(map);
    }

    @PutMapping("/{id}")
    fun atualizarPromocao(@PathVariable id: Long, @RequestBody promocao: Promocao): ResponseEntity<Nothing> {
        if(promocaoService.getPromocaoById(id) != null) {
            promocaoService.atualizarPromocao(id, promocao)
            return ResponseEntity(null, ACCEPTED)
        }
        return ResponseEntity(null, NOT_FOUND)

    }


    @DeleteMapping("/{id}")
    fun removePromocao(@PathVariable id: Long): ResponseEntity<Nothing> {
        if(promocaoService.getPromocaoById(id) != null) {
            promocaoService.removePromocao(id)
            return ResponseEntity(null, ACCEPTED)
        }
        return ResponseEntity(null, NOT_FOUND)

    }
}