package com.example.L18paymentgatewaydemo.dto;


import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentPageRequest {

    private Long merchantId;

    private Double amount;

}
