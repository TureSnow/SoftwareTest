package com.example.lab1.service.Impl;
import com.example.lab1.dao.*;
import com.example.lab1.entity.*;
import com.example.lab1.model.MyStock;
import com.example.lab1.service.ProductService;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    private StockMapper stockMapper;
    private StockPriceTimeMapper stockPriceTimeMapper;
    private CustomerStockBuyMapper customerStockBuyMapper;
    private CustomerStockSellMapper customerStockSellMapper;
    private FundMapper fundMapper;
    private CustomerFundBuyMapper customerFundBuyMapper;
    private CustomerFundSellMapper customerFundSellMapper;
    private TermMapper termMapper;
    private CustomerTermMapper customerTermMapper;
    private CardsDao cardsDao;
    private LoansDao loansDao;
    private CustomersDao customersDao;
    private LoanServiceImpl loanServiceImpl;
    public ProductServiceImpl(StockMapper stockMapper, CardsDao cardsDao, LoansDao loansDao) {
        this.stockMapper = stockMapper;
        this.cardsDao = cardsDao;
        this.loansDao = loansDao;
    }

    @Override
    public List<Fund> getAllFund() {
        return fundMapper.getAllFund();
    }

    @Override
    public Fund getProductByFundCode(String fundCode) {
        return fundMapper.selectByCode(fundCode);
    }

    @Override
    public List<Term> getAllTerm() {
        return termMapper.getAllTerm();
    }

    @Override
    public Term getTermByTermCode(String termCode) {
        return termMapper.getTermByTermCode(termCode);
    }

    @Override
    public List<Stock> getAllStock() {
        StockExample stockExample=new StockExample();
        stockExample.or();
        return stockMapper.selectByExample(stockExample);
    }

    @Override
    public Stock getStockByStockCode(String stockCode) {
        StockExample stockExample = new StockExample();
        stockExample.or().andCodeEqualTo(stockCode);
        List<Stock> stocks = stockMapper.selectByExample(stockExample);
        return stocks.size()==0?null:stocks.get(0);
    }

    @Override
    public int getAccountLv(String accountNum) {
        Card card = cardsDao.findCardByAccountNum(accountNum);
        if (card==null)
            return -1;
        double balance=card.getBalance();
        List<Loan> loansList = loansDao.findLoansByAccountNum(accountNum);
        double loan=0;
        if (loansList.size()!=0){
            for(int i=0;i<loansList.size();i++){
                loan += loanServiceImpl.getUnPayLoanAmount(loansList.get(i).getIouNum());
            }
        }
        double count=balance-loan;
        if (count>500000)
            return 1;
        else if (count>=0)
            return 2;
        else
        return 3;
    }

    @Override
    public int buyFund(String fundCode,String customerCode, String idNumber,
                       String accountNum, String password, double amount) {
        if (!checkCustomerAndCard(customerCode,idNumber,accountNum,password))
            return -1;
        int lv=getAccountLv(accountNum);
        if(lv==-1)
            return 0;
        if(lv>2)
            return 0;
        //先归还罚金
        if(!loanServiceImpl.payFineOfCard(accountNum))
            return -1;
        Card card = cardsDao.findCardByAccountNum(accountNum);
        if(card.getBalance()>amount){
            //更新卡余额
            cardsDao.updateCardBalance(accountNum,card.getBalance()-amount);
            //添加基金购买记录
            //考虑：如果之前已经买过？
            Customer customer = customersDao.findCustomerByCode(customerCode);
            CustomerFundBuyExample example=new CustomerFundBuyExample();
            example.or().andCustomerIdEqualTo(customer.getId()).andFundCodeEqualTo(fundCode);
            List<CustomerFundBuy> buys = customerFundBuyMapper.selectByExample(example);
            if (buys.size()>0){
                //之前购买过,直接在原基础上更新本金和total
                CustomerFundBuy buy = buys.get(0);
                double pre=buy.getTotal();
                buy.setPrincipal(pre+amount);
                buy.setTotal(pre+amount);
                buy.setTimeBuy(new Date());
                customerFundBuyMapper.updateAfterSell(buy);
            }else {
                //新增购买记录
                CustomerFundBuy customerFundBuy= new CustomerFundBuy();
                customerFundBuy.setCustomerId(customer.getId());
                customerFundBuy.setFundCode(fundCode);
                customerFundBuy.setPrincipal(amount);
                customerFundBuy.setTotal(amount);
                customerFundBuy.setTimeBuy(new Date());
                customerFundBuyMapper.insert(customerFundBuy);
            }
            return 1;
        }
        return -1;
    }

    @Override
    public int sellFund(String fundCode, String customerCode, String idNumber,
                        String accountNum, String password, double amount) {
        if (!checkCustomerAndCard(customerCode,idNumber,accountNum,password))
            return -1;
        Card card = cardsDao.findCardByAccountNum(accountNum);
        Customer customer = customersDao.findCustomerByCode(customerCode);
        CustomerFundBuyExample customerFundBuyExample = new CustomerFundBuyExample();
        customerFundBuyExample.or().andCustomerIdEqualTo(customer.getId()).andFundCodeEqualTo(fundCode);
        List<CustomerFundBuy> Buys = customerFundBuyMapper.selectByExample(customerFundBuyExample);
        CustomerFundBuy buy;
        if (Buys.size()==0)
            return -1;
        else
            buy=Buys.get(0);
        if(buy.getTotal()>amount){
            //更新持仓
            buy.setTimeBuy(new Date());
            double pre=buy.getTotal();
            buy.setTotal(pre-amount);
            buy.setPrincipal(pre-amount);
            customerFundBuyMapper.updateAfterSell(buy);
            //加入card balance
            cardsDao.updateCardBalance(accountNum,card.getBalance()+amount);
            //新增fund sell记录
            CustomerFundSell sell= new CustomerFundSell();
            sell.setCustomerId(customer.getId());
            sell.setFundCode(fundCode);
            sell.setSellTime(new Date());
            sell.setSellAmount(amount);
            customerFundSellMapper.insert(sell);
            return 1;
        }
        return -1;
    }

    @Override
    public int buyTerm(String termCode,String customerCode, String idNumber, String accountNum, String password, double amount) {
        if (!checkCustomerAndCard(customerCode,idNumber,accountNum,password))
            return -1;
        //先归还罚金
        if(!loanServiceImpl.payFineOfCard(accountNum))
            return -1;
        Card card = cardsDao.findCardByAccountNum(accountNum);
        Term term = termMapper.getTermByTermCode(termCode);
        Customer customer = customersDao.findCustomerByCode(customerCode);
        if(card.getBalance()<amount)
            return -1;
        //更新卡余额
        cardsDao.updateCardBalance(accountNum,card.getBalance()-amount);
        //添加定期购买记录
        CustomerTerm customerTerm = new CustomerTerm();
        customerTerm.setCustomerId(customer.getId());
        customerTerm.setPrinciple(amount);
        customerTerm.setTime(new Date());
        customerTerm.setTermCode(termCode);
        return customerTermMapper.insert(customerTerm);
    }

    @Override
    public int buyStock(String stockCode,String customerCode, String idNumber, String accountNum, String password, int amount) {
        if (!checkCustomerAndCard(customerCode,idNumber,accountNum,password))
            return -1;
        int lv=getAccountLv(accountNum);
        if(lv==-1)
            return -1;
        if(lv>1)
            return -1;
        //先归还罚金
        if(!loanServiceImpl.payFineOfCard(accountNum))
            return -1;
        Card card = cardsDao.findCardByAccountNum(accountNum);
        Customer customer = customersDao.findCustomerByCode(customerCode);
        //计算总价
        double single=getLeastStockPrice(stockCode);
        double total=single*amount;
        if (card.getBalance()>total){
            //购买股票
            //更新card balance
            cardsDao.updateCardBalance(accountNum,card.getBalance()-total);
            //新增股票买入记录
            CustomerStockBuy buy=new CustomerStockBuy();
            buy.setAmount(amount);
            buy.setBuyTime(new Date());
            buy.setCustomerId(customer.getId());
            buy.setStockCode(stockCode);
            return customerStockBuyMapper.insert(buy);
        }
        return -1;
    }
    public double getLeastStockPrice(String stockCode){
        List<StockPriceTime> stockPriceTimes = stockPriceTimeMapper.selectByStockCode(stockCode);
        return stockPriceTimes.get(0).getPrice();
    }
    //检验用户数据
    //todo:考虑加密
    public boolean checkCustomerAndCard(String customerCode, String idNumber, String accountNum, String password){
        Customer customer = customersDao.findCustomerByCode(customerCode);
        if (customer==null)
            return false;
        if (!customer.getIdNumber().equals(idNumber))
            return false;
        Card card = cardsDao.findCardByAccountNum(accountNum);
        if (card==null)
            return false;
        if (!card.getPassword().equals(password)||!card.getCustomerCode().equals(customerCode))
            return false;
        return true;
    }
    //获得目前股票持仓情况
    public int getStockNowAccount(int customerId,String stockCode){
        CustomerStockBuyExample buyExample=new CustomerStockBuyExample();
        buyExample.or().andCustomerIdEqualTo(customerId).andStockCodeEqualTo(stockCode);
        List<CustomerStockBuy> buys = customerStockBuyMapper.selectByExample(buyExample);
        if (buys.size()==0)
            return 0;
        CustomerStockSellExample sellExample=new CustomerStockSellExample();
        sellExample.or().andCustomerIdEqualTo(customerId).andStockCodeEqualTo(stockCode);
        List<CustomerStockSell> sells = customerStockSellMapper.selectByExample(sellExample);
        int buyNum=0;
        for (CustomerStockBuy buy:buys){
            buyNum+=buy.getAmount();
        }
        if (sells.size()==0)
            return buyNum;
        else for(CustomerStockSell sell:sells){
            buyNum-=sell.getAmount();
        }
        return buyNum;
    }
    @Override
    public int sellStock(String stockCode,String customerCode, String idNumber, String accountNum, String password, int amount) {
        if (!checkCustomerAndCard(customerCode,idNumber,accountNum,password))
            return -1;
        //首先计算目前自己持仓情况
        Customer customer = customersDao.findCustomerByCode(customerCode);
        int have=getStockNowAccount(customer.getId(),stockCode);
        if (amount<=have){
            //满足抛售股票资格
            //新增股票抛售记录
            CustomerStockSell sell=new CustomerStockSell();
            sell.setAmount(amount);
            sell.setCustomerId(customer.getId());
            sell.setSellTime(new Date());
            sell.setStockCode(stockCode);
            customerStockSellMapper.insert(sell);
            //更新账户余额
            double profit = amount*getLeastStockPrice(stockCode);
            Card card = cardsDao.findCardByAccountNum(accountNum);
            cardsDao.updateCardBalance(accountNum,profit+card.getBalance());
            return 1;
        }
        return -1;
    }
    @Override
    public List<StockPriceTime> queryStockPrice(String stockCode) {

        return null;
    }

    @Override
    public double queryStockPriceInTime(String stockCode, Date time) {
        return 0;
    }

    @Override
    public List<MyStock> queryStockByCustomerCode(String customerCode) {
        return null;
    }

    @Override
    public List<CustomerStockBuy> queryStockBuyByCustomerCode(String customerCode) {
        return null;
    }

    @Override
    public List<CustomerStockSell> queryStockSellByCustomerCode(String customerCode) {
        return null;
    }

    @Override
    public double queryStockProfitAndLoss(String customerCode) {
        return 0;
    }
}
