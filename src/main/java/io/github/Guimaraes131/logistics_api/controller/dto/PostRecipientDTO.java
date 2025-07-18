package io.github.Guimaraes131.logistics_api.controller.dto;

import java.util.UUID;

public record PostRecipientDTO(
        String name,
        String cpf,
        UUID addressId
) {
}
