package io.github.Guimaraes131.logistics_api.repository;

import io.github.Guimaraes131.logistics_api.model.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DeliveryRepository extends JpaRepository<Delivery, UUID> {

    Optional<Delivery> findByTrackingCode(String code);
    List<Delivery> findByRecipientCpf(String cpf);
}
