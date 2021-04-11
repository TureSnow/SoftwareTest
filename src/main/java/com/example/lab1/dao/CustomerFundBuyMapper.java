package com.example.lab1.dao;

import com.example.lab1.entity.CustomerFundBuy;
import com.example.lab1.entity.CustomerFundBuyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustomerFundBuyMapper {
    int countByExample(CustomerFundBuyExample example);

    int deleteByExample(CustomerFundBuyExample example);

    int insert(CustomerFundBuy record);

    int insertSelective(CustomerFundBuy record);

    int updateAfterSell(CustomerFundBuy record);

    List<CustomerFundBuy> selectByExample(CustomerFundBuyExample example);

    int updateByExampleSelective(@Param("record") CustomerFundBuy record, @Param("example") CustomerFundBuyExample example);

    int updateByExample(@Param("record") CustomerFundBuy record, @Param("example") CustomerFundBuyExample example);
}