package io.github.Guimaraes131.logistics_api.controller;

import io.github.Guimaraes131.logistics_api.controller.dto.GetProductDTO;
import io.github.Guimaraes131.logistics_api.controller.dto.PostProductDTO;
import io.github.Guimaraes131.logistics_api.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController implements GenericController {

    private final ProductService service;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody PostProductDTO dto) {
        var entity = service.create(dto);

        return ResponseEntity.created(generateLocationHeader(entity.getId())).build();
    }

    @GetMapping("/by-id/{id}")
    public ResponseEntity<GetProductDTO> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping("/by-delivery/{code}")
    public ResponseEntity<List<GetProductDTO>> getByDelivery(@PathVariable String code) {
        return ResponseEntity.ok(service.getByDelivery(code));
    }
}
