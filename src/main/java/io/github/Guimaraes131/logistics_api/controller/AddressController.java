package io.github.Guimaraes131.logistics_api.controller;

import io.github.Guimaraes131.logistics_api.controller.dto.PostAddressDTO;
import io.github.Guimaraes131.logistics_api.controller.mapper.AddressMapper;
import io.github.Guimaraes131.logistics_api.model.Address;
import io.github.Guimaraes131.logistics_api.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

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
}
