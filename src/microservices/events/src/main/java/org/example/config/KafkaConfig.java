package org.example.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {

    @Bean
    public NewTopic movieTopic() {
        return TopicBuilder.name("movie-events").partitions(3).replicas(1).build();
    }

    @Bean
    public NewTopic userTopic() {
        return TopicBuilder.name("user-events").partitions(3).replicas(1).build();
    }

    @Bean
    public NewTopic paymentTopic() {
        return TopicBuilder.name("payment-events").partitions(3).replicas(1).build();
    }
}
