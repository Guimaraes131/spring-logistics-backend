package io.github.Guimaraes131.logistics_api.controller.mapper;

import io.github.Guimaraes131.logistics_api.controller.dto.GetAddressDTO;
import io.github.Guimaraes131.logistics_api.controller.dto.PostAddressDTO;
import io.github.Guimaraes131.logistics_api.model.Address;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    @Mapping(target = "id", ignore = true)
    Address toEntity(PostAddressDTO dto);

    GetAddressDTO toDTO(Address entity);

    @Mapping(target = "id", ignore = true)
    void updateFromDTO(PostAddressDTO dto, @MappingTarget Address entity);
}
