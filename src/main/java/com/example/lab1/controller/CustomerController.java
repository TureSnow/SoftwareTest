package com.example.lab1.controller;

import com.example.lab1.api.CommonResult;
import com.example.lab1.model.MyCard;
import com.example.lab1.service.CustomerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @GetMapping("/customer/cards")
    @ApiOperation("根据customer code获得用户全部银行卡")
    public CommonResult<List<MyCard>> getCardsByCustomerCode(@RequestParam String code){
        List<MyCard> cards = customerService.getCardsByCustomerCode(code);
        return CommonResult.success(cards);
    }
}
