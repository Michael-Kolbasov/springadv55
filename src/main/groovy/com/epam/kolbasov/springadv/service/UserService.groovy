package com.epam.kolbasov.springadv.service

import com.epam.kolbasov.springadv.model.User
import com.epam.kolbasov.springadv.repository.UserRepository
import com.epam.kolbasov.springadv.service.interfaces.IDomainService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService implements IDomainService<User> {

    @Autowired
    UserRepository userRepository

    @Override
    Set<User> findAll() {
        userRepository.findAll() as Set<User>
    }

    @Override
    User save(User entity) {
        def user = userRepository.findById(entity.id).orElseGet { new User() }
        user.telephones.addAll entity.telephones
        userRepository.save(user)
    }
}