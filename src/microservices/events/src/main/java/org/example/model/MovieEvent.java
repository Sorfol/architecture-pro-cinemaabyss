package org.example.model;

import lombok.Data;

import java.time.Instant;

@Data
public class MovieEvent {
    private Long movieId;
    private String title;
    private String action;  // "viewed", "rated", etc.
    private Long userId;
    private Instant timestamp = Instant.now();
}
