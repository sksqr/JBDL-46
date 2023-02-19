package com.gfg.demo.annotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ProjectConfig {

    @Bean
    @Scope("prototype")
    public SMSGateway smsGatewayBean(){
        return new SMSGateway();
    }


//
//    @Bean("notificationService")
//    public NotificationService notificationService(){
//        return new NotificationService(smsGatewayBean());
//    }
}

