package ru.ithub.delivery.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.ithub.delivery.dto.OrderDto;
import ru.ithub.delivery.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService service;


    @GetMapping
    public List<OrderDto> get() {
        return service.get();
    }

    @GetMapping("/{id}")
    public OrderDto get(@PathVariable Long id) {
        return service.get(id);
    }

    @PostMapping
    public void create(@RequestBody OrderDto dto) {
        service.create(dto);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody OrderDto dto) {
        service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
