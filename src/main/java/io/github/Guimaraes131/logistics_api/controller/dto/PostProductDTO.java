package io.github.Guimaraes131.logistics_api.controller.dto;

import java.util.UUID;

public record PostProductDTO(
        String name,
        String description,
        Double weight,
        Integer quantity,
        UUID deliveryId
) {
}
