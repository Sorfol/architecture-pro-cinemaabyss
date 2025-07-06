package org.example.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieEvent {
    @JsonProperty("movie_id")
    private Long movieId;

    @JsonProperty("title")
    private String title;

    @JsonProperty("action")
    private String action;

    @JsonProperty("user_id")
    private Long userId;
}