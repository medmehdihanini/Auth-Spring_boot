package com.example.auth.Controller;

import com.example.auth._Services.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("foyer")
@RestController

public class UserController {
    private final IUserService userService;
}
