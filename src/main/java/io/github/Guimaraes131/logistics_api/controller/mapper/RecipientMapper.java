package io.github.Guimaraes131.logistics_api.controller.mapper;

import io.github.Guimaraes131.logistics_api.controller.dto.PostRecipientDTO;
import io.github.Guimaraes131.logistics_api.model.Recipient;
import io.github.Guimaraes131.logistics_api.repository.AddressRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring", uses = AddressMapper.class)
public abstract class RecipientMapper {

    @Autowired
    AddressRepository repository;

    @Mapping(target = "address", expression = "java( repository.findById(dto.addressId()).orElse(null) )")
    public abstract Recipient toEntity(PostRecipientDTO dto);
}
