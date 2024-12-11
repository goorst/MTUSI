package ru.mtuci.project.requests;

import lombok.Data;

@Data
public class AuthenticationRequest {
    private String login, password;
}
