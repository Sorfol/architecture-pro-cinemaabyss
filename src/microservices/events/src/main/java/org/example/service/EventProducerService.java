package org.example.service;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class EventProducerService {

    private static final Logger logger = LoggerFactory.getLogger(EventProducerService.class);

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public EventProducerService(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    public <T> void sendMessage(String topicName, T message) {
        try {
            ProducerRecord<String, T> record = new ProducerRecord<>(topicName, null, message);
            kafkaTemplate.send((ProducerRecord<String, Object>) record);
            logger.info("Отправлено сообщение в тему {}: {}", topicName, message.toString());
        } catch (Exception e) {
            logger.error("Ошибка отправки сообщения:", e);
        }
    }
}
