package io.github.Guimaraes131.logistics_api.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

import java.util.UUID;

public record PostRecipientDTO(

        @NotBlank(message = "Name field must not be null or blank")
        @Size(min = 2, max = 64, message = "Name field must have between 2 and 64 characters")
        String name,

        @NotBlank(message = "CPF field must not be null or blank")
        @Size(min = 14, max = 14, message = "CPF field must have exactly 14 characters")
        @CPF(message = "Invalid CPF")
        String cpf,

        @NotNull(message = "Address ID field must not be null")
        UUID addressId
) {
}
