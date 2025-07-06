package org.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieEvent {
    @JsonProperty("movieId")
    private String movieId;

    @JsonProperty("eventType")
    private String eventType;
}
