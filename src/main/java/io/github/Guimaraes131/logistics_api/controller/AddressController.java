package io.github.Guimaraes131.logistics_api.controller;

import io.github.Guimaraes131.logistics_api.controller.dto.GetAddressDTO;
import io.github.Guimaraes131.logistics_api.controller.dto.PostAddressDTO;
import io.github.Guimaraes131.logistics_api.controller.mapper.AddressMapper;
import io.github.Guimaraes131.logistics_api.model.Address;
import io.github.Guimaraes131.logistics_api.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/address")
public class AddressController {

    private final AddressService service;
    private final AddressMapper mapper;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody PostAddressDTO dto) {
        Address address = mapper.toEntity(dto);

        service.create(address);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(address.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetAddressDTO> get(@PathVariable String id) {
        UUID entityId = UUID.fromString(id);

        return service.get(entityId)
                .map(address -> {
                    return ResponseEntity.ok().body(mapper.toDTO(address));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
