package org.example.model;

import lombok.Data;

@Data
public class UserEvent {
    private String userId;
    private String action; // "login", "logout", "register"
    private String device;
}
