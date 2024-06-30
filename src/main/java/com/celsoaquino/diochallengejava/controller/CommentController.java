package com.celsoaquino.diochallengejava.controller;

import com.celsoaquino.diochallengejava.dto.comment.CommentDTO;
import com.celsoaquino.diochallengejava.service.CommentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public CommentDTO createComment(@RequestBody CommentDTO commentDTO) {
        return commentService.createComment(commentDTO);
    }
}
