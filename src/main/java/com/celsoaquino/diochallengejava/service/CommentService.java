package com.celsoaquino.diochallengejava.service;

import com.celsoaquino.diochallengejava.dto.comment.CommentDTO;
import com.celsoaquino.diochallengejava.model.Comment;
import com.celsoaquino.diochallengejava.model.Post;
import com.celsoaquino.diochallengejava.repository.CommentRepository;
import com.celsoaquino.diochallengejava.repository.PostRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    public CommentService(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    public CommentDTO createComment(CommentDTO commentDTO) {
        Post post = postRepository.findById(commentDTO.postId())
            .orElseThrow(EntityNotFoundException::new);
        Comment comment = new Comment();
        comment.setContent(commentDTO.content());
        comment.setPost(post);
        commentRepository.save(comment);
        return commentDTO;
    }
}
