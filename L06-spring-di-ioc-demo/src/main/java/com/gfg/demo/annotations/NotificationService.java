package com.gfg.demo.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("notificationService")
//@Scope("prototype")
public class NotificationService {

//    public NotificationService(SMSGateway smsGateway) {
//        this.smsGateway = smsGateway;
//        System.out.println("Creating NotificationService object ");
//    }

//    @Autowired
    private SMSGateway smsGateway;

    @Autowired
    public void setSmsGateway(SMSGateway smsGateway) {
        //
        this.smsGateway = smsGateway;
        //
    }

    public void sendNotification(String data){
        smsGateway.sendSMS(data);
    }
}
