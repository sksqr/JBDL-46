package org.example.dto;


import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WalletDto {

    private Long userId;

    private Double balance;
}
