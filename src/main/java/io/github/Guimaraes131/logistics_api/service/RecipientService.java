package io.github.Guimaraes131.logistics_api.service;

import io.github.Guimaraes131.logistics_api.model.Recipient;
import io.github.Guimaraes131.logistics_api.repository.RecipientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecipientService {

    private final RecipientRepository repository;

    public void create(Recipient recipient) {
        repository.save(recipient);
    }
}
