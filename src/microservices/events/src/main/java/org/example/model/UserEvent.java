package org.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.Instant;

@Data
public class UserEvent {
    @JsonProperty("user_id")
    private Long userId;

    @JsonProperty
    private String username;

    @JsonProperty
    private String action;

    @JsonProperty
    private Instant timestamp;
}
