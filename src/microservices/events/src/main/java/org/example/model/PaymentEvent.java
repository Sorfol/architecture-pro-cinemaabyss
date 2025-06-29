package org.example.model;

import lombok.Data;

import java.time.Instant;

@Data
public class PaymentEvent {
    private Long paymentId;
    private Long userId;
    private Double amount;
    private String status;  // "completed", "failed", etc.
    private Instant timestamp;
    private String methodType;  // "credit_card", "paypal", etc.
}
