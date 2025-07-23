package io.github.Guimaraes131.logistics_api.controller.mapper;

import io.github.Guimaraes131.logistics_api.controller.dto.PostDeliveryDTO;
import io.github.Guimaraes131.logistics_api.model.Delivery;
import io.github.Guimaraes131.logistics_api.repository.RecipientRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring", uses = RecipientMapper.class)
public abstract class DeliveryMapper {

    @Autowired
    RecipientRepository repository;

    @Mapping(target = "recipient", expression = "java( repository.findById(dto.recipientId()).orElse(null) )")
    public abstract Delivery toEntity(PostDeliveryDTO dto);
}
