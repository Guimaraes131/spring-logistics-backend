package io.github.Guimaraes131.logistics_api.repository;

import io.github.Guimaraes131.logistics_api.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AddressRepository extends JpaRepository<Address, UUID> {
}
