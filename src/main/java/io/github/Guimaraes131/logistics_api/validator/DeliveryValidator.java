package io.github.Guimaraes131.logistics_api.validator;

import io.github.Guimaraes131.logistics_api.controller.dto.PostDeliveryDTO;
import io.github.Guimaraes131.logistics_api.repository.RecipientRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

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

    private boolean existsRecipient(UUID id) {
        return recipientRepository.existsById(id);
    }
}
