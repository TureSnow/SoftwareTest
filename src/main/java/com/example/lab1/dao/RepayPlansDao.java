package com.example.lab1.dao;

import com.example.lab1.entity.RepayPlan;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface RepayPlansDao {
    RepayPlan findRepayPlanById(int id);
    void updateRepayPlan(RepayPlan repayPlan);
    List<RepayPlan> findRepayPlansByIouNum(String iouNum);
    List<RepayPlan> findUnPayPlans();
}
