package com.example.auth._Services.IMP;

import com.example.auth.DTO.LoginDto;
import com.example.auth.Enteties.User;
import com.example.auth.Repositories.IUserRepository;
import com.example.auth._Services.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Primary
@AllArgsConstructor
@Service
public class UserServiceImp implements IUserService {
    IUserRepository userRepository;

    @Override
    public User Registre(User user) {
        return null;
    }

    @Override
    public void DeleteAccount(long id) {

    }

    @Override
    public User findUserById(long id) {
        return null;
    }

    @Override
    public User Login(LoginDto loginDto) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return List.of();
    }

    @Override
    public User UpdateAccount(User e) {
        return null;
    }
}
