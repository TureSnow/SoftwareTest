package com.example.lab1.dao;

import com.example.lab1.entity.Loan;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface LoansDao {
//      找出客户的所有贷款
    List<Loan> findLoansByCustomerCode(String customerCode);
//    通过借据号找出一笔贷款
    Loan findLoanByIouNumber(String iouNum);
    //通过银行卡找到该卡借过的所有贷款
    List<Loan> findLoansByAccountNum(String accountNum);


}
