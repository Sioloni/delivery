package ru.ithub.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ithub.delivery.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
