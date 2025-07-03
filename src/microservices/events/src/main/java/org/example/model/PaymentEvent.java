package org.example.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PaymentEvent {
    private final String paymentId;
    private final String amount;

    @JsonCreator
    public PaymentEvent(@JsonProperty("paymentId") String paymentId,
                      @JsonProperty("amount") String amount) {
        this.paymentId = paymentId;
        this.amount = amount;
    }
}
