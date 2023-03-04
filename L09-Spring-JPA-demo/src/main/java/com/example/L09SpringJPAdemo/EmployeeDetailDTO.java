package com.example.L09SpringJPAdemo;

import com.example.L09SpringJPAdemo.entity.Address;
import com.example.L09SpringJPAdemo.entity.Employee;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Setter
@Getter
public class EmployeeDetailDTO {


    private String name;
    private String email;

    private String line1;

    private String line2;

    private String city;
}
