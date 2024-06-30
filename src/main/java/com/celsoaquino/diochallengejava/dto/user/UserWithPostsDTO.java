package com.celsoaquino.diochallengejava.dto.user;

import com.celsoaquino.diochallengejava.dto.post.PostResponseDTO;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

public record UserWithPostsDTO(
    Long id, String name, String email,
    @JsonInclude(JsonInclude.Include.NON_EMPTY) List<PostResponseDTO> posts) {
}
