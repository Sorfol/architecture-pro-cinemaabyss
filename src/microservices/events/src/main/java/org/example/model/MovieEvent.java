package org.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.Instant;

@Data
public class MovieEvent {
    @JsonProperty("movie_id")
    private Long movieId;
    @JsonProperty
    private String title;
    @JsonProperty
    private String action;  // "viewed", "rated", etc.
    @JsonProperty("user_id")
    private Long userId;
    @JsonProperty
    private Instant timestamp = Instant.now();
}
