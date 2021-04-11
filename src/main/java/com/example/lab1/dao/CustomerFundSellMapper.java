package com.example.lab1.dao;

import com.example.lab1.entity.CustomerFundSell;
import com.example.lab1.entity.CustomerFundSellExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustomerFundSellMapper {
    int countByExample(CustomerFundSellExample example);

    int deleteByExample(CustomerFundSellExample example);

    int insert(CustomerFundSell record);

    int insertSelective(CustomerFundSell record);

    List<CustomerFundSell> selectByExample(CustomerFundSellExample example);

    int updateByExampleSelective(@Param("record") CustomerFundSell record, @Param("example") CustomerFundSellExample example);

    int updateByExample(@Param("record") CustomerFundSell record, @Param("example") CustomerFundSellExample example);
}