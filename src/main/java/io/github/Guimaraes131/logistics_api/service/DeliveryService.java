package io.github.Guimaraes131.logistics_api.service;

import io.github.Guimaraes131.logistics_api.controller.dto.GetDeliveryDTO;
import io.github.Guimaraes131.logistics_api.controller.dto.PostDeliveryDTO;
import io.github.Guimaraes131.logistics_api.controller.dto.UpdateDeliveryStatusDTO;
import io.github.Guimaraes131.logistics_api.controller.mapper.DeliveryMapper;
import io.github.Guimaraes131.logistics_api.model.Delivery;
import io.github.Guimaraes131.logistics_api.model.enums.Status;
import io.github.Guimaraes131.logistics_api.repository.DeliveryRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

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

    public Optional<Delivery> get(UUID id) {
        return repository.findById(id);
    }

    public GetDeliveryDTO getByTrackingCode(String code) {
        return repository.findByTrackingCode(code)
                .map(mapper::toDTO)
                .orElseThrow(() -> new EntityNotFoundException("Delivery does not exist"));
    }

    public List<GetDeliveryDTO> getByRecipientCpf(String cpf) {
        return repository.findByRecipientCpf(cpf)
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }

    public void updateStatus(UUID id, UpdateDeliveryStatusDTO dto) {
        repository.findById(id)
                .map(delivery -> {
                    delivery.setStatus(dto.status());
                    return repository.save(delivery);
                }).orElseThrow(
                        () -> new EntityNotFoundException("Delivery does not exist")
                );
    }
}
