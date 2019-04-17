package com.example.JmsMessageExample.Configuration;

import com.example.JmsMessageExample.Model.MessageStorage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    public MessageStorage customerStorage() {
        return new MessageStorage();
    }
}
