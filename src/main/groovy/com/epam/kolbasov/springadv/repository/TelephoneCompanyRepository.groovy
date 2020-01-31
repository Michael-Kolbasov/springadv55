package com.epam.kolbasov.springadv.repository

import com.epam.kolbasov.springadv.model.TelephoneCompany
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface TelephoneCompanyRepository extends CrudRepository<TelephoneCompany, String> {

}