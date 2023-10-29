package com.danz.springnotes.response;

import java.time.Instant;

import lombok.Data;

@Data
public class RegisterResponse {
    private String message;

    private Instant createdDate = Instant.now();
}
