package com.example.lab1.service.Impl;

import com.example.lab1.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceImplTest {
    @Autowired
    ProductService productService;
    @Test
    void getAccountLv() {
        assertNotNull(productService);
    }
}