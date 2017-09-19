package com.easyloan.bean;

import java.util.ArrayList;
import java.util.List;

public class SafetyQuestionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SafetyQuestionExample() {
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

        public Criteria andQuestionIsNull() {
            addCriterion("question is null");
            return (Criteria) this;
        }

        public Criteria andQuestionIsNotNull() {
            addCriterion("question is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionEqualTo(String value) {
            addCriterion("question =", value, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionNotEqualTo(String value) {
            addCriterion("question <>", value, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionGreaterThan(String value) {
            addCriterion("question >", value, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionGreaterThanOrEqualTo(String value) {
            addCriterion("question >=", value, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionLessThan(String value) {
            addCriterion("question <", value, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionLessThanOrEqualTo(String value) {
            addCriterion("question <=", value, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionLike(String value) {
            addCriterion("question like", value, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionNotLike(String value) {
            addCriterion("question not like", value, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionIn(List<String> values) {
            addCriterion("question in", values, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionNotIn(List<String> values) {
            addCriterion("question not in", values, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionBetween(String value1, String value2) {
            addCriterion("question between", value1, value2, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionNotBetween(String value1, String value2) {
            addCriterion("question not between", value1, value2, "question");
            return (Criteria) this;
        }

        public Criteria andAnswerIsNull() {
            addCriterion("answer is null");
            return (Criteria) this;
        }

        public Criteria andAnswerIsNotNull() {
            addCriterion("answer is not null");
            return (Criteria) this;
        }

        public Criteria andAnswerEqualTo(String value) {
            addCriterion("answer =", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotEqualTo(String value) {
            addCriterion("answer <>", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerGreaterThan(String value) {
            addCriterion("answer >", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerGreaterThanOrEqualTo(String value) {
            addCriterion("answer >=", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerLessThan(String value) {
            addCriterion("answer <", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerLessThanOrEqualTo(String value) {
            addCriterion("answer <=", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerLike(String value) {
            addCriterion("answer like", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotLike(String value) {
            addCriterion("answer not like", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerIn(List<String> values) {
            addCriterion("answer in", values, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotIn(List<String> values) {
            addCriterion("answer not in", values, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerBetween(String value1, String value2) {
            addCriterion("answer between", value1, value2, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotBetween(String value1, String value2) {
            addCriterion("answer not between", value1, value2, "answer");
            return (Criteria) this;
        }

        public Criteria andSafetyEmailIsNull() {
            addCriterion("safety_email is null");
            return (Criteria) this;
        }

        public Criteria andSafetyEmailIsNotNull() {
            addCriterion("safety_email is not null");
            return (Criteria) this;
        }

        public Criteria andSafetyEmailEqualTo(String value) {
            addCriterion("safety_email =", value, "safetyEmail");
            return (Criteria) this;
        }

        public Criteria andSafetyEmailNotEqualTo(String value) {
            addCriterion("safety_email <>", value, "safetyEmail");
            return (Criteria) this;
        }

        public Criteria andSafetyEmailGreaterThan(String value) {
            addCriterion("safety_email >", value, "safetyEmail");
            return (Criteria) this;
        }

        public Criteria andSafetyEmailGreaterThanOrEqualTo(String value) {
            addCriterion("safety_email >=", value, "safetyEmail");
            return (Criteria) this;
        }

        public Criteria andSafetyEmailLessThan(String value) {
            addCriterion("safety_email <", value, "safetyEmail");
            return (Criteria) this;
        }

        public Criteria andSafetyEmailLessThanOrEqualTo(String value) {
            addCriterion("safety_email <=", value, "safetyEmail");
            return (Criteria) this;
        }

        public Criteria andSafetyEmailLike(String value) {
            addCriterion("safety_email like", value, "safetyEmail");
            return (Criteria) this;
        }

        public Criteria andSafetyEmailNotLike(String value) {
            addCriterion("safety_email not like", value, "safetyEmail");
            return (Criteria) this;
        }

        public Criteria andSafetyEmailIn(List<String> values) {
            addCriterion("safety_email in", values, "safetyEmail");
            return (Criteria) this;
        }

        public Criteria andSafetyEmailNotIn(List<String> values) {
            addCriterion("safety_email not in", values, "safetyEmail");
            return (Criteria) this;
        }

        public Criteria andSafetyEmailBetween(String value1, String value2) {
            addCriterion("safety_email between", value1, value2, "safetyEmail");
            return (Criteria) this;
        }

        public Criteria andSafetyEmailNotBetween(String value1, String value2) {
            addCriterion("safety_email not between", value1, value2, "safetyEmail");
            return (Criteria) this;
        }

        public Criteria andSafetyLevelIsNull() {
            addCriterion("safety_level is null");
            return (Criteria) this;
        }

        public Criteria andSafetyLevelIsNotNull() {
            addCriterion("safety_level is not null");
            return (Criteria) this;
        }

        public Criteria andSafetyLevelEqualTo(Integer value) {
            addCriterion("safety_level =", value, "safetyLevel");
            return (Criteria) this;
        }

        public Criteria andSafetyLevelNotEqualTo(Integer value) {
            addCriterion("safety_level <>", value, "safetyLevel");
            return (Criteria) this;
        }

        public Criteria andSafetyLevelGreaterThan(Integer value) {
            addCriterion("safety_level >", value, "safetyLevel");
            return (Criteria) this;
        }

        public Criteria andSafetyLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("safety_level >=", value, "safetyLevel");
            return (Criteria) this;
        }

        public Criteria andSafetyLevelLessThan(Integer value) {
            addCriterion("safety_level <", value, "safetyLevel");
            return (Criteria) this;
        }

        public Criteria andSafetyLevelLessThanOrEqualTo(Integer value) {
            addCriterion("safety_level <=", value, "safetyLevel");
            return (Criteria) this;
        }

        public Criteria andSafetyLevelIn(List<Integer> values) {
            addCriterion("safety_level in", values, "safetyLevel");
            return (Criteria) this;
        }

        public Criteria andSafetyLevelNotIn(List<Integer> values) {
            addCriterion("safety_level not in", values, "safetyLevel");
            return (Criteria) this;
        }

        public Criteria andSafetyLevelBetween(Integer value1, Integer value2) {
            addCriterion("safety_level between", value1, value2, "safetyLevel");
            return (Criteria) this;
        }

        public Criteria andSafetyLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("safety_level not between", value1, value2, "safetyLevel");
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