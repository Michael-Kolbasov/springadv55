package com.epam.kolbasov.springadv.model

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table
@EqualsAndHashCode(excludes = ['telephones'])
@ToString(excludes = ['telephones'], includeNames = true, includePackage = false)
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id

    @Column
    String name

    @Column
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    Set<Telephone> telephones = [] as Set<Telephone>
}
