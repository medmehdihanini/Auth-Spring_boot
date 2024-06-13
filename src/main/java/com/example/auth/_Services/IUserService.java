package com.example.auth._Services;

import com.example.auth.Enteties.User;

public interface IUserService {
    User Registre(User user);
    void  DeleteAccount(long  id);
    User findUserById(long id);
    User Login(String username,String email ,String password);

}
