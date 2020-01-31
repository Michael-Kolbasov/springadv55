package com.epam.kolbasov.springadv.dto

import javax.validation.constraints.NotEmpty

class JsonUploadDto {
    @NotEmpty(message = 'At least one company must be specified.')
    List<TelephoneCompanyDto> companies

    @NotEmpty(message = 'At least one telephone must be specified.')
    List<TelephoneDto> telephones

    List<UserDto> users
}
