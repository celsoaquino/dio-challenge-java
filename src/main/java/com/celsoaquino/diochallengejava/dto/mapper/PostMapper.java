package com.celsoaquino.diochallengejava.dto.mapper;

import com.celsoaquino.diochallengejava.dto.comment.CommentDTO;
import com.celsoaquino.diochallengejava.dto.post.PostDTO;
import com.celsoaquino.diochallengejava.dto.post.PostResponseDTO;
import com.celsoaquino.diochallengejava.model.Post;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class PostMapper {

    public PostResponseDTO toDTO(Post post) {
        if (post == null) return null;

        List<CommentDTO> comments = (post.getComments() == null) ?
            Collections.emptyList()
            : post.getComments()
            .stream()
            .map(comment -> new CommentDTO(comment.getId(), comment.getContent(), comment.getPost().getId()))
            .toList();

        return new PostResponseDTO(post.getId(), post.getUser().getId(), post.getTitle(), post.getContent(), post.getCreatedAt(), comments);
    }

    public Post toEntity(PostDTO postDTO) {
        if (postDTO == null) return null;
        Post post = new Post();
        post.setTitle(postDTO.title());
        post.setContent(postDTO.content());
        return post;
    }
}
