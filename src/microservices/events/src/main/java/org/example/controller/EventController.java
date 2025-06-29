package org.example.controller;

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

    public EventController(EventProducerService eventProducerService) {
        this.eventProducerService = eventProducerService;
    }

    @GetMapping("/health")
    public ResponseEntity<Map<String, Boolean>> checkHealth() {
        Map<String, Boolean> response = new HashMap<>();
        response.put("status", true);
        return ResponseEntity.ok(response);
    }

    // Обработчик запросов для создания события фильма
    @PostMapping("/movie")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Map<String, String>> createMovieEvent(@RequestBody MovieEvent movieEvent) {
        eventProducerService.sendMessage("movie-event-topic", movieEvent);
        Map<String, String> response = new HashMap<>();
        response.put("status", "success");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // Обработчик запросов для создания события пользователя
    @PostMapping("/user")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Map<String, String>> createUserEvent(@RequestBody UserEvent userEvent) {
        eventProducerService.sendMessage("user-event-topic", userEvent);
        Map<String, String> response = new HashMap<>();
        response.put("status", "success"); // Сообщение обработано успешно
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // Обработчик запросов для создания события платежа
    @PostMapping("/payment")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Map<String, String>> createPaymentEvent(@RequestBody PaymentEvent paymentEvent) {
        eventProducerService.sendMessage("payment-event-topic", paymentEvent);
        Map<String, String> response = new HashMap<>();
        response.put("status", "success"); // Сообщение обработано успешно
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
