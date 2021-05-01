package com.appslab.bazosapp.models;

public enum Role {
    USER("User"),
    ADMIN("Admin");
    protected final String name;

    Role(String name) {
        this.name = name;
    }
}
