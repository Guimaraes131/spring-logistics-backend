package io.github.Guimaraes131.logistics_api.service;

import io.github.Guimaraes131.logistics_api.controller.dto.GetDeliveryDTO;
import io.github.Guimaraes131.logistics_api.controller.dto.PostDeliveryDTO;
import io.github.Guimaraes131.logistics_api.controller.mapper.DeliveryMapper;
import io.github.Guimaraes131.logistics_api.model.Delivery;
import io.github.Guimaraes131.logistics_api.model.enums.Status;
import io.github.Guimaraes131.logistics_api.repository.DeliveryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
public class DeliveryService {

    private final DeliveryRepository repository;
    private final DeliveryMapper mapper;

    public Delivery create(PostDeliveryDTO dto) {
        var entity = mapper.toEntity(dto);
        entity.setStatus(Status.PENDING);
        entity.setTrackingCode(
                String.valueOf(
                        ThreadLocalRandom
                                .current()
                                .nextInt(10000000, 100000000)
                )
        );

        return repository.save(entity);
    }

    public Optional<GetDeliveryDTO> getByTrackingCode(String code) {
        return repository.findByTrackingCode(code)
                .map(mapper::toDTO);
    }
}
