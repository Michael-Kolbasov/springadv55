package com.epam.kolbasov.springadv.dto

class TelephoneDto {
    String number
    boolean free

    TelephoneDto() {
    }

    TelephoneDto(String number, boolean free) {
        this.number = number
        this.free = free
    }
}
