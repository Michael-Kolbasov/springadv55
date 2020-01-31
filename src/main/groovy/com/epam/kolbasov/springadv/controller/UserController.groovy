package com.epam.kolbasov.springadv.controller

import com.epam.kolbasov.springadv.service.interfaces.IDomainService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.servlet.ModelAndView

@Controller
@RequestMapping('/users')
class UserController {

    @Autowired
    IDomainService userService

    @GetMapping
    def findAll() {
        def users = userService.findAll()
        new ModelAndView('user/index', [users: users])
    }

    @GetMapping('/json')
    @ResponseBody
    def findAllJson() {
        userService.findAll()
    }
}
