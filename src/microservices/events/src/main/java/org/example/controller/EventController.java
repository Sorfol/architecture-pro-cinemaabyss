package org.example.controller;


import lombok.RequiredArgsConstructor;
import org.example.model.*;
import org.example.service.EventProducerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/events")
public class EventController {

    private final EventProducerService eventProducerService;

    public EventController(EventProducerService eventProducerService) {
        this.eventProducerService = eventProducerService;
    }

    @GetMapping("/health")
    public String checkHealth() {
        return "Events service is up and running!";
    }

    // Обработчик запросов для создания события фильма
    @PostMapping("/movie")
    @ResponseStatus(HttpStatus.CREATED)
    public void createMovieEvent(@RequestBody MovieEvent movieEvent) {
        eventProducerService.sendMessage("movie-event-topic", movieEvent);
    }

    // Обработчик запросов для создания события пользователя
    @PostMapping("/user")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUserEvent(@RequestBody UserEvent userEvent) {
        eventProducerService.sendMessage("user-event-topic", userEvent);
    }

    // Обработчик запросов для создания события платежа
    @PostMapping("/payment")
    @ResponseStatus(HttpStatus.CREATED)
    public void createPaymentEvent(@RequestBody PaymentEvent paymentEvent) {
        eventProducerService.sendMessage("payment-event-topic", paymentEvent);
    }
}
