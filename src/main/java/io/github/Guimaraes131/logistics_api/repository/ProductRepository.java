package io.github.Guimaraes131.logistics_api.repository;

import io.github.Guimaraes131.logistics_api.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {

    List<Product> findAllByDeliveryTrackingCode(String code);
}
