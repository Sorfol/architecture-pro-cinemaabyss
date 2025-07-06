package org.example.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EventProducerService {
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public EventProducerService(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String topic, Object message) {
        try {
            kafkaTemplate.send(topic, message);
            log.info("Sent message to {}: {}", topic, message);
        } catch (Exception e) {
            log.error("Error sending message to topic {}: {}", topic, e.getMessage());
            throw new RuntimeException("Failed to send message to Kafka", e);
        }
    }
}
