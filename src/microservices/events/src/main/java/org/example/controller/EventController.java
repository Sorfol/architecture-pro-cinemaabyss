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
@Slf4j
@RequestMapping("/api/events")
public class EventController {

    private final EventProducerService eventProducerService;

    public EventController(EventProducerService eventProducerService) {
        this.eventProducerService = eventProducerService;
    }

    @GetMapping("/health")
    public ResponseEntity<Map<String, Boolean>> checkHealth() {
        Map<String, Boolean> response = new HashMap<>();
        response.put("status", true);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/movie")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Map<String, String>> createMovieEvent(@RequestBody MovieEvent movieEvent) {
        log.info("Received movie event: {}", movieEvent);
        eventProducerService.sendMessage("movie-event-topic", movieEvent);
        Map<String, String> response = new HashMap<>();
        response.put("status", "success");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/user")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Map<String, String>> createUserEvent(@RequestBody UserEvent userEvent) {
        log.info("Received user event: {}", userEvent);
        eventProducerService.sendMessage("user-event-topic", userEvent);
        Map<String, String> response = new HashMap<>();
        response.put("status", "success");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/payment")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Map<String, String>> createPaymentEvent(@RequestBody PaymentEvent paymentEvent) {
        log.info("Received payment event: {}", paymentEvent);
        eventProducerService.sendMessage("payment-event-topic", paymentEvent);
        Map<String, String> response = new HashMap<>();
        response.put("status", "success");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
