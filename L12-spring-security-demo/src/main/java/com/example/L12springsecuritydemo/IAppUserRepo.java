package com.example.L12springsecuritydemo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAppUserRepo extends JpaRepository<AppUser,Long> {

    List<AppUser> findByEmail(String email);
}
