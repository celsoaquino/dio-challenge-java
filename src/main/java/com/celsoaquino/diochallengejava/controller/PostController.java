package com.celsoaquino.diochallengejava.controller;

import com.celsoaquino.diochallengejava.dto.post.PostDTO;
import com.celsoaquino.diochallengejava.dto.post.PostResponseDTO;
import com.celsoaquino.diochallengejava.service.PostService;
import jakarta.validation.Valid;
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
    public List<PostResponseDTO> findAll() {
        return postService.getAllPosts();
    }

    @PostMapping
    public PostResponseDTO save(@RequestBody @Valid PostDTO postDTO) {
        return postService.createPost(postDTO);
    }
}
