package com.example.JmsMessageExample.Controller;

import com.example.JmsMessageExample.Model.Customer;
import com.example.JmsMessageExample.Model.MessageStorage;
import com.example.JmsMessageExample.Service.JmsProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    JmsProducer jmsProducer;

    @Autowired
    private MessageStorage customerStorage;

    @PostMapping(value="/api/customer")
    public Customer postCustomer(@RequestBody Customer customer){
        jmsProducer.send(customer);
        return customer;
    }

    @GetMapping(value="/api/customers")
    public List<Customer> getAll(){
        List<Customer> customers = customerStorage.getAll();
        return customers;
    }

    @DeleteMapping(value="/api/customers/clear")
    public String clearCustomerStorage() {
        customerStorage.clear();
        return "Clear All CustomerStorage!";
    }
}
