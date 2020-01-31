package com.epam.kolbasov.springadv.exception

class PdfGenerationException extends RuntimeException {

    PdfGenerationException(String message, Throwable cause) {
        super(message, cause)
    }
}
