package com.celsoaquino.diochallengejava.dto.post;

import com.celsoaquino.diochallengejava.dto.comment.CommentDTO;
import com.celsoaquino.diochallengejava.dto.comment.CommentResponseDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.List;

public record PostResponseDTO(Long id,
                              @JsonProperty("user_id") Long userId,
                              String title,
                              String content,
                              @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss") LocalDateTime createdAt,
                              @JsonInclude(value = JsonInclude.Include.NON_EMPTY) List<CommentResponseDTO> comments) {
}
