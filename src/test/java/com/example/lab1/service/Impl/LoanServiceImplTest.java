package com.example.lab1.service.Impl;

import com.example.lab1.service.LoanService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class LoanServiceImplTest {
    @Autowired
    LoanService loanService;
    @Test
    void autoRepay() {
        String s = loanService.autoRepay();
        assertEquals(s,"success");
    }


}