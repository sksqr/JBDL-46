package com.example.L12springsecuritydemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AppUserService implements UserDetailsService {

    @Autowired
    private IAppUserRepo appUserRepo;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<AppUser> userList = appUserRepo.findByEmail(username);
        if(userList == null || userList.size() < 1){
            throw new UsernameNotFoundException("User does not exist");
        }
        return userList.get(0);
    }
}
