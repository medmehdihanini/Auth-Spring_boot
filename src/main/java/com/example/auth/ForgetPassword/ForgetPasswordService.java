package com.example.auth.ForgetPassword;

import com.example.auth.Email.EmailService;
import com.example.auth.Email.EmailTemplate;
import com.example.auth.Enteties.Token;
import com.example.auth.Enteties.User;
import com.example.auth.Repositories.IUserRepository;
import com.example.auth.Repositories.TokenRepository;
import jakarta.mail.MessagingException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ForgetPasswordService {

    private final IUserRepository userRepository;
    private final TokenRepository tokenRepository;
    private final EmailService emailService;
    private final PasswordEncoder passwordEncoder;


    @Value("${application.mailing.frontend.forgetPassword}")
    String resetPasswordUrl;

    public void generateResetToken(String email) throws MessagingException {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        String token = generateResetPasswordToken();
        Token resetToken = Token.builder()
                .token(token)
                .createdat(LocalDateTime.now())
                .expiredat(LocalDateTime.now().plusMinutes(15))
                .user(user)
                .build();
        tokenRepository.save(resetToken);

        sendResetPasswordEmail(user, token);
    }

    private String generateResetPasswordToken() {
        String charactere = "0123456789";
        StringBuilder codebuilder = new StringBuilder();
        SecureRandom secureRandom = new SecureRandom();

        for (int i = 0; i < 6; i++) {
            int randomindex = secureRandom.nextInt(charactere.length());
            codebuilder.append(charactere.charAt(randomindex));
        }
        return codebuilder.toString();
    }

    private void sendResetPasswordEmail(User user, String token) throws MessagingException {
        emailService.Sendvalidationmail(
                user.getEmail(),
                user.getFirstName() + " " + user.getLastName(),
                EmailTemplate.FORGET_PASSWORD,
                resetPasswordUrl + "?token=" + token,
                token,
                "Reset your password"
        );
    }

    @Transactional
    public void resetPassword(String token, String newPassword) throws MessagingException {
        Token resetToken = tokenRepository.findByToken(token)
                .orElseThrow(() -> new RuntimeException("Invalid token"));

        if (LocalDateTime.now().isAfter(resetToken.getExpiredat())) {
            sendResetPasswordEmail(resetToken.getUser(), token);
            throw new RuntimeException("Token expired");
        }
        if (newPassword.length() < 8) {
            throw new RuntimeException("Password must be at least 8 characters long");
        }

        User user = resetToken.getUser();
        user.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(user);
        resetToken.setValidatedat(LocalDateTime.now());
        tokenRepository.save(resetToken);
    }
}
