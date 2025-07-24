package io.github.Guimaraes131.logistics_api.service;

import io.github.Guimaraes131.logistics_api.controller.dto.GetProductDTO;
import io.github.Guimaraes131.logistics_api.controller.dto.PostProductDTO;
import io.github.Guimaraes131.logistics_api.controller.mapper.ProductMapper;
import io.github.Guimaraes131.logistics_api.model.Product;
import io.github.Guimaraes131.logistics_api.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;
    private final ProductMapper mapper;

    public Product create(PostProductDTO dto) {
        var entity = mapper.toEntity(dto);

        return repository.save(entity);
    }

    public GetProductDTO getById(UUID id) {
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(
                        () -> new EntityNotFoundException("Product does not exist")
                );
    }

    public List<GetProductDTO> getByDelivery(String code) {
        return repository.findAllByDeliveryTrackingCode(code)
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }
}
