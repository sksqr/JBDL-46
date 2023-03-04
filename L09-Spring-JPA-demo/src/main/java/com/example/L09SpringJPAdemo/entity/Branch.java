package com.example.L09SpringJPAdemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Setter
@Getter
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    private String renewalNumber;

    @OneToMany(mappedBy = "branch", fetch = FetchType.EAGER)
    @JsonIgnoreProperties("branch")
    private Set<Employee> employees;

}
