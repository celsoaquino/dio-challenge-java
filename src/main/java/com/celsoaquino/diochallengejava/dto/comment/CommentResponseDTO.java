package com.celsoaquino.diochallengejava.dto.comment;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CommentResponseDTO(Long id, String content, @JsonProperty("post_id") Long postId) {
}
