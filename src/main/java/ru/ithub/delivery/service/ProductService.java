package ru.ithub.delivery.service;

import ru.ithub.delivery.dto.ProductDto;

import java.util.List;

public interface ProductService {

    List<ProductDto> get();

    ProductDto get(Long id);

    void create(ProductDto dto);

    void update(Long id, ProductDto dto);

    void delete(Long id);
}
