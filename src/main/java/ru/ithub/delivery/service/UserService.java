package ru.ithub.delivery.service;

import ru.ithub.delivery.dto.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto> get();

    UserDto get(Long id);

    void create(UserDto dto);

    void update(Long id, UserDto dto);

    void delete(Long id);
}
