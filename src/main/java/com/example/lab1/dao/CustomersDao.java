package com.example.lab1.dao;

import com.example.lab1.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public interface CustomersDao {
    Customer findCustomerByIdNumber(String idNumber);
    Customer findCustomerByCode(String code);

}
