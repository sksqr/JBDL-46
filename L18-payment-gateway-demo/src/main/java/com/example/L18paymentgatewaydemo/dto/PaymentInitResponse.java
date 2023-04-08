package com.example.L18paymentgatewaydemo.dto;


import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentInitResponse {
    private String url;
    private String txnId;
}
