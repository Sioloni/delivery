package ru.ithub.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ithub.delivery.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
