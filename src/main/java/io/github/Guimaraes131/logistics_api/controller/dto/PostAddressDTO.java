package io.github.Guimaraes131.logistics_api.controller.dto;

public record PostAddressDTO(
    String street,
    String number,
    String complement,
    String neighbourhood,
    String city,
    String state,
    String postalCode
) {
}
