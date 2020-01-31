package com.epam.kolbasov.springadv.model

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table
@EqualsAndHashCode
@ToString(includeNames = true, includePackage = false)
class Telephone {
    @Id
    String number

    @Column
    boolean free
}
