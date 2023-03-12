package io.bootify.l11_visitor_managment_system.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;


@Getter
@Setter
public class AddressDTO {

    private Long id;

    @NotNull
    @Size(max = 255)
    private String line1;

    @Size(max = 255)
    private String line2;

    @NotNull
    @Size(max = 255)
    private String city;

    @NotNull
    @Size(max = 255)
    private String country;

    @Size(max = 255)
    private String pincode;

    @NotNull
    @Size(max = 255)
    private String state;

}
