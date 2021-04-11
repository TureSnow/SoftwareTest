package com.example.lab1.dao;

import com.example.lab1.entity.CustomerStock;
import com.example.lab1.entity.CustomerStockExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustomerStockMapper {
    int countByExample(CustomerStockExample example);

    int deleteByExample(CustomerStockExample example);

    int insert(CustomerStock record);

    int insertSelective(CustomerStock record);

    List<CustomerStock> selectByExample(CustomerStockExample example);

    int updateByExampleSelective(@Param("record") CustomerStock record, @Param("example") CustomerStockExample example);

    int updateByExample(@Param("record") CustomerStock record, @Param("example") CustomerStockExample example);
}