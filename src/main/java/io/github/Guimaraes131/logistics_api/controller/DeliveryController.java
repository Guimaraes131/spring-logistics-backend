package io.github.Guimaraes131.logistics_api.controller;

import io.github.Guimaraes131.logistics_api.controller.dto.GetDeliveryDTO;
import io.github.Guimaraes131.logistics_api.controller.dto.PostDeliveryDTO;
import io.github.Guimaraes131.logistics_api.controller.dto.UpdateDeliveryStatusDTO;
import io.github.Guimaraes131.logistics_api.service.DeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/delivery")
public class DeliveryController implements GenericController {

    private final DeliveryService service;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody PostDeliveryDTO dto) {
        var entity = service.create(dto);

        return ResponseEntity.created(generateLocationHeader(entity.getId())).build();
    }

    @GetMapping("/by-tracking-code/{code}")
    public ResponseEntity<GetDeliveryDTO> getByTrackingCode(@PathVariable String code) {
        return service.getByTrackingCode(code)
                .map(ResponseEntity::ok)
                .orElseGet(
                        () -> ResponseEntity.notFound().build()
                );
    }

    @GetMapping("/by-recipient-cpf/{cpf}")
    public ResponseEntity<List<GetDeliveryDTO>> getByRecipientCpf(@PathVariable String cpf) {
        return ResponseEntity.ok(service.getByRecipientCpf(cpf));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateStatus(@PathVariable UUID id, @RequestBody UpdateDeliveryStatusDTO dto) {
        service.updateStatus(id, dto);

        return ResponseEntity.noContent().build();
    }
}
