package org.example.service;

import org.example.model.*;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class EventProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public EventProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMovieEvent(MovieEvent event) {
        kafkaTemplate.send("movie-events", event);
        System.out.println("Sent movie event: " + event);
    }

    public void sendUserEvent(UserEvent event) {
        kafkaTemplate.send("user-events", event);
        System.out.println("Sent user event: " + event);
    }

    public void sendPaymentEvent(PaymentEvent event) {
        kafkaTemplate.send("payment-events", event);
        System.out.println("Sent payment event: " + event);
    }
}
