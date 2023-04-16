package ru.ithub.delivery.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.ithub.delivery.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
