package io.github.Guimaraes131.logistics_api.controller;

import io.github.Guimaraes131.logistics_api.controller.dto.PostDeliveryDTO;
import io.github.Guimaraes131.logistics_api.service.DeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
