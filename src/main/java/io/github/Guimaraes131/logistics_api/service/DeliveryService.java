package io.github.Guimaraes131.logistics_api.service;

import io.github.Guimaraes131.logistics_api.repository.DeliveryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeliveryService {

    private final DeliveryRepository repository;
}
