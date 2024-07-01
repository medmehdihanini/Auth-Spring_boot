package com.example.auth.Auth;

import com.example.auth.DTO.InfoDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import jakarta.mail.MessagingException;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthentificationController {
    private final AuthentificationService service;

    @PostMapping("/registre")
    public ResponseEntity<?> registre(@RequestBody @Valid RegistrationRequest request) throws MessagingException {
        System.out.println("Password: " + request.getPassword());
        System.out.println("Email: " + request.getEmail());
        service.registre(request);
        return ResponseEntity.accepted().build();
    }


    @PostMapping("/authificate")
    public ResponseEntity<AuthentificationResponse> authentification(
            @RequestBody  @Valid AuthentificationRequest request) throws MessagingException {
return ResponseEntity.ok(service.authenticate(request));
    }




    @GetMapping("/activate-account")
    public void confiormAccount(@RequestParam("token") String token) throws MessagingException {
        service.activateAccount(token);

    }


    @GetMapping("/user")
    public UserDetails getUserDetails(@RequestHeader("Authorization") String authorizationHeader) {
        String token = authorizationHeader.substring(7);
        return service.getUserDetailsFromToken(token);
    }


}
