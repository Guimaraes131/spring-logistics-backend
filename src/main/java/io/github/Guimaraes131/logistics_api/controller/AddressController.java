package io.github.Guimaraes131.logistics_api.controller;

import io.github.Guimaraes131.logistics_api.controller.dto.GetAddressDTO;
import io.github.Guimaraes131.logistics_api.controller.dto.PostAddressDTO;
import io.github.Guimaraes131.logistics_api.controller.mapper.AddressMapper;
import io.github.Guimaraes131.logistics_api.model.Address;
import io.github.Guimaraes131.logistics_api.service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/address")
public class AddressController implements GenericController{

    private final AddressService service;
    private final AddressMapper mapper;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid PostAddressDTO dto) {
        Address address = mapper.toEntity(dto);

        service.create(address);

        return ResponseEntity.created(generateLocationHeader(address.getId())).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetAddressDTO> get(@PathVariable UUID id) {
        return service.get(id)
                .map(address -> {
                    return ResponseEntity.ok().body(mapper.toDTO(address));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<GetAddressDTO>> index() {
        List<Address> index = service.index();

        return ResponseEntity.ok(
            index.stream()
                .map(mapper::toDTO)
                .toList()
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable UUID id, @RequestBody @Valid PostAddressDTO dto) {
        return service.get(id)
                .map(entity -> {
                    mapper.updateFromDTO(dto, entity);
                    service.update(entity);

                    return ResponseEntity.noContent().build();
                }).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
