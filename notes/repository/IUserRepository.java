package com.example.notes.repository;

import com.example.notes.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepository extends JpaRepository< UserModel ,Long> {
    Optional<UserModel> findByEmailID(String email);
}
