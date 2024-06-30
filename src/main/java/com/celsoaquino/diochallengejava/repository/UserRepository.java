package com.celsoaquino.diochallengejava.repository;


import com.celsoaquino.diochallengejava.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String username);
}
