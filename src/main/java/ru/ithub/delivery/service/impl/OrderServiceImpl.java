package ru.ithub.delivery.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ithub.delivery.dto.OrderDto;
import ru.ithub.delivery.entity.Order;
import ru.ithub.delivery.mapper.OrderMapper;
import ru.ithub.delivery.repository.OrderRepository;
import ru.ithub.delivery.service.OrderService;

import java.util.List;


@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository repository;
    private final OrderMapper mapper;


    @Override
    public List<OrderDto> get() {
        return mapper.toDto(repository.findAll());
    }

    @Override
    public OrderDto get(Long id) {
        return mapper.toDto(repository.findById(id).orElseThrow(() -> new RuntimeException("id is not found")));
    }

    @Override
    public void create(OrderDto dto) {
        repository.save(mapper.toEntity(dto));
    }

    @Override
    public void update(Long id, OrderDto dto) {
        System.out.println("метод сервиса");
        Order entity = mapper.toEntity(get(id));
        repository.save(mapper.update(entity, dto));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
