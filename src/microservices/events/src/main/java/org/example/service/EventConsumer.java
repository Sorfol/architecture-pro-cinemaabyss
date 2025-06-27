package org.example.service;

import com.cinemaabyss.events.model.*;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class EventConsumer {

    @KafkaListener(topics = "movie-events", groupId = "events-group")
    public void consumeMovieEvent(MovieEvent event) {
        System.out.println("Consumed movie event: " + event);
    }

    @KafkaListener(topics = "user-events", groupId = "events-group")
    public void consumeUserEvent(UserEvent event) {
        System.out.println("Consumed user event: " + event);
    }

    @KafkaListener(topics = "payment-events", groupId = "events-group")
    public void consumePaymentEvent(PaymentEvent event) {
        System.out.println("Consumed payment event: " + event);
    }
}
