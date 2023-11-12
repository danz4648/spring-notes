package com.danz.springnotes.response;

import java.time.Instant;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.Data;

@Data
public class RegisterResponse {
    private String message;

    @JsonFormat(pattern = "dd-MMM-yyyy HH:mm:ss", shape = Shape.STRING)
    private Date dateTime = Date.from(Instant.now());
}
