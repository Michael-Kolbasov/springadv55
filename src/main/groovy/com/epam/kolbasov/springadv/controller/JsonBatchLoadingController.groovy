package com.epam.kolbasov.springadv.controller

import com.epam.kolbasov.springadv.dto.JsonUploadDto
import org.springframework.stereotype.Controller
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView

@Controller
@RequestMapping('/json')
class JsonBatchLoadingController {

    @GetMapping
    def index() {
        'json/index'
    }

    @PostMapping
    def upload(@Validated JsonUploadDto dto) {
        def companies = dto.companies
        def telephones = dto.telephones
        def users = dto.users
        new ModelAndView('json/index', [message: 'Registration succeed'])
    }
}
