package com.example.auth.Repositories;

import com.example.auth.Enteties.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {
    boolean existsUserByUserName(String username);
}