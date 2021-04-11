package com.example.lab1.entity;

import java.io.Serializable;
import java.util.Date;

public class CustomerProduct implements Serializable {
    private String customerCode;

    private Integer timeAmount;

    private Date createdTime;

    private String productCode;

    private Date expectedTime;

    private Double expectedProfit;

    private Integer principal;

    private static final long serialVersionUID = 1L;

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public Integer getTimeAmount() {
        return timeAmount;
    }

    public void setTimeAmount(Integer timeAmount) {
        this.timeAmount = timeAmount;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public Date getExpectedTime() {
        return expectedTime;
    }

    public void setExpectedTime(Date expectedTime) {
        this.expectedTime = expectedTime;
    }

    public Double getExpectedProfit() {
        return expectedProfit;
    }

    public void setExpectedProfit(Double expectedProfit) {
        this.expectedProfit = expectedProfit;
    }

    public Integer getPrincipal() {
        return principal;
    }

    public void setPrincipal(Integer principal) {
        this.principal = principal;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        CustomerProduct other = (CustomerProduct) that;
        return (this.getCustomerCode() == null ? other.getCustomerCode() == null : this.getCustomerCode().equals(other.getCustomerCode()))
            && (this.getTimeAmount() == null ? other.getTimeAmount() == null : this.getTimeAmount().equals(other.getTimeAmount()))
            && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
            && (this.getProductCode() == null ? other.getProductCode() == null : this.getProductCode().equals(other.getProductCode()))
            && (this.getExpectedTime() == null ? other.getExpectedTime() == null : this.getExpectedTime().equals(other.getExpectedTime()))
            && (this.getExpectedProfit() == null ? other.getExpectedProfit() == null : this.getExpectedProfit().equals(other.getExpectedProfit()))
            && (this.getPrincipal() == null ? other.getPrincipal() == null : this.getPrincipal().equals(other.getPrincipal()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCustomerCode() == null) ? 0 : getCustomerCode().hashCode());
        result = prime * result + ((getTimeAmount() == null) ? 0 : getTimeAmount().hashCode());
        result = prime * result + ((getCreatedTime() == null) ? 0 : getCreatedTime().hashCode());
        result = prime * result + ((getProductCode() == null) ? 0 : getProductCode().hashCode());
        result = prime * result + ((getExpectedTime() == null) ? 0 : getExpectedTime().hashCode());
        result = prime * result + ((getExpectedProfit() == null) ? 0 : getExpectedProfit().hashCode());
        result = prime * result + ((getPrincipal() == null) ? 0 : getPrincipal().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", customerCode=").append(customerCode);
        sb.append(", timeAmount=").append(timeAmount);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", productCode=").append(productCode);
        sb.append(", expectedTime=").append(expectedTime);
        sb.append(", expectedProfit=").append(expectedProfit);
        sb.append(", principal=").append(principal);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}