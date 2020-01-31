package com.epam.kolbasov.springadv.service.interfaces

interface IDomainService<T> {
    Set<T> findAll()
    T save(T entity)
}
