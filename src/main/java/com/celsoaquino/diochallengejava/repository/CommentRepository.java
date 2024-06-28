package com.celsoaquino.diochallengejava.repository;

import com.celsoaquino.diochallengejava.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
