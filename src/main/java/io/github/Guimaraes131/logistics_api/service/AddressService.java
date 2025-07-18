package io.github.Guimaraes131.logistics_api.service;

import io.github.Guimaraes131.logistics_api.model.Address;
import io.github.Guimaraes131.logistics_api.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository repository;

    public void create(Address address) {
        repository.save(address);
    }
}
