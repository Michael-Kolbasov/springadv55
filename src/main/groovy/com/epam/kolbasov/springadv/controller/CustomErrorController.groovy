package com.epam.kolbasov.springadv.controller

import org.springframework.boot.web.servlet.error.ErrorController
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView

import javax.servlet.RequestDispatcher
import javax.servlet.http.HttpServletRequest

@Controller
@RequestMapping('/error')
class CustomErrorController implements ErrorController {

    @GetMapping
    def handle(HttpServletRequest request) {
        def statusCode = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE)
        new ModelAndView('error/error',
                [status: statusCode,
                 message: statusCode as Integer == 404 ? 'Not found' : request.getAttribute(RequestDispatcher.ERROR_MESSAGE),
                 exception: request.getAttribute(RequestDispatcher.ERROR_EXCEPTION)]
        )
    }

    @Override
    String getErrorPath() {
        '/error'
    }
}
