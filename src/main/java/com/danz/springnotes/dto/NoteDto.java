package com.danz.springnotes.dto;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NoteDto {
    private String noteID;
    private String name;
    private String description;
    private Date lastModDate;
    private Date createdDate;
}
