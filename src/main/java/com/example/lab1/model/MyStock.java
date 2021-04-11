package com.example.lab1.model;

public class MyStock {
    String stockCode;
    String stockName;
    int amount;
    double profit;
    public MyStock(String stockCode,String stockName,int amount,double profit){
        this.stockCode=stockCode;
        this.stockName=stockName;
        this.amount=amount;
        this.profit=profit;
    }
}
