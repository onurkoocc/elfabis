package com.example.elfabis.Payload.Request;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class UserInfoRequest {
    private int id;
    private String name;
    private String title;
    private String abd;
    private String abbr;

    @NotBlank
    @Size(min = 3, max = 20)
    private String username;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    private String role = "";

    @NotBlank
    @Size(min = 6, max = 40)
    private String password;
}