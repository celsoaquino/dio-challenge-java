package com.celsoaquino.diochallengejava.dto.comment;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CommentDTO(
    @JsonProperty("post_id") @NotNull Long postId,
    @NotBlank String content) {
}

