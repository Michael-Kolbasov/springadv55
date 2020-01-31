package com.epam.kolbasov.springadv.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping('/')
class HomeController {

    @GetMapping
    def index() {
        'index'
    }
}
