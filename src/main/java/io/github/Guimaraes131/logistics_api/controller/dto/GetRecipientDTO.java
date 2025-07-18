package io.github.Guimaraes131.logistics_api.controller.dto;

import java.util.UUID;

public record GetRecipientDTO(
        UUID id,
        String name,
        String cpf,
        GetAddressDTO address
) {
}
