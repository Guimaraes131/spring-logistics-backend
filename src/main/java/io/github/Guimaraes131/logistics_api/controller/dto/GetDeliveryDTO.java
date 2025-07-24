package io.github.Guimaraes131.logistics_api.controller.dto;

import io.github.Guimaraes131.logistics_api.model.enums.Status;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record GetDeliveryDTO(
        UUID id,
        String trackingCode,
        Status status,
        LocalDateTime creationDate,
        LocalDateTime deliveryDate,
        GetRecipientDTO recipient,
        List<GetProductDTO> products
) {
}
