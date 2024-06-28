package com.example.auth.Auth;




import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class RegistrationRequest {

    private String firstName;

    private String lastName;


    private String email;

    private String password;
}
