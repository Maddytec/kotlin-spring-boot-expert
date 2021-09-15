package br.com.maddytec.kotlinspringexpert.exception

import br.com.maddytec.kotlinspringexpert.model.ErrorMessage
import com.fasterxml.jackson.core.JsonParseException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@ControllerAdvice
class ErrorHandler {

    @ExceptionHandler(JsonParseException::class)
    fun jsonFormatExceptionHandler(servletRequest: HttpServletRequest, servletResponse: HttpServletResponse, exception: Exception): ResponseEntity<ErrorMessage> {
        return ResponseEntity(ErrorMessage("Json Error", exception.message ?: "Json invalido"), HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(NotFoundExceptionHandler::class)
    fun notFoundExceptionHandler(servletRequest: HttpServletRequest, servletResponse: HttpServletResponse, exception: Exception): ResponseEntity<ErrorMessage> {
        return ResponseEntity(ErrorMessage("Não encontrado(a).", exception.message !!), HttpStatus.NOT_FOUND)
    }
}