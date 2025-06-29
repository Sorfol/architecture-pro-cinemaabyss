package org.example.controller;


import org.example.model.*;
import org.example.service.EventProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/events")
public class EventController {

    private final EventProducer eventProducer;

    public EventController(EventProducer eventProducer) {
        this.eventProducer = eventProducer;
    }

    @GetMapping("/health")
    public ResponseEntity<Map<String, String>> healthCheck() {
        return ResponseEntity.ok(Map.of("status", "ok"));
    }

    @PostMapping("/movie")
    public ResponseEntity<Map<String, String>> createMovieEvent(@RequestBody MovieEvent event) {
        eventProducer.sendMovieEvent(event);
        return ResponseEntity.status(201).body(Map.of("status", "success"));
    }

    @PostMapping("/user")
    public ResponseEntity<Map<String, String>> createUserEvent(@RequestBody UserEvent event) {
        eventProducer.sendUserEvent(event);
        return ResponseEntity.status(201).body(Map.of("status", "success"));
    }

    @PostMapping("/payment")
    public ResponseEntity<Map<String, String>> createPaymentEvent(@RequestBody PaymentEvent event) {
        eventProducer.sendPaymentEvent(event);
        return ResponseEntity.status(201).body(Map.of("status", "success"));
    }
}
