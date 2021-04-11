package com.example.lab1.entity;

import java.util.Date;

public class Loan {
    private int id;
    private String iouNum;
    private String customerCode;
    private String accountNum;
    private double yearlyRate;
    private int repaymentCount;
    private Date dueDate;
    private Date loadDate;
    private double loadCost;
    private double loadAmount;
    private String productCode;
    private String productName;
    private String institutionAccountNum;
    private double dueBalance;


    public Loan(int id, String iouNum, String customerCode, String accountNum, double yearlyRate, int repaymentCount, Date dueDate, Date loadDate, double loadCost, double loadAmount, String productCode,String institutionAccountNum) {
        this.id = id;
        this.iouNum = iouNum;
        this.customerCode = customerCode;
        this.accountNum = accountNum;
        this.yearlyRate = yearlyRate;
        this.repaymentCount = repaymentCount;
        this.dueDate = dueDate;
        this.loadDate = loadDate;
        this.loadCost = loadCost;
        this.loadAmount = loadAmount;
        this.productCode = productCode;
        this.productName=generateProductName(productCode);//临时写死
        this.institutionAccountNum=institutionAccountNum;
    }
    //手动生成产品名字
    private String generateProductName(String productCode){
        switch (productCode){
            case "40001":return "个体工商户小额贷款";
            case "85777":return "品名称";
            case "40002":return "居民住房抵押贷款";
        }
        return "个体工商户小额贷款";
    }

    public String getInstitutionAccountNum() {
        return institutionAccountNum;
    }

    public void setInstitutionAccountNum(String institutionAccountNum) {
        this.institutionAccountNum = institutionAccountNum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIouNum() {
        return iouNum;
    }

    public void setIouNum(String iouNum) {
        this.iouNum = iouNum;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    public double getYearlyRate() {
        return yearlyRate;
    }

    public void setYearlyRate(double yearlyRate) {
        this.yearlyRate = yearlyRate;
    }

    public int getRepaymentCount() {
        return repaymentCount;
    }

    public void setRepaymentCount(int repaymentCount) {
        this.repaymentCount = repaymentCount;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getLoadDate() {
        return loadDate;
    }

    public void setLoadDate(Date loadDate) {
        this.loadDate = loadDate;
    }

    public double getLoadCost() {
        return loadCost;
    }

    public void setLoadCost(double loadCost) {
        this.loadCost = loadCost;
    }

    public double getLoadAmount() {
        return loadAmount;
    }

    public void setLoadAmount(double loadAmount) {
        this.loadAmount = loadAmount;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getDueBalance() {
        return dueBalance;
    }

    public void setDueBalance(double dueBalance) {
        this.dueBalance = dueBalance;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "id=" + id +
                ", iouNum='" + iouNum + '\'' +
                ", customerCode='" + customerCode + '\'' +
                ", accountNum='" + accountNum + '\'' +
                ", yearlyRate=" + yearlyRate +
                ", repaymentCount=" + repaymentCount +
                ", dueDate=" + dueDate +
                ", loadDate=" + loadDate +
                ", loadCost=" + loadCost +
                ", loadAmount=" + loadAmount +
                ", productCode='" + productCode + '\'' +
                ", productName='" + productName + '\'' +
                ", institutionAccountNum='" + institutionAccountNum + '\'' +
                ", dueBalance=" + dueBalance +
                '}';
    }
}
