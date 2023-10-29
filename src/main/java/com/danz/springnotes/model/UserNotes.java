package com.danz.springnotes.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Entity
@Table(name = "user_notes")
@Data
public class UserNotes {

    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    @Column(name = "user_id", nullable = false)
    private String uid;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "pwd", nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role_name", nullable = false)
    private Role role;
}
