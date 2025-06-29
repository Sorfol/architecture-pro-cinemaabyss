package org.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.Instant;

@Data
public class PaymentEvent {
    @JsonProperty("payment_id")
    private Long paymentId;

    @JsonProperty("user_id")
    private Long userId;

    @JsonProperty
    private Double amount;

    @JsonProperty
    private String status;

    @JsonProperty
    private Instant timestamp;

    @JsonProperty("method_type")
    private String methodType;
}
