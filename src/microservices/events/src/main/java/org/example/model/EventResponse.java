package org.example.model;

import lombok.Data;

@Data
public class EventResponse {
    private String message;

    public EventResponse(String message) {
        this.message = message;
    }
}
