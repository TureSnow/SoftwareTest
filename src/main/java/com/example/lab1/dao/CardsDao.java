package com.example.lab1.dao;

import com.example.lab1.entity.Card;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface CardsDao {
    //通过客户号找到所有的银行卡
    List<Card> findCardsByCustomerCode(String customerCode);
    //通过银行卡账号找到银行卡
    Card findCardByAccountNum(String accountNum);
    //更新银行卡余额
    void updateCardBalance(String accountNum,double balance);

}
