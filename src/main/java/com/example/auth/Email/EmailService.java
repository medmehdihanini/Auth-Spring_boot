package com.example.auth.Email;


import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;
    private final SpringTemplateEngine templateEngine;


@Async
    public void Sendmail(String to
            , String username
            , EmailTemplate emailTemplate
            ,String confirmationUrl
            ,String activationcode
            ,String subject
    ) throws MessagingException {
        String templatename ;
        if (emailTemplate == null)
        {
            templatename = "confirme-email";
        }else {
            templatename = emailTemplate.name();
        }

        MimeMessage mimeMessage = mailSender.createMimeMessage();
                MimeMessageHelper helper = new MimeMessageHelper(mimeMessage
                        , MimeMessageHelper.MULTIPART_MODE_MIXED
                        , StandardCharsets.UTF_8.name());
        Map<String, Object> properties = new HashMap<>();
        properties.put("username", username);
        properties.put("confirmationUrl", confirmationUrl);
        properties.put("activationcode", activationcode);
        Context context = new Context();
        context.setVariables(properties);

     helper.setFrom("medi.hanini13@gmail.com");
        helper.setTo(to);
        helper.setSubject(subject);
        String template = templateEngine.process(templatename, context);
        helper.setText(template, true);
        mailSender.send(mimeMessage);




    }


























}
