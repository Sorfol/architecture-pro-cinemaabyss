package org.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentEvent {
    @JsonProperty("payment_id")
    private Long paymentId;

    @JsonProperty("user_id")
    private Long userId;

    @JsonProperty("amount")
    private Double amount;

    @JsonProperty("status")
    private String status;

    @JsonProperty("timestamp")
    private String timestamp;

    @JsonProperty("method_type")
    private String methodType;
}
