package ru.ithub.delivery.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.ithub.delivery.entity.ERole;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String username;
    private String fio;
    private String email;
    private String password;
    private ERole role = ERole.ROLE_CUSTOMER;

}

