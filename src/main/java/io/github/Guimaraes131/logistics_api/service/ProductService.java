package io.github.Guimaraes131.logistics_api.service;

import io.github.Guimaraes131.logistics_api.controller.dto.PostProductDTO;
import io.github.Guimaraes131.logistics_api.controller.mapper.ProductMapper;
import io.github.Guimaraes131.logistics_api.model.Product;
import io.github.Guimaraes131.logistics_api.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;
    private final ProductMapper mapper;

    public Product create(PostProductDTO dto) {
        var entity = mapper.toEntity(dto);

        return repository.save(entity);
    }
}
