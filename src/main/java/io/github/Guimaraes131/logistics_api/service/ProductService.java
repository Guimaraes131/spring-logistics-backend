package io.github.Guimaraes131.logistics_api.service;

import io.github.Guimaraes131.logistics_api.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;
}
