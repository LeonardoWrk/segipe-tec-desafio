package com.sefaz.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sefaz.demo.domain.user.User;

@Service
public class NotificationService {


    public void sendNotification(User user, String message){
        String email = user.getEmail();
    }
}
