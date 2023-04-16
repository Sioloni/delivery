package ru.ithub.delivery.service;

import ru.ithub.delivery.dto.OrderDto;

import java.util.List;

public interface OrderService {

    List<OrderDto> get();

    OrderDto get(Long id);

    void create(OrderDto dto);

    void update(Long id, OrderDto dto);

    void delete(Long id);
}
