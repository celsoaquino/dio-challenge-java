package com.celsoaquino.diochallengejava.service;

import com.celsoaquino.diochallengejava.dto.mapper.PostMapper;
import com.celsoaquino.diochallengejava.dto.post.PostDTO;
import com.celsoaquino.diochallengejava.dto.post.PostResponseDTO;
import com.celsoaquino.diochallengejava.model.Post;
import com.celsoaquino.diochallengejava.repository.PostRepository;
import com.celsoaquino.diochallengejava.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final PostMapper postMapper;

    public PostService(PostRepository postRepository, UserRepository userRepository, PostMapper postMapper) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.postMapper = postMapper;
    }

    public List<PostResponseDTO> getAllPosts() {
        return postRepository.findAll().stream()
            .map(postMapper::toDTO)
            .toList();
    }

    public PostResponseDTO getPostById(Long id) {
        return postRepository.findById(id)
            .map(postMapper::toDTO)
            .orElseThrow(() -> new EntityNotFoundException("Post not found"));
    }

    public PostResponseDTO createPost(PostDTO postDTO) {
        var user = userRepository.findById(postDTO.userId())
            .orElseThrow(() -> new EntityNotFoundException("User not found with id " + postDTO.userId()));
        var post = new Post();
        post.setTitle(postDTO.title());
        post.setContent(postDTO.content());
        post.setCreatedAt(LocalDateTime.now());
        post.setUser(user);
        return postMapper.toDTO(postRepository.save(post));
    }

    public void deletePost(Long id) {
        var post = postRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Post not found"));
        postRepository.deleteById(post.getId());
    }
}
