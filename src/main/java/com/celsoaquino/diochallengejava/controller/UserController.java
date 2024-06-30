package com.celsoaquino.diochallengejava.controller;


import com.celsoaquino.diochallengejava.dto.user.UserDTO;
import com.celsoaquino.diochallengejava.dto.user.UserResponseDTO;
import com.celsoaquino.diochallengejava.dto.user.UserWithPostsDTO;
import com.celsoaquino.diochallengejava.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}/posts-comments")
    public ResponseEntity<UserWithPostsDTO> getUserWithPostsAndComments(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserWithPostsAndComments(id));
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody @Valid UserDTO userDTO) {
        return ResponseEntity.ok(userService.createUser(userDTO));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
