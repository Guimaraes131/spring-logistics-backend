package io.github.Guimaraes131.logistics_api.controller;

import io.github.Guimaraes131.logistics_api.controller.dto.PostRecipientDTO;
import io.github.Guimaraes131.logistics_api.controller.mapper.RecipientMapper;
import io.github.Guimaraes131.logistics_api.model.Recipient;
import io.github.Guimaraes131.logistics_api.service.RecipientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/recipient")
public class RecipientController implements GenericController {

    private final RecipientService service;
    private final RecipientMapper mapper;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody PostRecipientDTO dto) {
        Recipient recipient = mapper.toEntity(dto);

        service.create(recipient);

        return ResponseEntity.created(generateLocationHeader(recipient.getId())).build();
    }
}
