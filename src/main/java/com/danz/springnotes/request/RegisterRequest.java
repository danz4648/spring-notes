package com.danz.springnotes.request;

import com.danz.springnotes.model.Role;

import lombok.Data;

@Data
public class RegisterRequest {
    private String username;
    private String password;
    private Role role;
}
