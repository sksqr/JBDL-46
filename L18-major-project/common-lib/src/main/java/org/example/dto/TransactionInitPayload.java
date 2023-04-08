package org.example.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionInitPayload {

    private Long id;

    private Long fromUserId;

    private Long toUserId;

    private Double amount;

    private String requestId;
}
