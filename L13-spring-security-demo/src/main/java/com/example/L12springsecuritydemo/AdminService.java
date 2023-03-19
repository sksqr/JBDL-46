package com.example.L12springsecuritydemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private IAppUserRepo appUserRepo;

    public AppUser createUser(AppUser appUser){
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        appUserRepo.save(appUser);
        return appUser;
    }


    public AppUser getUser(Long id){
        return appUserRepo.findById(id).get();
    }


    public void changePassword(String newPass){
        UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        AppUser appUser =  appUserRepo.findByEmail(user.getUsername());
        appUser.setPassword(passwordEncoder.encode(newPass));
        appUserRepo.save(appUser);
    }
}
