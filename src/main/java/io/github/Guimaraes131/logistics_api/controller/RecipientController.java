package io.github.Guimaraes131.logistics_api.controller;

import io.github.Guimaraes131.logistics_api.controller.dto.GetRecipientDTO;
import io.github.Guimaraes131.logistics_api.controller.dto.PostRecipientDTO;
import io.github.Guimaraes131.logistics_api.controller.mapper.RecipientMapper;
import io.github.Guimaraes131.logistics_api.model.Recipient;
import io.github.Guimaraes131.logistics_api.service.RecipientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/recipient")
public class RecipientController implements GenericController {

    private final RecipientService service;
    private final RecipientMapper mapper;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid PostRecipientDTO dto) {
        Recipient recipient = mapper.toEntity(dto);

        service.create(recipient);

        return ResponseEntity.created(generateLocationHeader(recipient.getId())).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetRecipientDTO> get(@PathVariable UUID id) {
        return service.get(id)
                .map(recipient -> {
                    GetRecipientDTO dto = mapper.toDTO(recipient);

                    return ResponseEntity.ok(dto);
                }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable UUID id, @Valid @RequestBody PostRecipientDTO dto) {
        return service.get(id)
                .map(entity -> {
                    mapper.updateFromDTO(dto, entity);
                    service.update(entity);

                    return ResponseEntity.ok().build();
                }).orElseGet(
                        () -> ResponseEntity.notFound().build()
                );
    }
}
