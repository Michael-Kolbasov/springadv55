package com.epam.kolbasov.springadv.model

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table
@EqualsAndHashCode(excludes = ['telephones'])
@ToString(excludes = ['telephones'], includeNames = true, includePackage = false)
class TelephoneCompany {
    @Id
    String name

    @Column
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    Set<Telephone> telephones = [] as Set<Telephone>
}
