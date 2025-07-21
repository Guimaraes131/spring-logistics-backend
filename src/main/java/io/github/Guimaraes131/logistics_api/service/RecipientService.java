package io.github.Guimaraes131.logistics_api.service;

import io.github.Guimaraes131.logistics_api.model.Recipient;
import io.github.Guimaraes131.logistics_api.repository.RecipientRepository;
import io.github.Guimaraes131.logistics_api.validator.RecipientValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RecipientService {

    private final RecipientRepository repository;
    private final RecipientValidator validator;

    public void create(Recipient recipient) {
        validator.validate(recipient);
        repository.save(recipient);
    }

    public Optional<Recipient> get(UUID id) {
        return repository.findById(id);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }

    public void update(Recipient recipient) {
        validator.validate(recipient);
        repository.save(recipient);
    }
}
