package org.example.controller;

import com.cinemaabyss.events.model.*;
import com.cinemaabyss.events.service.EventProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/events")
public class EventController {

    private final EventProducer eventProducer;

    public EventController(EventProducer eventProducer) {
        this.eventProducer = eventProducer;
    }

    @PostMapping("/movie")
    public ResponseEntity<EventResponse> createMovieEvent(@RequestBody MovieEvent event) {
        eventProducer.sendMovieEvent(event);
        return ResponseEntity.ok(new EventResponse("Movie event created"));
    }

    @PostMapping("/user")
    public ResponseEntity<EventResponse> createUserEvent(@RequestBody UserEvent event) {
        eventProducer.sendUserEvent(event);
        return ResponseEntity.ok(new EventResponse("User event created"));
    }

    @PostMapping("/payment")
    public ResponseEntity<EventResponse> createPaymentEvent(@RequestBody PaymentEvent event) {
        eventProducer.sendPaymentEvent(event);
        return ResponseEntity.ok(new EventResponse("Payment event created"));
    }
}
