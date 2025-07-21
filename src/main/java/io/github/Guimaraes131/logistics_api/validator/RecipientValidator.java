package io.github.Guimaraes131.logistics_api.validator;

import io.github.Guimaraes131.logistics_api.controller.dto.PostRecipientDTO;
import io.github.Guimaraes131.logistics_api.exception.DuplicateRecordException;
import io.github.Guimaraes131.logistics_api.model.Recipient;
import io.github.Guimaraes131.logistics_api.repository.AddressRepository;
import io.github.Guimaraes131.logistics_api.repository.RecipientRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class RecipientValidator {

    private final RecipientRepository recipientRepository;

    public void validate(Recipient recipient) {
        if (recipient == null) {
            throw new EntityNotFoundException("Recipient does not exist");
        }

        if (existsRecipient(recipient)) {
            throw new DuplicateRecordException("This CPF is already in use");
        }
    }

    private boolean existsRecipient(Recipient recipient) {
        Optional<Recipient> entity = recipientRepository.findByCpf(recipient.getCpf());

        if (recipient.getId() == null && entity.isPresent()) {
            return true;
        }

        return entity.isPresent() && !recipient.getId().equals(entity.get().getId());
    }
}
