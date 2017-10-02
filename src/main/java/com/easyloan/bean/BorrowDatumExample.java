package com.easyloan.bean;

import java.util.ArrayList;
import java.util.List;

public class BorrowDatumExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BorrowDatumExample() {
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

        public Criteria andBorrowFileIsNull() {
            addCriterion("borrow_file is null");
            return (Criteria) this;
        }

        public Criteria andBorrowFileIsNotNull() {
            addCriterion("borrow_file is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowFileEqualTo(String value) {
            addCriterion("borrow_file =", value, "borrowFile");
            return (Criteria) this;
        }

        public Criteria andBorrowFileNotEqualTo(String value) {
            addCriterion("borrow_file <>", value, "borrowFile");
            return (Criteria) this;
        }

        public Criteria andBorrowFileGreaterThan(String value) {
            addCriterion("borrow_file >", value, "borrowFile");
            return (Criteria) this;
        }

        public Criteria andBorrowFileGreaterThanOrEqualTo(String value) {
            addCriterion("borrow_file >=", value, "borrowFile");
            return (Criteria) this;
        }

        public Criteria andBorrowFileLessThan(String value) {
            addCriterion("borrow_file <", value, "borrowFile");
            return (Criteria) this;
        }

        public Criteria andBorrowFileLessThanOrEqualTo(String value) {
            addCriterion("borrow_file <=", value, "borrowFile");
            return (Criteria) this;
        }

        public Criteria andBorrowFileLike(String value) {
            addCriterion("borrow_file like", value, "borrowFile");
            return (Criteria) this;
        }

        public Criteria andBorrowFileNotLike(String value) {
            addCriterion("borrow_file not like", value, "borrowFile");
            return (Criteria) this;
        }

        public Criteria andBorrowFileIn(List<String> values) {
            addCriterion("borrow_file in", values, "borrowFile");
            return (Criteria) this;
        }

        public Criteria andBorrowFileNotIn(List<String> values) {
            addCriterion("borrow_file not in", values, "borrowFile");
            return (Criteria) this;
        }

        public Criteria andBorrowFileBetween(String value1, String value2) {
            addCriterion("borrow_file between", value1, value2, "borrowFile");
            return (Criteria) this;
        }

        public Criteria andBorrowFileNotBetween(String value1, String value2) {
            addCriterion("borrow_file not between", value1, value2, "borrowFile");
            return (Criteria) this;
        }

        public Criteria andBorrowDetailsIsNull() {
            addCriterion("borrow_details is null");
            return (Criteria) this;
        }

        public Criteria andBorrowDetailsIsNotNull() {
            addCriterion("borrow_details is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowDetailsEqualTo(String value) {
            addCriterion("borrow_details =", value, "borrowDetails");
            return (Criteria) this;
        }

        public Criteria andBorrowDetailsNotEqualTo(String value) {
            addCriterion("borrow_details <>", value, "borrowDetails");
            return (Criteria) this;
        }

        public Criteria andBorrowDetailsGreaterThan(String value) {
            addCriterion("borrow_details >", value, "borrowDetails");
            return (Criteria) this;
        }

        public Criteria andBorrowDetailsGreaterThanOrEqualTo(String value) {
            addCriterion("borrow_details >=", value, "borrowDetails");
            return (Criteria) this;
        }

        public Criteria andBorrowDetailsLessThan(String value) {
            addCriterion("borrow_details <", value, "borrowDetails");
            return (Criteria) this;
        }

        public Criteria andBorrowDetailsLessThanOrEqualTo(String value) {
            addCriterion("borrow_details <=", value, "borrowDetails");
            return (Criteria) this;
        }

        public Criteria andBorrowDetailsLike(String value) {
            addCriterion("borrow_details like", value, "borrowDetails");
            return (Criteria) this;
        }

        public Criteria andBorrowDetailsNotLike(String value) {
            addCriterion("borrow_details not like", value, "borrowDetails");
            return (Criteria) this;
        }

        public Criteria andBorrowDetailsIn(List<String> values) {
            addCriterion("borrow_details in", values, "borrowDetails");
            return (Criteria) this;
        }

        public Criteria andBorrowDetailsNotIn(List<String> values) {
            addCriterion("borrow_details not in", values, "borrowDetails");
            return (Criteria) this;
        }

        public Criteria andBorrowDetailsBetween(String value1, String value2) {
            addCriterion("borrow_details between", value1, value2, "borrowDetails");
            return (Criteria) this;
        }

        public Criteria andBorrowDetailsNotBetween(String value1, String value2) {
            addCriterion("borrow_details not between", value1, value2, "borrowDetails");
            return (Criteria) this;
        }

        public Criteria andTotalInvestIsNull() {
            addCriterion("total_invest is null");
            return (Criteria) this;
        }

        public Criteria andTotalInvestIsNotNull() {
            addCriterion("total_invest is not null");
            return (Criteria) this;
        }

        public Criteria andTotalInvestEqualTo(Double value) {
            addCriterion("total_invest =", value, "totalInvest");
            return (Criteria) this;
        }

        public Criteria andTotalInvestNotEqualTo(Double value) {
            addCriterion("total_invest <>", value, "totalInvest");
            return (Criteria) this;
        }

        public Criteria andTotalInvestGreaterThan(Double value) {
            addCriterion("total_invest >", value, "totalInvest");
            return (Criteria) this;
        }

        public Criteria andTotalInvestGreaterThanOrEqualTo(Double value) {
            addCriterion("total_invest >=", value, "totalInvest");
            return (Criteria) this;
        }

        public Criteria andTotalInvestLessThan(Double value) {
            addCriterion("total_invest <", value, "totalInvest");
            return (Criteria) this;
        }

        public Criteria andTotalInvestLessThanOrEqualTo(Double value) {
            addCriterion("total_invest <=", value, "totalInvest");
            return (Criteria) this;
        }

        public Criteria andTotalInvestIn(List<Double> values) {
            addCriterion("total_invest in", values, "totalInvest");
            return (Criteria) this;
        }

        public Criteria andTotalInvestNotIn(List<Double> values) {
            addCriterion("total_invest not in", values, "totalInvest");
            return (Criteria) this;
        }

        public Criteria andTotalInvestBetween(Double value1, Double value2) {
            addCriterion("total_invest between", value1, value2, "totalInvest");
            return (Criteria) this;
        }

        public Criteria andTotalInvestNotBetween(Double value1, Double value2) {
            addCriterion("total_invest not between", value1, value2, "totalInvest");
            return (Criteria) this;
        }

        public Criteria andIdentityFileIsNull() {
            addCriterion("identity_file is null");
            return (Criteria) this;
        }

        public Criteria andIdentityFileIsNotNull() {
            addCriterion("identity_file is not null");
            return (Criteria) this;
        }

        public Criteria andIdentityFileEqualTo(String value) {
            addCriterion("identity_file =", value, "identityFile");
            return (Criteria) this;
        }

        public Criteria andIdentityFileNotEqualTo(String value) {
            addCriterion("identity_file <>", value, "identityFile");
            return (Criteria) this;
        }

        public Criteria andIdentityFileGreaterThan(String value) {
            addCriterion("identity_file >", value, "identityFile");
            return (Criteria) this;
        }

        public Criteria andIdentityFileGreaterThanOrEqualTo(String value) {
            addCriterion("identity_file >=", value, "identityFile");
            return (Criteria) this;
        }

        public Criteria andIdentityFileLessThan(String value) {
            addCriterion("identity_file <", value, "identityFile");
            return (Criteria) this;
        }

        public Criteria andIdentityFileLessThanOrEqualTo(String value) {
            addCriterion("identity_file <=", value, "identityFile");
            return (Criteria) this;
        }

        public Criteria andIdentityFileLike(String value) {
            addCriterion("identity_file like", value, "identityFile");
            return (Criteria) this;
        }

        public Criteria andIdentityFileNotLike(String value) {
            addCriterion("identity_file not like", value, "identityFile");
            return (Criteria) this;
        }

        public Criteria andIdentityFileIn(List<String> values) {
            addCriterion("identity_file in", values, "identityFile");
            return (Criteria) this;
        }

        public Criteria andIdentityFileNotIn(List<String> values) {
            addCriterion("identity_file not in", values, "identityFile");
            return (Criteria) this;
        }

        public Criteria andIdentityFileBetween(String value1, String value2) {
            addCriterion("identity_file between", value1, value2, "identityFile");
            return (Criteria) this;
        }

        public Criteria andIdentityFileNotBetween(String value1, String value2) {
            addCriterion("identity_file not between", value1, value2, "identityFile");
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