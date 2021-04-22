package com.example.lab1.service.Impl;

import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ProductServiceImplTest {
    @Autowired
    private ProductServiceImpl productService;
    @Test
    void checkCustomerAndCard() {
        String customerCodeFalse="falseCode";
        String customerCodeCorrect="demo001202104079";
        String customerIdFalse="falseId";
        String customerIdCorrect="465432134566789097";
        String accountNumberFalse="falseAccountNumber";
        String accountNumberCorrect="6161779470821245928";
        String passwordFalse="falsePassword";
        String passwordCorrect="dsaddadaewradada";
        //code error
        assertEquals(false, productService.checkCustomerAndCard(customerCodeFalse,customerIdCorrect,
                accountNumberCorrect,passwordCorrect));
        //id error
        assertEquals(false, productService.checkCustomerAndCard(customerCodeCorrect,customerIdFalse,
                accountNumberCorrect,passwordCorrect));
        //account error
        assertEquals(false, productService.checkCustomerAndCard(customerCodeCorrect,customerIdCorrect,
                accountNumberFalse,passwordCorrect));
        //password error
        assertEquals(false, productService.checkCustomerAndCard(customerCodeCorrect,customerIdCorrect,
                accountNumberCorrect,passwordFalse));
        //all right
        assertEquals(true, productService.checkCustomerAndCard(customerCodeCorrect,customerIdCorrect,
                accountNumberCorrect,passwordCorrect));

    }

    @Test
    void getAccountLv() {
        String accountNumberError="test";
        String accountNumber1="6161779470821245928";
        String accountNumber2="716177967387571";
        String accountNumber3="6161779470821216793";
        assertEquals(-1,productService.getAccountLv(accountNumberError));
        assertEquals(1,productService.getAccountLv(accountNumber1));
        assertEquals(2,productService.getAccountLv(accountNumber2));
        assertEquals(3,productService.getAccountLv(accountNumber3));
    }

    /**
     * 这个地方从fund持有从无到有要保证测两遍
     * 第一遍数据库无记录
     * 第二遍数据库有记录
     * // TODO: 2021/4/22
     * 归还罚金失败稍后再做
     */
    @Test
    void buyFund() {
        String fundCode="FD01";
        String customerCode="demo001202104079";
        String idNumber="465432134566789097";
        String accountNum="6161779470821245928";
        String password="dsaddadaewradada";
        double amount=100;
        //buy ok
        assertEquals(1,productService.buyFund(fundCode,customerCode,idNumber,accountNum,password,amount));
        //buy ok
        assertEquals(1,productService.buyFund(fundCode,customerCode,idNumber,accountNum,password,amount));
        //check error
        assertEquals(-1,productService.buyFund(fundCode,customerCode,idNumber,accountNum,"test",amount));
        //lv error
        String accountNumber1="6161779470821216793";
        String password1="wrrewrsdfsfsfgdfgd";
        assertEquals(0,productService.buyFund(fundCode,customerCode,idNumber,accountNumber1,password1,amount));
        //buy fail
        assertEquals(-1,productService.buyFund(fundCode,customerCode,idNumber,accountNum,password,100000000000.0));
    }

    /**
     * sell fund need to be test after buy fund
     */
    @Test
    void sellFund() {
        String fundCode="FD01";
        String customerCode="demo001202104079";
        String idNumber="465432134566789097";
        String accountNum="6161779470821245928";
        String password="dsaddadaewradada";
        double amount=1;
        //check error
        assertEquals(-1,productService.sellFund(fundCode,customerCode,idNumber,accountNum,"test",amount));
        //sell ok
        assertEquals(1,productService.sellFund(fundCode,customerCode,idNumber,accountNum,password,amount));
        // not buy,no that fund
        assertEquals(-1,productService.sellFund("fundCode",customerCode,idNumber,accountNum,password,amount));
        //sell too much
        assertEquals(-1,productService.sellFund(fundCode,customerCode,idNumber,accountNum,password,1000000000));
    }

    @Test
    void selectByCode() {
        String code="FD01";
        String code1="test";
        assertNotNull(productService.selectByCode(code));
        assertNull(productService.selectByCode(code1));
    }

    @Test
    void queryByCustomerIdAndFundCode() {
        int customerId1=14;
        int customerId2=13;
        String fundCode="FD01";
        assertNotEquals(0,productService.queryByCustomerIdAndFundCode(customerId1,fundCode).getPrincipal());
        assertEquals(0,productService.queryByCustomerIdAndFundCode(customerId2,fundCode).getPrincipal());
    }

    @Test
    void queryFundByCustomerCode() {
        String customerCode = "test";
        String customerCode1 = "demo001202104079";
        assertNull(productService.queryFundByCustomerCode(customerCode));
        assertNotNull(productService.queryFundByCustomerCode(customerCode1));
    }

    @Test
    void queryFundRateTimeByFundCode() {
        assertNotNull(productService.queryFundRateTimeByFundCode("FD01"));
    }

    @Test
    void getTermByTermCode() {
        assertNotNull(productService.getTermByTermCode("TM01"));
    }

    @Test
    void buyTerm() {
        String termCode="TM01";
        String customerCode="demo001202104079";
        String idNumber="465432134566789097";
        String accountNum="6161779470821245928";
        String password="dsaddadaewradada";
        double amount = 1000;
        //check error
        assertEquals(-1,productService.buyTerm(termCode,customerCode,idNumber,accountNum,"test",amount));
        //amount>balance
        assertEquals(-1,productService.buyTerm(termCode,customerCode,idNumber,accountNum,password,10000000000.0));
        //buy ok
        assertEquals(1,productService.buyTerm(termCode,customerCode,idNumber,accountNum,password,amount));
    }

    @Test
    void queryTermByCustomerIdAndTermCode() {
        assertNull(productService.queryTermByCustomerIdAndTermCode(13,"null"));
        assertNull(productService.queryTermByCustomerIdAndTermCode(1,"TM01").getBuyTime());
        assertNotNull(productService.queryTermByCustomerIdAndTermCode(14,"TM01"));
    }

    @Test
    void queryTermByCustomerCode() {
        String customerCode="demo001202104079";
        assertNull(productService.queryTermByCustomerCode("null"));
        assertNotNull(productService.queryTermByCustomerCode(customerCode));
    }

    @Test
    void getStockByStockCode() {
        assertNotNull(productService.getStockByStockCode("GP01"));
    }

    @Test
    void buyStock() {
        String stockCode="GP01";
        String customerCode="demo001202104079";
        String idNumber="465432134566789097";
        String accountNum="6161779470821245928";
        String password="dsaddadaewradada";
        int amount=100;
        //check error
        assertEquals(-1,productService.buyStock(stockCode,customerCode,idNumber,accountNum,"test",amount));
        //lv error
        String accountNumber1="6161779470821216793";
        String password1="wrrewrsdfsfsfgdfgd";
        assertEquals(-1,productService.buyStock(stockCode,customerCode,idNumber,accountNumber1,password1,amount));
        //buy failed
        assertEquals(-1,productService.buyStock(stockCode,customerCode,idNumber,accountNum,password,1000000000));
        //buy successfully
        assertEquals(1,productService.buyStock(stockCode,customerCode,idNumber,accountNum,password,amount));
    }

    @Test
    void getLeastStockPrice() {
        assertEquals(90.9,productService.getLeastStockPrice("GP01"));
    }

    @Test
    void getStockNowAccount() {
        assertEquals(0,productService.getStockNowAccount(14,"GP02"));
        assertNotEquals(0,productService.getStockNowAccount(14,"GP01"));
    }

    @Test
    void sellStock() {
        String stockCode="GP01";
        String customerCode="demo001202104079";
        String idNumber="465432134566789097";
        String accountNum="6161779470821245928";
        String password="dsaddadaewradada";
        int amount=1;
        //check error
        assertEquals(-1,productService.sellStock(stockCode,customerCode,idNumber,accountNum,"test",1));
        //sell error
        assertEquals(-1,productService.sellStock(stockCode,customerCode,idNumber,accountNum,password,10000000));
        //sell success
        assertEquals(1,productService.sellStock(stockCode,customerCode,idNumber,accountNum,password,amount));
    }

    @Test
    void queryStockPriceByStockCode() {
        assertNotNull(productService.queryStockPriceByStockCode("GP01"));
    }

    @Test
    void queryStockPriceInTime() {
        assertEquals(-1,productService.queryStockPriceInTime("test",new Date()));
        assertEquals(90.9,productService.queryStockPriceInTime("GP01",new Date()));
    }

    @Test
    void queryStockByCustomerCode() {
        assertNull(productService.queryStockByCustomerCode("test"));
        assertNotNull(productService.queryStockByCustomerCode("demo001202104079"));
    }

    @Test
    void merge() {
        List<Integer> list1=new ArrayList<>();
        list1.add(1);
        list1.add(2);
        List<Integer> list2=new ArrayList<>();
        list2.add(3);
        list2.add(4);
        assertEquals(4,ProductServiceImpl.merge(list1,list2).size());
    }

    @Test
    void queryStockBuyByCustomerCode() {
        assertNull(productService.queryStockBuyByCustomerCode("test"));
    }

    @Test
    void queryStockSellByCustomerCode() {
        assertNull(productService.queryStockSellByCustomerCode("test"));
    }
}