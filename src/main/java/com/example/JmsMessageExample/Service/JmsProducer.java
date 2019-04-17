package com.example.JmsMessageExample.Service;

import com.example.JmsMessageExample.Model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class JmsProducer {
    @Autowired
    JmsTemplate jmsTemplate;

    @Value("${gkz.activemq.queue}")
    String queue;

    public void send(Customer customer){
        jmsTemplate.convertAndSend(queue, customer);
    }
}
