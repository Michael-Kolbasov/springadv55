package com.epam.kolbasov.springadv.repository

import com.epam.kolbasov.springadv.model.Telephone
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface TelephoneRepository extends CrudRepository<Telephone, String> {

}