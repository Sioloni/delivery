package ru.ithub.delivery.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ithub.delivery.dto.UserDto;
import ru.ithub.delivery.entity.User;
import ru.ithub.delivery.mapper.UserMapper;
import ru.ithub.delivery.repository.UserRepository;
import ru.ithub.delivery.service.UserService;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final UserMapper mapper;


    @Override
    public List<UserDto> get() {
        return mapper.toDto(repository.findAll());
    }

    @Override
    public UserDto get(Long id) {
        return mapper.toDto(repository.findById(id).orElseThrow(() -> new RuntimeException("id is not found")));
    }

    @Override
    public void create(UserDto dto) {
        repository.save(mapper.toEntity(dto));
    }

    @Override
    public void update(Long id, UserDto dto) {
        User entity = mapper.toEntity(get(id));
        repository.save(mapper.update(entity, dto));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
