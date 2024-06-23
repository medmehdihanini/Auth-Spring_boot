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
    private static final int SUFFIX_LIMIT = 9999;
    BCryptPasswordEncoder passwordEncoder;

    private String generateUniqueUsername(String baseUsername) {
        Random random = new Random();
        String newUsername;
        int suffix;
        do {
            suffix = random.nextInt(SUFFIX_LIMIT) + 1;
            newUsername = baseUsername + "#" + String.format("%04d", suffix);
        } while (userRepository.existsUserByUserName(newUsername));
        return newUsername;
    }

    @Override
    public User Registre(User user) {
        String baseUsername = user.getUserName();
        String uniqueUsername = generateUniqueUsername(baseUsername);
        user.setUserName(uniqueUsername);
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        return userRepository.save(user);
    }

    @Override
    public void DeleteAccount(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User findUserById(long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User Login(LoginDto  loginDto) {
        User user = userRepository.findByEmailOrUserName(loginDto.getEmail(), loginDto.getUsername());
        if(passwordEncoder.matches(loginDto.getPassword(),user.getPassword())){

            return user;

        }
        return null;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User UpdateAccount(User e) {
        return userRepository.save(e);
    }
}
