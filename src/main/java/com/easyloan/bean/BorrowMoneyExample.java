package com.easyloan.bean;

import java.util.ArrayList;
import java.util.List;

public class BorrowMoneyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BorrowMoneyExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andBorrowAmountIsNull() {
            addCriterion("borrow_amount is null");
            return (Criteria) this;
        }

        public Criteria andBorrowAmountIsNotNull() {
            addCriterion("borrow_amount is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowAmountEqualTo(Double value) {
            addCriterion("borrow_amount =", value, "borrowAmount");
            return (Criteria) this;
        }

        public Criteria andBorrowAmountNotEqualTo(Double value) {
            addCriterion("borrow_amount <>", value, "borrowAmount");
            return (Criteria) this;
        }

        public Criteria andBorrowAmountGreaterThan(Double value) {
            addCriterion("borrow_amount >", value, "borrowAmount");
            return (Criteria) this;
        }

        public Criteria andBorrowAmountGreaterThanOrEqualTo(Double value) {
            addCriterion("borrow_amount >=", value, "borrowAmount");
            return (Criteria) this;
        }

        public Criteria andBorrowAmountLessThan(Double value) {
            addCriterion("borrow_amount <", value, "borrowAmount");
            return (Criteria) this;
        }

        public Criteria andBorrowAmountLessThanOrEqualTo(Double value) {
            addCriterion("borrow_amount <=", value, "borrowAmount");
            return (Criteria) this;
        }

        public Criteria andBorrowAmountIn(List<Double> values) {
            addCriterion("borrow_amount in", values, "borrowAmount");
            return (Criteria) this;
        }

        public Criteria andBorrowAmountNotIn(List<Double> values) {
            addCriterion("borrow_amount not in", values, "borrowAmount");
            return (Criteria) this;
        }

        public Criteria andBorrowAmountBetween(Double value1, Double value2) {
            addCriterion("borrow_amount between", value1, value2, "borrowAmount");
            return (Criteria) this;
        }

        public Criteria andBorrowAmountNotBetween(Double value1, Double value2) {
            addCriterion("borrow_amount not between", value1, value2, "borrowAmount");
            return (Criteria) this;
        }

        public Criteria andBorrowTernIsNull() {
            addCriterion("borrow_tern is null");
            return (Criteria) this;
        }

        public Criteria andBorrowTernIsNotNull() {
            addCriterion("borrow_tern is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowTernEqualTo(Integer value) {
            addCriterion("borrow_tern =", value, "borrowTern");
            return (Criteria) this;
        }

        public Criteria andBorrowTernNotEqualTo(Integer value) {
            addCriterion("borrow_tern <>", value, "borrowTern");
            return (Criteria) this;
        }

        public Criteria andBorrowTernGreaterThan(Integer value) {
            addCriterion("borrow_tern >", value, "borrowTern");
            return (Criteria) this;
        }

        public Criteria andBorrowTernGreaterThanOrEqualTo(Integer value) {
            addCriterion("borrow_tern >=", value, "borrowTern");
            return (Criteria) this;
        }

        public Criteria andBorrowTernLessThan(Integer value) {
            addCriterion("borrow_tern <", value, "borrowTern");
            return (Criteria) this;
        }

        public Criteria andBorrowTernLessThanOrEqualTo(Integer value) {
            addCriterion("borrow_tern <=", value, "borrowTern");
            return (Criteria) this;
        }

        public Criteria andBorrowTernIn(List<Integer> values) {
            addCriterion("borrow_tern in", values, "borrowTern");
            return (Criteria) this;
        }

        public Criteria andBorrowTernNotIn(List<Integer> values) {
            addCriterion("borrow_tern not in", values, "borrowTern");
            return (Criteria) this;
        }

        public Criteria andBorrowTernBetween(Integer value1, Integer value2) {
            addCriterion("borrow_tern between", value1, value2, "borrowTern");
            return (Criteria) this;
        }

        public Criteria andBorrowTernNotBetween(Integer value1, Integer value2) {
            addCriterion("borrow_tern not between", value1, value2, "borrowTern");
            return (Criteria) this;
        }

        public Criteria andUnitInfoIsNull() {
            addCriterion("unit_info is null");
            return (Criteria) this;
        }

        public Criteria andUnitInfoIsNotNull() {
            addCriterion("unit_info is not null");
            return (Criteria) this;
        }

        public Criteria andUnitInfoEqualTo(String value) {
            addCriterion("unit_info =", value, "unitInfo");
            return (Criteria) this;
        }

        public Criteria andUnitInfoNotEqualTo(String value) {
            addCriterion("unit_info <>", value, "unitInfo");
            return (Criteria) this;
        }

        public Criteria andUnitInfoGreaterThan(String value) {
            addCriterion("unit_info >", value, "unitInfo");
            return (Criteria) this;
        }

        public Criteria andUnitInfoGreaterThanOrEqualTo(String value) {
            addCriterion("unit_info >=", value, "unitInfo");
            return (Criteria) this;
        }

        public Criteria andUnitInfoLessThan(String value) {
            addCriterion("unit_info <", value, "unitInfo");
            return (Criteria) this;
        }

        public Criteria andUnitInfoLessThanOrEqualTo(String value) {
            addCriterion("unit_info <=", value, "unitInfo");
            return (Criteria) this;
        }

        public Criteria andUnitInfoLike(String value) {
            addCriterion("unit_info like", value, "unitInfo");
            return (Criteria) this;
        }

        public Criteria andUnitInfoNotLike(String value) {
            addCriterion("unit_info not like", value, "unitInfo");
            return (Criteria) this;
        }

        public Criteria andUnitInfoIn(List<String> values) {
            addCriterion("unit_info in", values, "unitInfo");
            return (Criteria) this;
        }

        public Criteria andUnitInfoNotIn(List<String> values) {
            addCriterion("unit_info not in", values, "unitInfo");
            return (Criteria) this;
        }

        public Criteria andUnitInfoBetween(String value1, String value2) {
            addCriterion("unit_info between", value1, value2, "unitInfo");
            return (Criteria) this;
        }

        public Criteria andUnitInfoNotBetween(String value1, String value2) {
            addCriterion("unit_info not between", value1, value2, "unitInfo");
            return (Criteria) this;
        }

        public Criteria andFinancialInfoIsNull() {
            addCriterion("financial_info is null");
            return (Criteria) this;
        }

        public Criteria andFinancialInfoIsNotNull() {
            addCriterion("financial_info is not null");
            return (Criteria) this;
        }

        public Criteria andFinancialInfoEqualTo(String value) {
            addCriterion("financial_info =", value, "financialInfo");
            return (Criteria) this;
        }

        public Criteria andFinancialInfoNotEqualTo(String value) {
            addCriterion("financial_info <>", value, "financialInfo");
            return (Criteria) this;
        }

        public Criteria andFinancialInfoGreaterThan(String value) {
            addCriterion("financial_info >", value, "financialInfo");
            return (Criteria) this;
        }

        public Criteria andFinancialInfoGreaterThanOrEqualTo(String value) {
            addCriterion("financial_info >=", value, "financialInfo");
            return (Criteria) this;
        }

        public Criteria andFinancialInfoLessThan(String value) {
            addCriterion("financial_info <", value, "financialInfo");
            return (Criteria) this;
        }

        public Criteria andFinancialInfoLessThanOrEqualTo(String value) {
            addCriterion("financial_info <=", value, "financialInfo");
            return (Criteria) this;
        }

        public Criteria andFinancialInfoLike(String value) {
            addCriterion("financial_info like", value, "financialInfo");
            return (Criteria) this;
        }

        public Criteria andFinancialInfoNotLike(String value) {
            addCriterion("financial_info not like", value, "financialInfo");
            return (Criteria) this;
        }

        public Criteria andFinancialInfoIn(List<String> values) {
            addCriterion("financial_info in", values, "financialInfo");
            return (Criteria) this;
        }

        public Criteria andFinancialInfoNotIn(List<String> values) {
            addCriterion("financial_info not in", values, "financialInfo");
            return (Criteria) this;
        }

        public Criteria andFinancialInfoBetween(String value1, String value2) {
            addCriterion("financial_info between", value1, value2, "financialInfo");
            return (Criteria) this;
        }

        public Criteria andFinancialInfoNotBetween(String value1, String value2) {
            addCriterion("financial_info not between", value1, value2, "financialInfo");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNull() {
            addCriterion("company_name is null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNotNull() {
            addCriterion("company_name is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameEqualTo(String value) {
            addCriterion("company_name =", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotEqualTo(String value) {
            addCriterion("company_name <>", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThan(String value) {
            addCriterion("company_name >", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThanOrEqualTo(String value) {
            addCriterion("company_name >=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThan(String value) {
            addCriterion("company_name <", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThanOrEqualTo(String value) {
            addCriterion("company_name <=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLike(String value) {
            addCriterion("company_name like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotLike(String value) {
            addCriterion("company_name not like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIn(List<String> values) {
            addCriterion("company_name in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotIn(List<String> values) {
            addCriterion("company_name not in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameBetween(String value1, String value2) {
            addCriterion("company_name between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotBetween(String value1, String value2) {
            addCriterion("company_name not between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyLegalPersonIsNull() {
            addCriterion("company_legal_person is null");
            return (Criteria) this;
        }

        public Criteria andCompanyLegalPersonIsNotNull() {
            addCriterion("company_legal_person is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyLegalPersonEqualTo(String value) {
            addCriterion("company_legal_person =", value, "companyLegalPerson");
            return (Criteria) this;
        }

        public Criteria andCompanyLegalPersonNotEqualTo(String value) {
            addCriterion("company_legal_person <>", value, "companyLegalPerson");
            return (Criteria) this;
        }

        public Criteria andCompanyLegalPersonGreaterThan(String value) {
            addCriterion("company_legal_person >", value, "companyLegalPerson");
            return (Criteria) this;
        }

        public Criteria andCompanyLegalPersonGreaterThanOrEqualTo(String value) {
            addCriterion("company_legal_person >=", value, "companyLegalPerson");
            return (Criteria) this;
        }

        public Criteria andCompanyLegalPersonLessThan(String value) {
            addCriterion("company_legal_person <", value, "companyLegalPerson");
            return (Criteria) this;
        }

        public Criteria andCompanyLegalPersonLessThanOrEqualTo(String value) {
            addCriterion("company_legal_person <=", value, "companyLegalPerson");
            return (Criteria) this;
        }

        public Criteria andCompanyLegalPersonLike(String value) {
            addCriterion("company_legal_person like", value, "companyLegalPerson");
            return (Criteria) this;
        }

        public Criteria andCompanyLegalPersonNotLike(String value) {
            addCriterion("company_legal_person not like", value, "companyLegalPerson");
            return (Criteria) this;
        }

        public Criteria andCompanyLegalPersonIn(List<String> values) {
            addCriterion("company_legal_person in", values, "companyLegalPerson");
            return (Criteria) this;
        }

        public Criteria andCompanyLegalPersonNotIn(List<String> values) {
            addCriterion("company_legal_person not in", values, "companyLegalPerson");
            return (Criteria) this;
        }

        public Criteria andCompanyLegalPersonBetween(String value1, String value2) {
            addCriterion("company_legal_person between", value1, value2, "companyLegalPerson");
            return (Criteria) this;
        }

        public Criteria andCompanyLegalPersonNotBetween(String value1, String value2) {
            addCriterion("company_legal_person not between", value1, value2, "companyLegalPerson");
            return (Criteria) this;
        }

        public Criteria andCompanyRegisteredCapitalIsNull() {
            addCriterion("company_registered_capital is null");
            return (Criteria) this;
        }

        public Criteria andCompanyRegisteredCapitalIsNotNull() {
            addCriterion("company_registered_capital is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyRegisteredCapitalEqualTo(Integer value) {
            addCriterion("company_registered_capital =", value, "companyRegisteredCapital");
            return (Criteria) this;
        }

        public Criteria andCompanyRegisteredCapitalNotEqualTo(Integer value) {
            addCriterion("company_registered_capital <>", value, "companyRegisteredCapital");
            return (Criteria) this;
        }

        public Criteria andCompanyRegisteredCapitalGreaterThan(Integer value) {
            addCriterion("company_registered_capital >", value, "companyRegisteredCapital");
            return (Criteria) this;
        }

        public Criteria andCompanyRegisteredCapitalGreaterThanOrEqualTo(Integer value) {
            addCriterion("company_registered_capital >=", value, "companyRegisteredCapital");
            return (Criteria) this;
        }

        public Criteria andCompanyRegisteredCapitalLessThan(Integer value) {
            addCriterion("company_registered_capital <", value, "companyRegisteredCapital");
            return (Criteria) this;
        }

        public Criteria andCompanyRegisteredCapitalLessThanOrEqualTo(Integer value) {
            addCriterion("company_registered_capital <=", value, "companyRegisteredCapital");
            return (Criteria) this;
        }

        public Criteria andCompanyRegisteredCapitalIn(List<Integer> values) {
            addCriterion("company_registered_capital in", values, "companyRegisteredCapital");
            return (Criteria) this;
        }

        public Criteria andCompanyRegisteredCapitalNotIn(List<Integer> values) {
            addCriterion("company_registered_capital not in", values, "companyRegisteredCapital");
            return (Criteria) this;
        }

        public Criteria andCompanyRegisteredCapitalBetween(Integer value1, Integer value2) {
            addCriterion("company_registered_capital between", value1, value2, "companyRegisteredCapital");
            return (Criteria) this;
        }

        public Criteria andCompanyRegisteredCapitalNotBetween(Integer value1, Integer value2) {
            addCriterion("company_registered_capital not between", value1, value2, "companyRegisteredCapital");
            return (Criteria) this;
        }

        public Criteria andCompanyAddrIsNull() {
            addCriterion("company_addr is null");
            return (Criteria) this;
        }

        public Criteria andCompanyAddrIsNotNull() {
            addCriterion("company_addr is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyAddrEqualTo(String value) {
            addCriterion("company_addr =", value, "companyAddr");
            return (Criteria) this;
        }

        public Criteria andCompanyAddrNotEqualTo(String value) {
            addCriterion("company_addr <>", value, "companyAddr");
            return (Criteria) this;
        }

        public Criteria andCompanyAddrGreaterThan(String value) {
            addCriterion("company_addr >", value, "companyAddr");
            return (Criteria) this;
        }

        public Criteria andCompanyAddrGreaterThanOrEqualTo(String value) {
            addCriterion("company_addr >=", value, "companyAddr");
            return (Criteria) this;
        }

        public Criteria andCompanyAddrLessThan(String value) {
            addCriterion("company_addr <", value, "companyAddr");
            return (Criteria) this;
        }

        public Criteria andCompanyAddrLessThanOrEqualTo(String value) {
            addCriterion("company_addr <=", value, "companyAddr");
            return (Criteria) this;
        }

        public Criteria andCompanyAddrLike(String value) {
            addCriterion("company_addr like", value, "companyAddr");
            return (Criteria) this;
        }

        public Criteria andCompanyAddrNotLike(String value) {
            addCriterion("company_addr not like", value, "companyAddr");
            return (Criteria) this;
        }

        public Criteria andCompanyAddrIn(List<String> values) {
            addCriterion("company_addr in", values, "companyAddr");
            return (Criteria) this;
        }

        public Criteria andCompanyAddrNotIn(List<String> values) {
            addCriterion("company_addr not in", values, "companyAddr");
            return (Criteria) this;
        }

        public Criteria andCompanyAddrBetween(String value1, String value2) {
            addCriterion("company_addr between", value1, value2, "companyAddr");
            return (Criteria) this;
        }

        public Criteria andCompanyAddrNotBetween(String value1, String value2) {
            addCriterion("company_addr not between", value1, value2, "companyAddr");
            return (Criteria) this;
        }

        public Criteria andCompanyNumIsNull() {
            addCriterion("company_num is null");
            return (Criteria) this;
        }

        public Criteria andCompanyNumIsNotNull() {
            addCriterion("company_num is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyNumEqualTo(String value) {
            addCriterion("company_num =", value, "companyNum");
            return (Criteria) this;
        }

        public Criteria andCompanyNumNotEqualTo(String value) {
            addCriterion("company_num <>", value, "companyNum");
            return (Criteria) this;
        }

        public Criteria andCompanyNumGreaterThan(String value) {
            addCriterion("company_num >", value, "companyNum");
            return (Criteria) this;
        }

        public Criteria andCompanyNumGreaterThanOrEqualTo(String value) {
            addCriterion("company_num >=", value, "companyNum");
            return (Criteria) this;
        }

        public Criteria andCompanyNumLessThan(String value) {
            addCriterion("company_num <", value, "companyNum");
            return (Criteria) this;
        }

        public Criteria andCompanyNumLessThanOrEqualTo(String value) {
            addCriterion("company_num <=", value, "companyNum");
            return (Criteria) this;
        }

        public Criteria andCompanyNumLike(String value) {
            addCriterion("company_num like", value, "companyNum");
            return (Criteria) this;
        }

        public Criteria andCompanyNumNotLike(String value) {
            addCriterion("company_num not like", value, "companyNum");
            return (Criteria) this;
        }

        public Criteria andCompanyNumIn(List<String> values) {
            addCriterion("company_num in", values, "companyNum");
            return (Criteria) this;
        }

        public Criteria andCompanyNumNotIn(List<String> values) {
            addCriterion("company_num not in", values, "companyNum");
            return (Criteria) this;
        }

        public Criteria andCompanyNumBetween(String value1, String value2) {
            addCriterion("company_num between", value1, value2, "companyNum");
            return (Criteria) this;
        }

        public Criteria andCompanyNumNotBetween(String value1, String value2) {
            addCriterion("company_num not between", value1, value2, "companyNum");
            return (Criteria) this;
        }

        public Criteria andCompanyFinancingIsNull() {
            addCriterion("company_financing is null");
            return (Criteria) this;
        }

        public Criteria andCompanyFinancingIsNotNull() {
            addCriterion("company_financing is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyFinancingEqualTo(Integer value) {
            addCriterion("company_financing =", value, "companyFinancing");
            return (Criteria) this;
        }

        public Criteria andCompanyFinancingNotEqualTo(Integer value) {
            addCriterion("company_financing <>", value, "companyFinancing");
            return (Criteria) this;
        }

        public Criteria andCompanyFinancingGreaterThan(Integer value) {
            addCriterion("company_financing >", value, "companyFinancing");
            return (Criteria) this;
        }

        public Criteria andCompanyFinancingGreaterThanOrEqualTo(Integer value) {
            addCriterion("company_financing >=", value, "companyFinancing");
            return (Criteria) this;
        }

        public Criteria andCompanyFinancingLessThan(Integer value) {
            addCriterion("company_financing <", value, "companyFinancing");
            return (Criteria) this;
        }

        public Criteria andCompanyFinancingLessThanOrEqualTo(Integer value) {
            addCriterion("company_financing <=", value, "companyFinancing");
            return (Criteria) this;
        }

        public Criteria andCompanyFinancingIn(List<Integer> values) {
            addCriterion("company_financing in", values, "companyFinancing");
            return (Criteria) this;
        }

        public Criteria andCompanyFinancingNotIn(List<Integer> values) {
            addCriterion("company_financing not in", values, "companyFinancing");
            return (Criteria) this;
        }

        public Criteria andCompanyFinancingBetween(Integer value1, Integer value2) {
            addCriterion("company_financing between", value1, value2, "companyFinancing");
            return (Criteria) this;
        }

        public Criteria andCompanyFinancingNotBetween(Integer value1, Integer value2) {
            addCriterion("company_financing not between", value1, value2, "companyFinancing");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andBorrowDatumIdIsNull() {
            addCriterion("borrow_datum_id is null");
            return (Criteria) this;
        }

        public Criteria andBorrowDatumIdIsNotNull() {
            addCriterion("borrow_datum_id is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowDatumIdEqualTo(String value) {
            addCriterion("borrow_datum_id =", value, "borrowDatumId");
            return (Criteria) this;
        }

        public Criteria andBorrowDatumIdNotEqualTo(String value) {
            addCriterion("borrow_datum_id <>", value, "borrowDatumId");
            return (Criteria) this;
        }

        public Criteria andBorrowDatumIdGreaterThan(String value) {
            addCriterion("borrow_datum_id >", value, "borrowDatumId");
            return (Criteria) this;
        }

        public Criteria andBorrowDatumIdGreaterThanOrEqualTo(String value) {
            addCriterion("borrow_datum_id >=", value, "borrowDatumId");
            return (Criteria) this;
        }

        public Criteria andBorrowDatumIdLessThan(String value) {
            addCriterion("borrow_datum_id <", value, "borrowDatumId");
            return (Criteria) this;
        }

        public Criteria andBorrowDatumIdLessThanOrEqualTo(String value) {
            addCriterion("borrow_datum_id <=", value, "borrowDatumId");
            return (Criteria) this;
        }

        public Criteria andBorrowDatumIdLike(String value) {
            addCriterion("borrow_datum_id like", value, "borrowDatumId");
            return (Criteria) this;
        }

        public Criteria andBorrowDatumIdNotLike(String value) {
            addCriterion("borrow_datum_id not like", value, "borrowDatumId");
            return (Criteria) this;
        }

        public Criteria andBorrowDatumIdIn(List<String> values) {
            addCriterion("borrow_datum_id in", values, "borrowDatumId");
            return (Criteria) this;
        }

        public Criteria andBorrowDatumIdNotIn(List<String> values) {
            addCriterion("borrow_datum_id not in", values, "borrowDatumId");
            return (Criteria) this;
        }

        public Criteria andBorrowDatumIdBetween(String value1, String value2) {
            addCriterion("borrow_datum_id between", value1, value2, "borrowDatumId");
            return (Criteria) this;
        }

        public Criteria andBorrowDatumIdNotBetween(String value1, String value2) {
            addCriterion("borrow_datum_id not between", value1, value2, "borrowDatumId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(String value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(String value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(String value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(String value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(String value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLike(String value) {
            addCriterion("create_time like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotLike(String value) {
            addCriterion("create_time not like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<String> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<String> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(String value1, String value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(String value1, String value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreditCardIsNull() {
            addCriterion("credit_card is null");
            return (Criteria) this;
        }

        public Criteria andCreditCardIsNotNull() {
            addCriterion("credit_card is not null");
            return (Criteria) this;
        }

        public Criteria andCreditCardEqualTo(String value) {
            addCriterion("credit_card =", value, "creditCard");
            return (Criteria) this;
        }

        public Criteria andCreditCardNotEqualTo(String value) {
            addCriterion("credit_card <>", value, "creditCard");
            return (Criteria) this;
        }

        public Criteria andCreditCardGreaterThan(String value) {
            addCriterion("credit_card >", value, "creditCard");
            return (Criteria) this;
        }

        public Criteria andCreditCardGreaterThanOrEqualTo(String value) {
            addCriterion("credit_card >=", value, "creditCard");
            return (Criteria) this;
        }

        public Criteria andCreditCardLessThan(String value) {
            addCriterion("credit_card <", value, "creditCard");
            return (Criteria) this;
        }

        public Criteria andCreditCardLessThanOrEqualTo(String value) {
            addCriterion("credit_card <=", value, "creditCard");
            return (Criteria) this;
        }

        public Criteria andCreditCardLike(String value) {
            addCriterion("credit_card like", value, "creditCard");
            return (Criteria) this;
        }

        public Criteria andCreditCardNotLike(String value) {
            addCriterion("credit_card not like", value, "creditCard");
            return (Criteria) this;
        }

        public Criteria andCreditCardIn(List<String> values) {
            addCriterion("credit_card in", values, "creditCard");
            return (Criteria) this;
        }

        public Criteria andCreditCardNotIn(List<String> values) {
            addCriterion("credit_card not in", values, "creditCard");
            return (Criteria) this;
        }

        public Criteria andCreditCardBetween(String value1, String value2) {
            addCriterion("credit_card between", value1, value2, "creditCard");
            return (Criteria) this;
        }

        public Criteria andCreditCardNotBetween(String value1, String value2) {
            addCriterion("credit_card not between", value1, value2, "creditCard");
            return (Criteria) this;
        }

        public Criteria andBorrowDeadlineIsNull() {
            addCriterion("borrow_deadline is null");
            return (Criteria) this;
        }

        public Criteria andBorrowDeadlineIsNotNull() {
            addCriterion("borrow_deadline is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowDeadlineEqualTo(String value) {
            addCriterion("borrow_deadline =", value, "borrowDeadline");
            return (Criteria) this;
        }

        public Criteria andBorrowDeadlineNotEqualTo(String value) {
            addCriterion("borrow_deadline <>", value, "borrowDeadline");
            return (Criteria) this;
        }

        public Criteria andBorrowDeadlineGreaterThan(String value) {
            addCriterion("borrow_deadline >", value, "borrowDeadline");
            return (Criteria) this;
        }

        public Criteria andBorrowDeadlineGreaterThanOrEqualTo(String value) {
            addCriterion("borrow_deadline >=", value, "borrowDeadline");
            return (Criteria) this;
        }

        public Criteria andBorrowDeadlineLessThan(String value) {
            addCriterion("borrow_deadline <", value, "borrowDeadline");
            return (Criteria) this;
        }

        public Criteria andBorrowDeadlineLessThanOrEqualTo(String value) {
            addCriterion("borrow_deadline <=", value, "borrowDeadline");
            return (Criteria) this;
        }

        public Criteria andBorrowDeadlineLike(String value) {
            addCriterion("borrow_deadline like", value, "borrowDeadline");
            return (Criteria) this;
        }

        public Criteria andBorrowDeadlineNotLike(String value) {
            addCriterion("borrow_deadline not like", value, "borrowDeadline");
            return (Criteria) this;
        }

        public Criteria andBorrowDeadlineIn(List<String> values) {
            addCriterion("borrow_deadline in", values, "borrowDeadline");
            return (Criteria) this;
        }

        public Criteria andBorrowDeadlineNotIn(List<String> values) {
            addCriterion("borrow_deadline not in", values, "borrowDeadline");
            return (Criteria) this;
        }

        public Criteria andBorrowDeadlineBetween(String value1, String value2) {
            addCriterion("borrow_deadline between", value1, value2, "borrowDeadline");
            return (Criteria) this;
        }

        public Criteria andBorrowDeadlineNotBetween(String value1, String value2) {
            addCriterion("borrow_deadline not between", value1, value2, "borrowDeadline");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
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