package com.example.lab1.service.Impl;

import com.example.lab1.dao.CardsDao;
import com.example.lab1.entity.Card;
import com.example.lab1.model.MyCard;
import com.example.lab1.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService {
    private CardsDao cardsDao;

    public CustomerServiceImpl(CardsDao cardsDao) {
        this.cardsDao = cardsDao;
    }

    @Override
    public List<MyCard> getCardsByCustomerCode(String code) {
        List<Card> cards = cardsDao.findCardsByCustomerCode(code);
        if (cards.size()==0)
            return null;
        List<MyCard>res=new LinkedList<>();
        for(Card card:cards){
            int id=card.getId();
            String accountNum=card.getAccountNum();
            String customerCode=card.getCustomerCode();
            double balance=card.getBalance();
            res.add(new MyCard(id,accountNum,customerCode,balance));
        }
        return res;
    }
}
