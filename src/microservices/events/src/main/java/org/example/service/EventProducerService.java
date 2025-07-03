package org.example.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class EventProducerService {
    private static final Logger logger = LoggerFactory.getLogger(EventProducerService.class);
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public EventProducerService(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public <T> void sendMessage(String topic, Object message) {
        try {
            String json = new ObjectMapper().writeValueAsString(message);
            kafkaTemplate.send(topic, json);
            logger.info("Отправлено сообщение в тему {}: {}", topic, message);
        } catch (Exception e) {
            logger.error("Ошибка отправки сообщения:", e);
            throw new RuntimeException("Failed to send message to Kafka", e);
        }
    }
}
