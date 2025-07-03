package org.example.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MovieEvent {
    private final String movieId;
    private final String eventType;

    @JsonCreator
    public MovieEvent(@JsonProperty("movieId") String movieId,
                      @JsonProperty("eventType") String eventType) {
        this.movieId = movieId;
        this.eventType = eventType;
    }
}
