package com.celsoaquino.diochallengejava.service;

import com.celsoaquino.diochallengejava.dto.comment.CommentDTO;
import com.celsoaquino.diochallengejava.dto.comment.CommentResponseDTO;
import com.celsoaquino.diochallengejava.model.Comment;
import com.celsoaquino.diochallengejava.repository.CommentRepository;
import com.celsoaquino.diochallengejava.repository.PostRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    public CommentService(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    public CommentResponseDTO createComment(CommentDTO commentDTO) {
        var post = postRepository.findById(commentDTO.postId())
            .orElseThrow(() -> new EntityNotFoundException("Post not found"));
        Comment comment = new Comment();
        comment.setContent(commentDTO.content());
        comment.setPost(post);
        commentRepository.save(comment);
        return new CommentResponseDTO(comment.getId(), comment.getContent(), comment.getPost().getId());
    }

    @Transactional
    public void deleteComment(Long commentId) {
        var comment = commentRepository.findById(commentId)
            .orElseThrow(() -> new EntityNotFoundException("Comment not found"));
        commentRepository.delete(comment);
    }
}
