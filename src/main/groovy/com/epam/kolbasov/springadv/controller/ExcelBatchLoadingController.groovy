package com.epam.kolbasov.springadv.controller

import com.epam.kolbasov.springadv.service.interfaces.IExcelRegistrationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.io.ClassPathResource
import org.springframework.http.MediaType
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.servlet.mvc.support.RedirectAttributes

import javax.servlet.http.HttpServletResponse

@Controller
@RequestMapping(path = "/batch")
class ExcelBatchLoadingController {
    private static final String TEMPLATE_LOCATION = 'static/batchtemplate/springadvbatch.xlsx'

    @Autowired
    IExcelRegistrationService excelService

    @GetMapping
    def index() {
        'batch/index'
    }

    @GetMapping(path = "/download", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    def downloadFile(HttpServletResponse response) {
        def file = new ClassPathResource(TEMPLATE_LOCATION)
        response.setHeader "Content-Disposition", "attachment; filename=\"${file.filename}\""
        response.outputStream << file.inputStream.bytes
        response.outputStream.flush()
    }

    @PostMapping
    def register(@RequestParam('file') MultipartFile file, RedirectAttributes redirect) {
        excelService.register file.inputStream
        redirect.addFlashAttribute('message', 'Registration successful')
        'redirect:/batch'
    }
}
