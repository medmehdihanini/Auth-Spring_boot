package com.example.auth.Email;

import lombok.Getter;

@Getter
public enum EmailTemplate {
ACTIVATE_ACCOUNT("activate_account"),
    FORGET_PASSWORD("forget_password");

    private final String name ;

    EmailTemplate(String name) {
        this.name = name;
    }
}
