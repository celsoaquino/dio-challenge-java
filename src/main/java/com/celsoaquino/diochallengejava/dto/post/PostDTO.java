package com.celsoaquino.diochallengejava.dto.post;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record PostDTO(
    @JsonProperty("user_id")
    @NotNull Long userId,
    @NotBlank String title,
    @NotBlank String content) {
}

