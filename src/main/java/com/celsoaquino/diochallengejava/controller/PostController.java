package com.celsoaquino.diochallengejava.controller;

import com.celsoaquino.diochallengejava.dto.post.PostDTO;
import com.celsoaquino.diochallengejava.dto.post.PostResponseDTO;
import com.celsoaquino.diochallengejava.service.PostService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public ResponseEntity<List<PostResponseDTO>> findAll() {
        return ResponseEntity.ok(postService.getAllPosts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(postService.getPostById(id));
    }

    @PostMapping
    public ResponseEntity<PostResponseDTO> save(@RequestBody @Valid PostDTO postDTO) {
        return ResponseEntity.ok(postService.createPost(postDTO));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        postService.deletePost(id);
    }
}
