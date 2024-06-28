package com.example.auth.Auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import jakarta.mail.MessagingException;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthentificationController {
    private final AuthentificationService service;

    @PostMapping("/registre")
    public ResponseEntity<?> registre(@RequestBody RegistrationRequest request) throws MessagingException {
        System.out.println("Password: " + request.getPassword());
        System.out.println("Email: " + request.getEmail());
        service.registre(request);
        return ResponseEntity.accepted().build();
    }
}
