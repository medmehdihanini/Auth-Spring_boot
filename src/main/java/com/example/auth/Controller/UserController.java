package com.example.auth.Controller;

import com.example.auth.DTO.LoginDto;
import com.example.auth.Enteties.User;
import com.example.auth._Services.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("foyer")
@RestController

public class UserController {
    private final IUserService userService;

    @GetMapping("All")
    public List<User> GetAll(){return userService.findAll();}


    @PostMapping("Registre")
    public User Registre(@RequestBody User user) {
        return userService.Registre(user);
    }


    @PutMapping("Update")
    public User Update(@RequestBody User e){
        return userService.UpdateAccount(e);
    }
    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable long id){
        userService.DeleteAccount(id);}


    @PostMapping("/login")
    public User login(@RequestBody LoginDto loginDto) {

            return userService.Login(loginDto);

        }
}
