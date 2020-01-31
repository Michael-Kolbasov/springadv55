package com.epam.kolbasov.springadv.service

import com.epam.kolbasov.springadv.model.Telephone
import com.epam.kolbasov.springadv.repository.TelephoneRepository
import com.epam.kolbasov.springadv.service.interfaces.IDomainService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TelephoneService implements IDomainService<Telephone> {

    @Autowired
    TelephoneRepository telephoneRepository

    @Override
    Set<Telephone> findAll() {
        telephoneRepository.findAll() as Set<Telephone>
    }

    @Override
    Telephone save(Telephone entity) {
        telephoneRepository.save(entity)
    }
}
