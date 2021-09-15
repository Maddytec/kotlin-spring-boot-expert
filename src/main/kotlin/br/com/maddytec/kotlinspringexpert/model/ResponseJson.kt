package br.com.maddytec.kotlinspringexpert.model

import com.fasterxml.jackson.annotation.JsonFormat
import java.util.*

data class ResponseJson(val message: String = "",
                       @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy") var dataHora: Date)
