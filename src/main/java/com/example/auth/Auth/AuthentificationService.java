package com.example.auth.Auth;

import com.example.auth.Config.JwtService;
import com.example.auth.Config.UserDetailsServiceImp;
import com.example.auth.DTO.InfoDto;
import com.example.auth.Email.EmailService;
import com.example.auth.Email.EmailTemplate;
import com.example.auth.Enteties.Token;
import com.example.auth.Enteties.User;
import com.example.auth.Repositories.IUserRepository;
import com.example.auth.Repositories.RoleRepository;
import com.example.auth.Repositories.TokenRepository;
import com.nimbusds.openid.connect.sdk.AuthenticationRequest;
import com.nimbusds.openid.connect.sdk.AuthenticationResponse;
import jakarta.mail.MessagingException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AuthentificationService {
    public final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final IUserRepository userRepository;
    private final TokenRepository tokenRepository;
    private final EmailService emailService;
    private final AuthenticationManager authentificationManager;
    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;


    @Value("${application.mailing.frontend.activationUrl}")
    String activationUrl;

    public void registre(RegistrationRequest request) throws MessagingException {
        var userRole = roleRepository.findByName("USER")
                .orElseThrow(() -> new UsernameNotFoundException("role user was not inti"));
        System.out.println("User role found: " + userRole.getName());
        System.out.println("Password: " + request.getPassword());

        var user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .accountlocked(false)
                .enabled(false)
                .roles(List.of(userRole))
                .build();
        userRepository.save(user);
        sendValidationEmail(user);
    }

    private void sendValidationEmail(User user) throws MessagingException {
        var newToken = generatedAndSaveActivationToken(user);

        emailService.Sendmail(
                user.getEmail(),
                user.getFirstName() + " " + user.getLastName(),
                EmailTemplate.ACTIVATE_ACCOUNT,
                activationUrl,
                newToken,
                "Activate your account"
        );
    }

    private String generatedAndSaveActivationToken(User user) {
        String generatedToken = generatedActivatedToken(6);
        var token = Token.builder()
                .token(generatedToken)
                .createdat(LocalDateTime.now())
                .expiredat(LocalDateTime.now().plusMinutes(15))
                .user(user)
                .build();
        tokenRepository.save(token);
        return generatedToken;
    }

    private String generatedActivatedToken(int length) {
        String charactere = "0123456789";
        StringBuilder codebuilder = new StringBuilder();
        SecureRandom secureRandom = new SecureRandom();

        for (int i = 0; i < length; i++) {
            int randomindex = secureRandom.nextInt(charactere.length());
            codebuilder.append(charactere.charAt(randomindex));
        }
        return codebuilder.toString();
    }

    public AuthentificationResponse authenticate(AuthentificationRequest request) {
        var auth = authentificationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        var claims = new HashMap<String, Object>();
        var user = ((User) auth.getPrincipal());
        claims.put("fullName", user.getFirstName() + " " + user.getLastName());

        var jwtToken = jwtService.generateToken(claims, (User) auth.getPrincipal());
        return AuthentificationResponse.builder()
                .token(jwtToken)
                .build();
    }


    @Transactional
    //tnajm tnaiha
    public void activateAccount(String token) throws MessagingException {
        Token savedToken = tokenRepository.findByToken(token).orElseThrow(()-> new RuntimeException("token not found"));
        if (LocalDateTime.now().isAfter(savedToken.getExpiredat()))
        {
            sendValidationEmail(savedToken.getUser());
            throw new RuntimeException("token expired a new token has been send to your email");
        }
        var user = userRepository.findById(savedToken.getUser().getId()).orElseThrow(()-> new RuntimeException("user not found"));
        user.setEnabled(true);
        userRepository.save(user);
        savedToken.setValidatedat(LocalDateTime.now());
        tokenRepository.save(savedToken);
    }


    public InfoDto info(String token) {

        var user = userRepository.findByEmail(jwtService.extractEmail(token)).orElseThrow(()-> new RuntimeException("user not found"));
        return InfoDto.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }

    public UserDetails getUserDetailsFromToken(String token) {
        String userEmail = jwtService.extractUsername(token);
        return userDetailsService.loadUserByUsername(userEmail);
    }
}

