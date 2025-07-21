package io.github.Guimaraes131.logistics_api.service;

import io.github.Guimaraes131.logistics_api.controller.dto.GetRecipientDTO;
import io.github.Guimaraes131.logistics_api.controller.dto.PostRecipientDTO;
import io.github.Guimaraes131.logistics_api.controller.mapper.RecipientMapper;
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
    private final RecipientMapper mapper;


    public Recipient create(PostRecipientDTO dto) {
        Recipient recipient = mapper.toEntity(dto);

        validator.validateAddressExists(dto);
        validator.validate(recipient);

        return repository.save(recipient);
    }

    public Optional<GetRecipientDTO> get(UUID id) {
        return repository.findById(id)
                .map(mapper::toDTO);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }

    public void update(Recipient recipient) {
        validator.validate(recipient);
        repository.save(recipient);
    }
}
