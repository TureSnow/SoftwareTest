package com.example.lab1.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomerProductExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CustomerProductExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andCustomerCodeIsNull() {
            addCriterion("customer_code is null");
            return (Criteria) this;
        }

        public Criteria andCustomerCodeIsNotNull() {
            addCriterion("customer_code is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerCodeEqualTo(String value) {
            addCriterion("customer_code =", value, "customerCode");
            return (Criteria) this;
        }

        public Criteria andCustomerCodeNotEqualTo(String value) {
            addCriterion("customer_code <>", value, "customerCode");
            return (Criteria) this;
        }

        public Criteria andCustomerCodeGreaterThan(String value) {
            addCriterion("customer_code >", value, "customerCode");
            return (Criteria) this;
        }

        public Criteria andCustomerCodeGreaterThanOrEqualTo(String value) {
            addCriterion("customer_code >=", value, "customerCode");
            return (Criteria) this;
        }

        public Criteria andCustomerCodeLessThan(String value) {
            addCriterion("customer_code <", value, "customerCode");
            return (Criteria) this;
        }

        public Criteria andCustomerCodeLessThanOrEqualTo(String value) {
            addCriterion("customer_code <=", value, "customerCode");
            return (Criteria) this;
        }

        public Criteria andCustomerCodeLike(String value) {
            addCriterion("customer_code like", value, "customerCode");
            return (Criteria) this;
        }

        public Criteria andCustomerCodeNotLike(String value) {
            addCriterion("customer_code not like", value, "customerCode");
            return (Criteria) this;
        }

        public Criteria andCustomerCodeIn(List<String> values) {
            addCriterion("customer_code in", values, "customerCode");
            return (Criteria) this;
        }

        public Criteria andCustomerCodeNotIn(List<String> values) {
            addCriterion("customer_code not in", values, "customerCode");
            return (Criteria) this;
        }

        public Criteria andCustomerCodeBetween(String value1, String value2) {
            addCriterion("customer_code between", value1, value2, "customerCode");
            return (Criteria) this;
        }

        public Criteria andCustomerCodeNotBetween(String value1, String value2) {
            addCriterion("customer_code not between", value1, value2, "customerCode");
            return (Criteria) this;
        }

        public Criteria andTimeAmountIsNull() {
            addCriterion("time_amount is null");
            return (Criteria) this;
        }

        public Criteria andTimeAmountIsNotNull() {
            addCriterion("time_amount is not null");
            return (Criteria) this;
        }

        public Criteria andTimeAmountEqualTo(Integer value) {
            addCriterion("time_amount =", value, "timeAmount");
            return (Criteria) this;
        }

        public Criteria andTimeAmountNotEqualTo(Integer value) {
            addCriterion("time_amount <>", value, "timeAmount");
            return (Criteria) this;
        }

        public Criteria andTimeAmountGreaterThan(Integer value) {
            addCriterion("time_amount >", value, "timeAmount");
            return (Criteria) this;
        }

        public Criteria andTimeAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("time_amount >=", value, "timeAmount");
            return (Criteria) this;
        }

        public Criteria andTimeAmountLessThan(Integer value) {
            addCriterion("time_amount <", value, "timeAmount");
            return (Criteria) this;
        }

        public Criteria andTimeAmountLessThanOrEqualTo(Integer value) {
            addCriterion("time_amount <=", value, "timeAmount");
            return (Criteria) this;
        }

        public Criteria andTimeAmountIn(List<Integer> values) {
            addCriterion("time_amount in", values, "timeAmount");
            return (Criteria) this;
        }

        public Criteria andTimeAmountNotIn(List<Integer> values) {
            addCriterion("time_amount not in", values, "timeAmount");
            return (Criteria) this;
        }

        public Criteria andTimeAmountBetween(Integer value1, Integer value2) {
            addCriterion("time_amount between", value1, value2, "timeAmount");
            return (Criteria) this;
        }

        public Criteria andTimeAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("time_amount not between", value1, value2, "timeAmount");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNull() {
            addCriterion("created_time is null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNotNull() {
            addCriterion("created_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeEqualTo(Date value) {
            addCriterion("created_time =", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotEqualTo(Date value) {
            addCriterion("created_time <>", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThan(Date value) {
            addCriterion("created_time >", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("created_time >=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThan(Date value) {
            addCriterion("created_time <", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThanOrEqualTo(Date value) {
            addCriterion("created_time <=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIn(List<Date> values) {
            addCriterion("created_time in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotIn(List<Date> values) {
            addCriterion("created_time not in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeBetween(Date value1, Date value2) {
            addCriterion("created_time between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotBetween(Date value1, Date value2) {
            addCriterion("created_time not between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andProductCodeIsNull() {
            addCriterion("product_code is null");
            return (Criteria) this;
        }

        public Criteria andProductCodeIsNotNull() {
            addCriterion("product_code is not null");
            return (Criteria) this;
        }

        public Criteria andProductCodeEqualTo(String value) {
            addCriterion("product_code =", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeNotEqualTo(String value) {
            addCriterion("product_code <>", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeGreaterThan(String value) {
            addCriterion("product_code >", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeGreaterThanOrEqualTo(String value) {
            addCriterion("product_code >=", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeLessThan(String value) {
            addCriterion("product_code <", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeLessThanOrEqualTo(String value) {
            addCriterion("product_code <=", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeLike(String value) {
            addCriterion("product_code like", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeNotLike(String value) {
            addCriterion("product_code not like", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeIn(List<String> values) {
            addCriterion("product_code in", values, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeNotIn(List<String> values) {
            addCriterion("product_code not in", values, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeBetween(String value1, String value2) {
            addCriterion("product_code between", value1, value2, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeNotBetween(String value1, String value2) {
            addCriterion("product_code not between", value1, value2, "productCode");
            return (Criteria) this;
        }

        public Criteria andExpectedTimeIsNull() {
            addCriterion("expected_time is null");
            return (Criteria) this;
        }

        public Criteria andExpectedTimeIsNotNull() {
            addCriterion("expected_time is not null");
            return (Criteria) this;
        }

        public Criteria andExpectedTimeEqualTo(Date value) {
            addCriterion("expected_time =", value, "expectedTime");
            return (Criteria) this;
        }

        public Criteria andExpectedTimeNotEqualTo(Date value) {
            addCriterion("expected_time <>", value, "expectedTime");
            return (Criteria) this;
        }

        public Criteria andExpectedTimeGreaterThan(Date value) {
            addCriterion("expected_time >", value, "expectedTime");
            return (Criteria) this;
        }

        public Criteria andExpectedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("expected_time >=", value, "expectedTime");
            return (Criteria) this;
        }

        public Criteria andExpectedTimeLessThan(Date value) {
            addCriterion("expected_time <", value, "expectedTime");
            return (Criteria) this;
        }

        public Criteria andExpectedTimeLessThanOrEqualTo(Date value) {
            addCriterion("expected_time <=", value, "expectedTime");
            return (Criteria) this;
        }

        public Criteria andExpectedTimeIn(List<Date> values) {
            addCriterion("expected_time in", values, "expectedTime");
            return (Criteria) this;
        }

        public Criteria andExpectedTimeNotIn(List<Date> values) {
            addCriterion("expected_time not in", values, "expectedTime");
            return (Criteria) this;
        }

        public Criteria andExpectedTimeBetween(Date value1, Date value2) {
            addCriterion("expected_time between", value1, value2, "expectedTime");
            return (Criteria) this;
        }

        public Criteria andExpectedTimeNotBetween(Date value1, Date value2) {
            addCriterion("expected_time not between", value1, value2, "expectedTime");
            return (Criteria) this;
        }

        public Criteria andExpectedProfitIsNull() {
            addCriterion("expected_profit is null");
            return (Criteria) this;
        }

        public Criteria andExpectedProfitIsNotNull() {
            addCriterion("expected_profit is not null");
            return (Criteria) this;
        }

        public Criteria andExpectedProfitEqualTo(Double value) {
            addCriterion("expected_profit =", value, "expectedProfit");
            return (Criteria) this;
        }

        public Criteria andExpectedProfitNotEqualTo(Double value) {
            addCriterion("expected_profit <>", value, "expectedProfit");
            return (Criteria) this;
        }

        public Criteria andExpectedProfitGreaterThan(Double value) {
            addCriterion("expected_profit >", value, "expectedProfit");
            return (Criteria) this;
        }

        public Criteria andExpectedProfitGreaterThanOrEqualTo(Double value) {
            addCriterion("expected_profit >=", value, "expectedProfit");
            return (Criteria) this;
        }

        public Criteria andExpectedProfitLessThan(Double value) {
            addCriterion("expected_profit <", value, "expectedProfit");
            return (Criteria) this;
        }

        public Criteria andExpectedProfitLessThanOrEqualTo(Double value) {
            addCriterion("expected_profit <=", value, "expectedProfit");
            return (Criteria) this;
        }

        public Criteria andExpectedProfitIn(List<Double> values) {
            addCriterion("expected_profit in", values, "expectedProfit");
            return (Criteria) this;
        }

        public Criteria andExpectedProfitNotIn(List<Double> values) {
            addCriterion("expected_profit not in", values, "expectedProfit");
            return (Criteria) this;
        }

        public Criteria andExpectedProfitBetween(Double value1, Double value2) {
            addCriterion("expected_profit between", value1, value2, "expectedProfit");
            return (Criteria) this;
        }

        public Criteria andExpectedProfitNotBetween(Double value1, Double value2) {
            addCriterion("expected_profit not between", value1, value2, "expectedProfit");
            return (Criteria) this;
        }

        public Criteria andPrincipalIsNull() {
            addCriterion("principal is null");
            return (Criteria) this;
        }

        public Criteria andPrincipalIsNotNull() {
            addCriterion("principal is not null");
            return (Criteria) this;
        }

        public Criteria andPrincipalEqualTo(Integer value) {
            addCriterion("principal =", value, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalNotEqualTo(Integer value) {
            addCriterion("principal <>", value, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalGreaterThan(Integer value) {
            addCriterion("principal >", value, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalGreaterThanOrEqualTo(Integer value) {
            addCriterion("principal >=", value, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalLessThan(Integer value) {
            addCriterion("principal <", value, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalLessThanOrEqualTo(Integer value) {
            addCriterion("principal <=", value, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalIn(List<Integer> values) {
            addCriterion("principal in", values, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalNotIn(List<Integer> values) {
            addCriterion("principal not in", values, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalBetween(Integer value1, Integer value2) {
            addCriterion("principal between", value1, value2, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalNotBetween(Integer value1, Integer value2) {
            addCriterion("principal not between", value1, value2, "principal");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}