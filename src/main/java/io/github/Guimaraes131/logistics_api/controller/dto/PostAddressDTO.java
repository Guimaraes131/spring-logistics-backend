package io.github.Guimaraes131.logistics_api.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record PostAddressDTO(

        @NotBlank(message = "Street field must not be null or blank")
        @Size(min = 4, max = 64, message = "Street field must have between 4 and 64 characters")
        String street,

        @NotBlank(message = "Number field must not be null or blank")
        @Size(min = 1, max = 12, message = "Number field must have between 1 and 12 characters")
        String number,

        @Size(max = 128, message = "Complement field must have a maximum of 128 characters")
        String complement,

        @NotBlank(message = "Neighbourhood field must not be null or blank")
        @Size(min = 4, max = 64, message = "Neighbourhood field must have between 4 and 64 characters")
        String neighbourhood,

        @NotBlank(message = "City field must not be null or blank")
        @Size(min = 3, max = 64, message = "City field must have between 3 and 64 characters")
        String city,

        @NotBlank(message = "State field must not be null or blank")
        @Size(min = 2, max = 64, message = "State field must have between 2 and 64 characters")
        String state,

        @NotBlank(message = "Postal code field must not be null or blank")
        @Size(min = 5, max = 9, message = "Postal code field must have between 5 and 9 characters")
        String postalCode
) {
}
