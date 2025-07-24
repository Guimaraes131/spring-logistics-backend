package io.github.Guimaraes131.logistics_api.controller.mapper;

import io.github.Guimaraes131.logistics_api.controller.dto.GetProductDTO;
import io.github.Guimaraes131.logistics_api.controller.dto.PostProductDTO;
import io.github.Guimaraes131.logistics_api.model.Product;
import io.github.Guimaraes131.logistics_api.repository.DeliveryRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring", uses = DeliveryMapper.class)
public abstract class ProductMapper {

    @Autowired
    DeliveryRepository repository;

    @Mapping(target = "delivery", expression = "java( repository.findById(dto.deliveryId()).orElse(null) )")
    public abstract Product toEntity(PostProductDTO dto);

    public abstract GetProductDTO toDTO(Product entity);
}
