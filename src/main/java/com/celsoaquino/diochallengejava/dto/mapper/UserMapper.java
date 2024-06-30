package com.celsoaquino.diochallengejava.dto.mapper;

import com.celsoaquino.diochallengejava.dto.user.UserDTO;
import com.celsoaquino.diochallengejava.dto.user.UserResponseDTO;
import com.celsoaquino.diochallengejava.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserResponseDTO toResponseDTO(User user) {
        return new UserResponseDTO(user.getId(), user.getName(), user.getEmail());
    }

    public User toEntity(UserDTO userDTO) {

        User user = new User();
        user.setName(userDTO.name());
        user.setEmail(userDTO.email());
        return user;
    }
}
