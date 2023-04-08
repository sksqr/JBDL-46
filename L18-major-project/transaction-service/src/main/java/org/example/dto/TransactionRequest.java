package org.example.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class TransactionRequest {
    private Long fromUserId;

    private Long toUserId;

    private Double amount;

    private String remark;

}
