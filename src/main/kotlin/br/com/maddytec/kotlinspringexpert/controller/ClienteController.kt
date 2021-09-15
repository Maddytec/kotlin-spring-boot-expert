package br.com.maddytec.kotlinspringexpert.controller

import br.com.maddytec.kotlinspringexpert.model.Cliente
import br.com.maddytec.kotlinspringexpert.model.Telefone
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("cliente")
class ClienteController {

    @GetMapping
    fun getCliente() = Cliente(1,"Madson Silva", Date(), Telefone("11","99999-9999", "Comercial"))
}