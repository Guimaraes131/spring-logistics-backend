package io.github.Guimaraes131.logistics_api.controller.dto;

import java.util.UUID;

public record GetAddressDTO(
    UUID id,
    String street,
    String number,
    String complement,
    String neighbourhood,
    String city,
    String state,
    String postalCode
) {
}
