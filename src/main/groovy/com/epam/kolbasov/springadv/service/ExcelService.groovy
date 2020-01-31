package com.epam.kolbasov.springadv.service

import com.epam.kolbasov.springadv.util.excel.reader.ExcelReader
import com.epam.kolbasov.springadv.service.interfaces.IExcelRegistrationService
import com.epam.kolbasov.springadv.service.interfaces.IDomainService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service

@Service
class ExcelService implements IExcelRegistrationService {

    @Autowired @Qualifier('telephoneCompanyService')
    IDomainService companyService
    @Autowired
    IDomainService telephoneService
    @Autowired
    IDomainService userService

    @Override
    void register(InputStream inputStream) {
        new ExcelReader(inputStream).withCloseable {reader ->
            reader.readFile()
            def cache = reader.cache

            for (tuple in cache) {
                save(tuple.first, companyService)
                save(tuple.second, telephoneService)
                save(tuple.third, userService)
            }
        }
    }

    private static void save(entity, IDomainService service) {
        if (entity) {
            service.save(entity)
        }
    }
}
