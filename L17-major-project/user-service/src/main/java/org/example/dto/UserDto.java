package org.example.dto;


import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    private String name;
    private String email;
    private String phone;
    private String kycId;
    private String address;

}
