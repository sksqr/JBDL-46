package com.example.L12springsecuritydemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AppUserService appUserService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("shashi").password("$2a$10$aBtB0A4e0SO1GrddXwFP0enjSBDxbTKfFbPUg4WLiPih1G.n4QgbO")
//                .roles("admin","user")
//                .and().withUser("ravi").password("$2a$10$aBtB0A4e0SO1GrddXwFP0enjSBDxbTKfFbPUg4WLiPih1G.n4QgbO")
//                .roles("user");
        auth.userDetailsService(appUserService);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    public static void main(String[] args) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encoded= passwordEncoder.encode("1234");
        System.out.println(encoded);
    }
    //$2a$10$wlNetISdnTNuTfNlb1zrhO.HZVDZKz1QAbJIM0XQzoUAhtr20SR06
    //$2a$10$wkaxsqabfyb4VZFzi0/oauw0pIxh2B/.AwOL.ETPQZf3QFOgUUwZC

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests().antMatchers("/hello/*").hasRole("user")
//                        .antMatchers("/product/*").permitAll();

        http.authorizeHttpRequests().antMatchers("/hello/*").hasAuthority("user")
                .antMatchers("/product/*").hasAuthority("admin");
        http.formLogin();
        http.httpBasic();
    }
}
