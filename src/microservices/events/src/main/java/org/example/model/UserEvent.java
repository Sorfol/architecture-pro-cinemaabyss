package org.example.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserEvent {
    private final String userId;
    private final String name;
    private final String email;

    @JsonCreator
    public UserEvent(@JsonProperty("userId") String userId,
                        @JsonProperty("name") String name,
                        @JsonProperty("email") String email) {
        this.userId = userId;
        this.name = name;
        this.email = email;
    }
}
