package ru.ithub.delivery.mapper;


import org.springframework.stereotype.Component;
import ru.ithub.delivery.dto.ProductDto;
import ru.ithub.delivery.entity.Product;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {


    public ProductDto toDto(Product entity) {
        return new ProductDto
                (
                        entity.getId(),
                        entity.getName(),
                        entity.getDescription(),
                        entity.getCount()

                );
    }

    public Product toEntity(ProductDto dto) {
        return new Product
                (
                        dto.getId(),
                        dto.getName(),
                        dto.getDescription(),
                        dto.getCount()

                );
    }

    public List<ProductDto> toDto(List<Product> entity) {
        return entity.stream().map(this::toDto).collect(Collectors.toList());
    }

    public List<Product> toEntity(List<ProductDto> dto) {
        return dto.stream().map(this::toEntity).collect(Collectors.toList());
    }


    public Product update(Product entity, ProductDto dto) {
        Product entityUpdate = toEntity(dto);
        if (entityUpdate.getName() != null && !entityUpdate.getName().isEmpty()) {
            entity.setName(entityUpdate.getName());
        }
        if (entityUpdate.getDescription() != null && !entityUpdate.getDescription().isEmpty()) {
            entity.setDescription(entityUpdate.getDescription());
        }
        if (!String.valueOf(entityUpdate.getCount()).isEmpty()) {
            entity.setCount(entityUpdate.getCount());
        }
        return entity;
    }


}
