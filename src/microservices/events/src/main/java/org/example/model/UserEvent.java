package org.example.model;

import lombok.Data;

import java.time.Instant;

@Data
public class UserEvent {
    private Long userId;
    private String username;
    private String action;  // "logged_in", "registered", etc.
    private Instant timestamp;
}
