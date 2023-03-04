package com.example.L09SpringJPAdemo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class AddressService {

    @Autowired
    private EntityManager entityManager;
}

