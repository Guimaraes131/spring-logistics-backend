package io.github.Guimaraes131.logistics_api.validator;

import io.github.Guimaraes131.logistics_api.controller.dto.PostDeliveryDTO;
import io.github.Guimaraes131.logistics_api.controller.dto.UpdateDeliveryStatusDTO;
import io.github.Guimaraes131.logistics_api.exception.InvalidStatusException;
import io.github.Guimaraes131.logistics_api.model.enums.Status;
import io.github.Guimaraes131.logistics_api.repository.RecipientRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.EnumSet;
import java.util.Set;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class DeliveryValidator {

    private final RecipientRepository recipientRepository;

    public void validate(PostDeliveryDTO dto) {
        if (!existsRecipient(dto.recipientId())) {
            throw new EntityNotFoundException("Recipient does not exist");
        }
    }

    public void validate(UpdateDeliveryStatusDTO dto) {
        Set<Status> statusList = EnumSet.of(
                Status.PENDING,
                Status.DELIVERED,
                Status.IN_TRANSIT,
                Status.DISPATCHED
        );

        if (dto.status() == null || !statusList.contains(dto.status())) {
            throw new InvalidStatusException("Invalid Status");
        }
    }

    private boolean existsRecipient(UUID id) {
        return recipientRepository.existsById(id);
    }
}
