package com.example.notes.userRepository;

import com.example.notes.userModel.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepository extends JpaRepository< UserModel ,Long> {
    Optional<UserModel> findByEmailID(String email);
}
