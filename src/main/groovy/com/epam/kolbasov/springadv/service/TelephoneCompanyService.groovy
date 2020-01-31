package com.epam.kolbasov.springadv.service

import com.epam.kolbasov.springadv.model.TelephoneCompany
import com.epam.kolbasov.springadv.repository.TelephoneCompanyRepository
import com.epam.kolbasov.springadv.service.interfaces.IDomainService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TelephoneCompanyService implements IDomainService<TelephoneCompany> {

    @Autowired
    TelephoneCompanyRepository telephoneCompanyRepository

    Set<TelephoneCompany> findAll() {
        telephoneCompanyRepository.findAll() as Set<TelephoneCompany>
    }

    @Override
    TelephoneCompany save(TelephoneCompany entity) {
        def company = telephoneCompanyRepository.findById(entity.name).orElseGet { new TelephoneCompany(name: entity.name) }
        company.telephones.addAll entity.telephones
        telephoneCompanyRepository.save(company)
    }
}
