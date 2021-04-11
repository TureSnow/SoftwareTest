package com.example.lab1.model;

public class MyFund {
    String fundCode;
    String fundName;
    double total;
    double principal;
    double profit;
    public MyFund(String fundCode,String fundName,double total,double principal){
        this.fundCode=fundCode;
        this.fundName=fundName;
        this.total=total;
        this.principal=principal;
        this.profit=total-principal;
    }
}
