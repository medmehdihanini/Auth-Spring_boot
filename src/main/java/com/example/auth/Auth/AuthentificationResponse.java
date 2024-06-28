package com.example.auth.Auth;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AuthentificationResponse {

    private String token;
}
