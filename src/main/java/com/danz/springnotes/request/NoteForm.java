package com.danz.springnotes.request;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class NoteForm {
    private String id;
    private String name;
    private String description;
}
