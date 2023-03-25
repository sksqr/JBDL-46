package io.bootify.l11_visitor_managment_system.model;

import javax.validation.constraints.*;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class VisitDTO {

    private Long id;

    @NotNull
    private VisitStatus status;

    private LocalDateTime inTime;

    private LocalDateTime outTime;

    @Size(max = 255)
    private String purpose;

    @Size(max = 255)
    @NotBlank
    private String imageUrl;

    @NotNull
    private Integer noOfPeople;

    @NotNull
    private Long visitor;

    @NotNull
    private Long flat;

}
