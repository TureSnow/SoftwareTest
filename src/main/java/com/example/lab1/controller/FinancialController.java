package com.example.lab1.controller;
import com.example.lab1.api.CommonResult;
import com.example.lab1.entity.Fund;
import com.example.lab1.entity.Stock;
import com.example.lab1.entity.Term;
import com.example.lab1.service.ProductService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class FinancialController {
    @Autowired
    private ProductService productService;
    Logger logger= Logger.getLogger(LoanController.class.getName());
    @GetMapping("/financing/account/level")
    @ApiOperation("查询用户等级")
    public CommonResult<Integer> queryAccountLv(@RequestParam String accountNum){
        int lv=productService.getAccountLv(accountNum);
        if (lv<0)
            return CommonResult.failed("accountNum error");
        else
            return CommonResult.success(lv);
    }
    @GetMapping("/financing/product/stock")
    @ApiOperation("查询所有股票")
    public CommonResult<List<Stock>> queryAllStock(){
        List<Stock> allStock = productService.getAllStock();
        return CommonResult.success(allStock);
    }
    @GetMapping("/financing/product/fund")
    @ApiOperation("查询所有基金")
    public CommonResult<List<Fund>> queryAllFund(){
        List<Fund> allFund = productService.getAllFund();
        return CommonResult.success(allFund);
    }
    @GetMapping("/financing/product/term")
    @ApiOperation("查询所有定期理财产品")
    public CommonResult<List<Term>> queryAllTerm(){
        List<Term> allTerm = productService.getAllTerm();
        return CommonResult.success(allTerm);
    }

}
