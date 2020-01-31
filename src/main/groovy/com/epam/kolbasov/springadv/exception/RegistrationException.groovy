package com.epam.kolbasov.springadv.exception

class RegistrationException extends RuntimeException {

    RegistrationException(String message, Throwable cause) {
        super(message, cause)
    }

    RegistrationException(String message) {
        super(message)
    }
}
