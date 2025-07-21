package io.github.Guimaraes131.logistics_api.validator;

import io.github.Guimaraes131.logistics_api.repository.AddressRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class AddressValidator {

    private final AddressRepository repository;

    public void validateExists(UUID id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Address does not exist");
        }
    }
}
