package com.example.auth._Services.IMP;

import com.example.auth.Repositories.IUserRepository;
import com.example.auth._Services.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@AllArgsConstructor
@Service
public class UserServiceImp implements IUserService {
    IUserRepository userRepository;
}
