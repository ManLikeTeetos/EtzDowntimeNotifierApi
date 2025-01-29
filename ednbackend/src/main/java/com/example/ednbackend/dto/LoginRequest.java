package com.example.ednbackend.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstrutor
public class LoginRequest {
    private String email;
    private String password;
}