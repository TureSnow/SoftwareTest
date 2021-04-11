package com.example.lab1.dao;

import com.example.lab1.entity.CustomerStockSell;
import com.example.lab1.entity.CustomerStockSellExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustomerStockSellMapper {
    int countByExample(CustomerStockSellExample example);

    int deleteByExample(CustomerStockSellExample example);

    int insert(CustomerStockSell record);

    int insertSelective(CustomerStockSell record);

    List<CustomerStockSell> selectByExample(CustomerStockSellExample example);

    int updateByExampleSelective(@Param("record") CustomerStockSell record, @Param("example") CustomerStockSellExample example);

    int updateByExample(@Param("record") CustomerStockSell record, @Param("example") CustomerStockSellExample example);
}