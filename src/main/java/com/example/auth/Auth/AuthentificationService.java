package com.example.auth.Auth;

import com.example.auth.Email.EmailService;
import com.example.auth.Email.EmailTemplate;
import com.example.auth.Enteties.Token;
import com.example.auth.Enteties.User;
import com.example.auth.Repositories.IUserRepository;
import com.example.auth.Repositories.RoleRepository;
import com.example.auth.Repositories.TokenRepository;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthentificationService {
    public final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final IUserRepository userRepository;
    private final TokenRepository tokenRepository;
    private final EmailService emailService;

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
}
