package br.com.maddytec.kotlinspringexpert.model

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*

@JsonInclude(JsonInclude.Include.NON_NULL)
data class Cliente(
                    @JsonProperty("codigo") val id: Long
                    , val nome: String,
                    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy") val dataNascimento: Date
                    , var telefone: Telefone?)

data class Telefone(val ddd: String = "", val numero: String = "", val tipo: String = "")
