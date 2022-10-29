package com.example.addressbookapp.configuration;

import com.example.addressbookapp.util.EmailSender;
import com.example.addressbookapp.util.JWTToken;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {
    @Bean
    public JWTToken jwtToken() {
        return new JWTToken();
    }
    @Bean
    public EmailSender emailSender() {
        return new EmailSender();
    }
}
