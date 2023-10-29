package com.danz.springnotes.model;

import java.util.stream.Stream;

public enum Role {
    ADMIN("ADMIN"), USER("USER");

    private String roleName;

    private Role(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public static Role of(String roleName) {
        return Stream.of(Role.values()).filter(r -> r.getRoleName().equalsIgnoreCase(roleName)).findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

}
