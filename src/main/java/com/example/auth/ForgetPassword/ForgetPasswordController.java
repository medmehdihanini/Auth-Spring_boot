package com.example.auth.ForgetPassword;

import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/password")
@RequiredArgsConstructor
public class ForgetPasswordController {

    private final ForgetPasswordService forgetPasswordService;

    @PostMapping("/forgot")
    public void forgotPassword(@RequestParam String email) throws MessagingException {
        forgetPasswordService.generateResetToken(email);
    }

    @PostMapping("/reset")
    public void resetPassword(@RequestParam String token, @RequestParam String newPassword) throws MessagingException {
        forgetPasswordService.resetPassword(token, newPassword);
    }
}
