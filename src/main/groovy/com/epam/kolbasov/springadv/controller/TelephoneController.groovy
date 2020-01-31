package com.epam.kolbasov.springadv.controller

import com.epam.kolbasov.springadv.service.interfaces.IDomainService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
@RequestMapping('/telephones')
class TelephoneController {

    @Autowired
    IDomainService telephoneService

    @GetMapping
    @ResponseBody
    def findAll() {
        telephoneService.findAll()
    }
}
