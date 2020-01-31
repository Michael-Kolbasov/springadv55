package com.epam.kolbasov.springadv.controller.advice

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.servlet.ModelAndView

import javax.servlet.http.HttpServletResponse

@ControllerAdvice
class ErrorControllerAdvice {

    @ExceptionHandler(Exception)
    @ResponseStatus
    def handle(Exception e) {
        new ModelAndView('error/error',
                [status: HttpStatus.INTERNAL_SERVER_ERROR.value(),
                 message: e.getMessage(),
                 exception: e.class.simpleName]
        )
    }
}
