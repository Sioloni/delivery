package ru.ithub.delivery.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ithub.delivery.dto.ProductDto;
import ru.ithub.delivery.entity.Product;
import ru.ithub.delivery.mapper.ProductMapper;
import ru.ithub.delivery.repository.ProductRepository;
import ru.ithub.delivery.service.ProductService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository repository;
    private final ProductMapper mapper;


    @Override
    public List<ProductDto> get() {
        return mapper.toDto(repository.findAll());
    }

    @Override
    public ProductDto get(Long id) {
        return mapper.toDto(repository.findById(id).orElseThrow(() -> new RuntimeException("id is not found")));
    }

    @Override
    public void create(ProductDto dto) {
        repository.save(mapper.toEntity(dto));
    }

    @Override
    public void update(Long id, ProductDto dto) {
        Product entity = mapper.toEntity(get(id));
        repository.save(mapper.update(entity, dto));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
