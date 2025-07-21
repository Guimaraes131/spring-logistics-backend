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
    private final AddressRepository addressRepository;

    public void validate(Recipient recipient) {
        if (existsRecipient(recipient)) {
            throw new DuplicateRecordException("This CPF is already in use");
        }
    }

    public void validateAddressExists(PostRecipientDTO dto) {
        if (!addressRepository.existsById(dto.addressId())) {
            throw new EntityNotFoundException("Address does not exist");
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
