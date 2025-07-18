package io.github.Guimaraes131.logistics_api.service;

import io.github.Guimaraes131.logistics_api.model.Address;
import io.github.Guimaraes131.logistics_api.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository repository;

    public void create(Address address) {
        repository.save(address);
    }

    public Optional<Address> get(UUID id) {
        return repository.findById(id);
    }
}
