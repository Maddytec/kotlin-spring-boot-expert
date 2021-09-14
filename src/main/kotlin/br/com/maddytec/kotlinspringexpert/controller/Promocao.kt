package br.com.maddytec.kotlinspringexpert.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("promocao")
class Promocao {

    @GetMapping
    fun olaMundo(): String{
        return "Olá Mundo"
    }

}