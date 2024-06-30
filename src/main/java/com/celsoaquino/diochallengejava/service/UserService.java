package com.celsoaquino.diochallengejava.service;

import com.celsoaquino.diochallengejava.dto.mapper.PostMapper;
import com.celsoaquino.diochallengejava.dto.mapper.UserMapper;
import com.celsoaquino.diochallengejava.dto.post.PostResponseDTO;
import com.celsoaquino.diochallengejava.dto.user.UserDTO;
import com.celsoaquino.diochallengejava.dto.user.UserResponseDTO;
import com.celsoaquino.diochallengejava.dto.user.UserWithPostsDTO;
import com.celsoaquino.diochallengejava.repository.PostRepository;
import com.celsoaquino.diochallengejava.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ValidationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final UserMapper userMapper;
    private final PostMapper postMapper;

    public UserService(UserRepository userRepository, PostRepository postRepository, UserMapper userMapper, PostMapper postMapper) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
        this.userMapper = userMapper;
        this.postMapper = postMapper;
    }

    public UserWithPostsDTO getUserWithPostsAndComments(Long userId) {
        var user = userRepository.findById(userId)
            .orElseThrow(() -> new EntityNotFoundException("User not found with id " + userId));

        List<PostResponseDTO> posts = postRepository.findByUserId(user.getId())
            .stream()
            .map(postMapper::toDTO)
            .toList();

        return new UserWithPostsDTO(user.getId(), user.getName(), user.getEmail(), posts);
    }


    public List<UserResponseDTO> getAllUsers() {
        return userRepository.findAll().stream()
            .map(userMapper::toResponseDTO)
            .toList();
    }

    public UserResponseDTO getUserById(Long id) {
        return userRepository.findById(id)
            .map(userMapper::toResponseDTO)
            .orElseThrow(() -> new EntityNotFoundException("User not found with id " + id));
    }

    public UserResponseDTO createUser(UserDTO userDTO) {
        var emailExists = userRepository.existsByEmail(userDTO.email());
        if (emailExists) throw new ValidationException("e-mail already registered!");
        return userMapper.toResponseDTO(userRepository.save(userMapper.toEntity(userDTO)));
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
