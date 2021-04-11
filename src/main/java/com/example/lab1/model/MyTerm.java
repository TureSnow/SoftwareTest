package com.example.lab1.model;

import java.util.Date;

public class MyTerm {
    String termCode;
    String termName;
    double principal;
    double expected_profit;
    int months;
    Date buyTime;
    public MyTerm(String termCode,String termName,double principal,double expected_profit,int months,Date buyTime){
        this.buyTime=buyTime;
        this.expected_profit=expected_profit;
        this.termCode=termCode;
        this.termName=termName;
        this.principal=principal;
        this.months=months;
    }
}
