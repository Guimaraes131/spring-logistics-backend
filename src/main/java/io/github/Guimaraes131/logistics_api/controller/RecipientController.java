package io.github.Guimaraes131.logistics_api.controller;

import io.github.Guimaraes131.logistics_api.controller.dto.GetRecipientDTO;
import io.github.Guimaraes131.logistics_api.controller.dto.PostRecipientDTO;
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

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid PostRecipientDTO dto) {
        var recipient = service.create(dto);

        return ResponseEntity.created(generateLocationHeader(recipient.getId())).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetRecipientDTO> get(@PathVariable UUID id) {
        return service.get(id)
                .map(ResponseEntity::ok).orElseGet(
                        () -> ResponseEntity.notFound().build()
                );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}
