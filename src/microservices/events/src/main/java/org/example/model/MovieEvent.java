package org.example.model;

import lombok.Data;

@Data
public class MovieEvent {
    private String movieId;
    private String title;
    private String action; // "view", "rating", "favorite"
    private Integer rating;
}
