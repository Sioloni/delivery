package ru.ithub.delivery.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.ithub.delivery.dto.OrderDto;
import ru.ithub.delivery.entity.Order;
import ru.ithub.delivery.entity.Product;
import ru.ithub.delivery.repository.ProductRepository;
import ru.ithub.delivery.repository.UserRepository;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class OrderMapper {
    private final UserRepository repository;
    private final ProductRepository productRepository;


    public OrderDto toDto(Order entity) {
        return new OrderDto
                (
                        entity.getId(),
                        entity.getCustomer().getId(),
                        entity.getDriver().getId(),
                        new HashSet<>(entity.getProducts()
                                .stream().map(Product::getId).collect(Collectors.toList())),
                        entity.getCreatedAt(),
                        entity.getStartPoint(),
                        entity.getCurrentPoint(),
                        entity.getFinishPoint(),
                        entity.getStatus()
                );
    }

    public Order toEntity(OrderDto dto) {
        System.out.println("метод преобраз");
        return new Order
                (
                        dto.getId(),
                        repository.findById(dto.getCustomerId()).orElseThrow(() -> new RuntimeException("id is not found")),
                        repository.findById(dto.getDriverId()).orElseThrow(() -> new RuntimeException("id is not found")),
                        new HashSet<>(productRepository.findAllById(dto.getProductsId())),
                        dto.getCreatedAt(),
                        dto.getStartPoint(),
                        dto.getCurrentPoint(),
                        dto.getFinishPoint(),
                        dto.getStatus()
                );
    }


    public List<OrderDto> toDto(List<Order> dto) {
        return dto.stream().map(this::toDto).collect(Collectors.toList());
    }

    public List<Order> toEntity(List<OrderDto> dto) {
        return dto.stream().map(this::toEntity).collect(Collectors.toList());
    }

    public Order update(Order entity, OrderDto dto) {
        Order entityUpdate = toEntity(dto);
        System.out.println("метод update");
        if (entityUpdate.getCustomer() != null && !entityUpdate.getCustomer().toString().isEmpty()) {
            entity.setCustomer(entityUpdate.getCustomer());
        }
        if (entityUpdate.getDriver() != null && !entityUpdate.getDriver().toString().isEmpty()) {
            entity.setDriver(entityUpdate.getDriver());
        }
        if (entityUpdate.getProducts() != null && !entityUpdate.getProducts().toString().isEmpty()) {
            entity.setProducts(entityUpdate.getProducts());
        }
        if (entityUpdate.getCreatedAt() != null && !entityUpdate.getCreatedAt().toString().isEmpty()) {
            entity.setCreatedAt(entityUpdate.getCreatedAt());
        }
        if (entityUpdate.getStartPoint() != null && !entityUpdate.getStartPoint().isEmpty()) {
            entity.setStartPoint(entityUpdate.getStartPoint());
        }
        if (entityUpdate.getCurrentPoint() != null && !entityUpdate.getCurrentPoint().isEmpty()) {
            entity.setCurrentPoint(entityUpdate.getCurrentPoint());
        }
        if (entityUpdate.getFinishPoint() != null && !entityUpdate.getFinishPoint().isEmpty()) {
            entity.setFinishPoint(entityUpdate.getFinishPoint());
        }
        if (entityUpdate.getStatus() != null && !entityUpdate.getStatus().name().isEmpty()) {
            entity.setStatus(entityUpdate.getStatus());
        }
        return entity;
    }


}
