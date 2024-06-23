package com.example.auth._Services;

import com.example.auth.DTO.LoginDto;
import com.example.auth.Enteties.User;

import java.util.List;

public interface IUserService {
    User Registre(User user);
    void  DeleteAccount(long  id);
    User findUserById(long id);
    User Login(LoginDto loginDto);
    List<User> findAll();
    User UpdateAccount(User e);



}
