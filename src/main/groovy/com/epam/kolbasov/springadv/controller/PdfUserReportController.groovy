package com.epam.kolbasov.springadv.controller

import com.epam.kolbasov.springadv.service.interfaces.IDomainService
import com.epam.kolbasov.springadv.util.pdf.PdfReportGenerator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.io.InputStreamResource
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping('/pdf')
class PdfUserReportController {

    @Autowired
    IDomainService userService

    @GetMapping(produces = MediaType.APPLICATION_PDF_VALUE)
    def userPdfReport() {
        def users = userService.findAll()
        def generator = new PdfReportGenerator()
        def report = generator.generate(users)

        def headers = new HttpHeaders()
        headers.add("Content-Disposition", "inline; filename=users.pdf");

        ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(report))
    }
}
