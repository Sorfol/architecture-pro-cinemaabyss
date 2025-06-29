package org.example.model;

import lombok.Data;

@Data
public class PaymentEvent {
    private Long id;
    private Double amount;
    private String currency;
}
