package com.example.lab1.dao;

import com.example.lab1.entity.CustomerProduct;
import com.example.lab1.entity.CustomerProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustomerProductMapper {
    int countByExample(CustomerProductExample example);

    int deleteByExample(CustomerProductExample example);

    int insert(CustomerProduct record);

    int insertSelective(CustomerProduct record);

    List<CustomerProduct> selectByExample(CustomerProductExample example);

    int updateByExampleSelective(@Param("record") CustomerProduct record, @Param("example") CustomerProductExample example);

    int updateByExample(@Param("record") CustomerProduct record, @Param("example") CustomerProductExample example);
}