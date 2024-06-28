package com.celsoaquino.diochallengejava.repository;

import com.celsoaquino.diochallengejava.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
