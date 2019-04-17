package com.example.JmsMessageExample.Service;

import com.example.JmsMessageExample.Model.Customer;
import com.example.JmsMessageExample.Model.MessageStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class JmsConsumer {
    @Autowired
    private MessageStorage customerStorage;

    @JmsListener(destination = "${gkz.activemq.queue}", containerFactory="jsaFactory")
    public void receive(Customer customer){
        System.out.println("Recieved Message: " + customer);
        customerStorage.add(customer);
    }
}
