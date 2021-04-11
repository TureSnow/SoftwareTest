package com.example.lab1.service;

import com.example.lab1.entity.*;
import com.example.lab1.model.MyStock;

import java.util.Date;
import java.util.List;


public interface ProductService {
    List<Fund> getAllFund();
    Fund getProductByFundCode(String fundCode);
    List<Term> getAllTerm();
    Term getTermByTermCode(String termCode);
    List<Stock> getAllStock();
    Stock getStockByStockCode(String stockCode);

    /**
     * 查询账户等级
     * 一级账户可以购买股票、基金和定期理财产品
     * 二级账户可以购买基金和定期理财产品
     * 三级账户只能购买定期理财产品
     * 一级账户：账户余额-账户贷款>50 万元
     * 二级账户：账户余额-账户贷款>=0 元
     * 三级账户：账户余额-账户贷款<=0 元
     * @param accountNum
     * @return
     */
    int getAccountLv(String accountNum);

    /**
     * buy product
     * 购买理财产品之前，如果账面存在罚金未缴清，需先缴清罚金才能购
     * 买理财产品。
     * @param customerCode :用户code
     * @param idNumber ：用户身份证
     * @param accountNum ： 用户银行卡号
     * @param password :银行卡密码
     * @param amount ： 买入金额
     * @return
     */
    int buyFund(String fundCode,String customerCode, String idNumber, String accountNum,String password, double amount);
    int sellFund(String fundCode,String customerCode,String idNumber, String accountNum,String password, double amount);

    int buyTerm(String termCode,String customerCode, String idNumber, String accountNum,String password, double amount);

    /**
     *购买股票之前
     * @param customerCode
     * @param idNumber
     * @param accountNum
     * @param password
     * @param amount :购买股数
     * @return 0：failure；1：ok
     */
    int buyStock(String stockCode,String customerCode,String idNumber,String accountNum,String password,int amount);

    /**
     * 卖出股票
     * @param customerCode
     * @param idNumber
     * @param accountNum
     * @param password
     * @param amount
     * @return
     */
    int sellStock(String stockCode,String customerCode,String idNumber,String accountNum,String password,int amount);

    /**
     * 查询股票价格变动,按最新时间排序
     * @param stockCode
     * @return
     */
    List<StockPriceTime> queryStockPrice(String stockCode);
    /**
     * 查询精准时间内的某一只股票的价格
     * @param stockCode
     * @param time
     * @return
     */
    double queryStockPriceInTime(String stockCode, Date time);
    /**
     * 查询用户购买的股票
     * @param customerCode
     * @return
     */
    List<MyStock> queryStockByCustomerCode(String customerCode);

    double queryStockProfitAndLoss(String customerCode);
}
