package com.celsoaquino.diochallengejava.dto.mapper;

import com.celsoaquino.diochallengejava.dto.comment.CommentResponseDTO;
import com.celsoaquino.diochallengejava.dto.post.PostResponseDTO;
import com.celsoaquino.diochallengejava.model.Post;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class PostMapper {

    public PostResponseDTO toDTO(Post post) {

        List<CommentResponseDTO> comments = (post.getComments() == null) ?
            Collections.emptyList()
            : post.getComments()
            .stream()
            .map(comment -> new CommentResponseDTO(comment.getId(), comment.getContent(), comment.getPost().getId()))
            .toList();

        return new PostResponseDTO(post.getId(), post.getUser().getId(), post.getTitle(), post.getContent(), post.getCreatedAt(), comments);
    }
}
