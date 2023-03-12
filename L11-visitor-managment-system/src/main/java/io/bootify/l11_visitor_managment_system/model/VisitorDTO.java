package io.bootify.l11_visitor_managment_system.model;

import javax.validation.constraints.*;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class VisitorDTO {

    private Long id;

    @NotNull
    @Size(max = 255)
    private String name;

    @Size(max = 255)
    private String email;

    @NotNull
    @Size(max = 255)
    private String phone;

    @NotNull
    @Size(max = 255)
    private String idNumber;

    private Long address;

}
