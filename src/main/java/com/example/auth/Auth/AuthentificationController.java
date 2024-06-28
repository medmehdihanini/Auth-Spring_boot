package com.example.auth.Auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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


    @PostMapping("/authificate")
    public ResponseEntity<AuthentificationResponse> authentification(
            @RequestBody AuthentificationRequest request) throws MessagingException {
return ResponseEntity.ok(service.authentificate(request));
    }




    @GetMapping("/activate-account")
    public void confiormAccount(@RequestParam("token") String token) throws MessagingException {
        service.activateAccount(token);

    }
}
