package ru.ithub.delivery.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.ithub.delivery.dto.ProductDto;
import ru.ithub.delivery.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user/order/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService service;


    @GetMapping
    public List<ProductDto> get() {
        return service.get();
    }

    @GetMapping("/{id}")
    public ProductDto get(@PathVariable Long id) {
        return service.get(id);
    }

    @PostMapping
    public void create(@RequestBody ProductDto dto) {
        service.create(dto);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody ProductDto dto) {
        service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
