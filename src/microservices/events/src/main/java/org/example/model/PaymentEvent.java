package org.example.model;

import lombok.Data;

@Data
public class PaymentEvent {
    private String paymentId;
    private String userId;
    private Double amount;
    private String status; // "success", "failed", "pending"
}
