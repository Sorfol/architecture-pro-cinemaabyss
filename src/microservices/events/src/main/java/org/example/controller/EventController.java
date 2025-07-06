package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.model.*;
import org.example.service.EventProducerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/events")
public class EventController {

    private final EventProducerService eventProducerService;

    @GetMapping("/health")
    public ResponseEntity<Map<String, Object>> healthCheck() {
        Map<String, Object> response = new HashMap<>();
        response.put("status", true);
        response.put("service", "Events Microservice");
        response.put("timestamp", Instant.now().toString());
        return ResponseEntity.ok(response);
    }

    @PostMapping("/movie")
    public ResponseEntity<Map<String, String>> createMovieEvent(@RequestBody MovieEvent event) {
        eventProducerService.sendMessage("movie-events", event);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("status", "success"));
    }

    @PostMapping("/user")
    public ResponseEntity<Map<String, String>> createUserEvent(@RequestBody UserEvent event) {
        eventProducerService.sendMessage("user-events", event);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("status", "success"));
    }

    @PostMapping("/payment")
    public ResponseEntity<Map<String, String>> createPaymentEvent(@RequestBody PaymentEvent event) {
        eventProducerService.sendMessage("payment-events", event);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("status", "success"));
    }
}
