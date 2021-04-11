package com.example.lab1.service.Impl;

import com.example.lab1.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class CustomerServiceImplTest {
    @Autowired
    CustomerService customerService;
    @Test
    void getCardsByCustomerCode() {
        assertNotNull(customerService);
        //assertNotEquals(0,customerService.getCardsByCustomerCode("demo001202104079").size());
    }
}