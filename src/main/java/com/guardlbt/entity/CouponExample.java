package com.guardlbt.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CouponExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CouponExample() {
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

        public Criteria andCouponIdIsNull() {
            addCriterion("coupon_id is null");
            return (Criteria) this;
        }

        public Criteria andCouponIdIsNotNull() {
            addCriterion("coupon_id is not null");
            return (Criteria) this;
        }

        public Criteria andCouponIdEqualTo(Long value) {
            addCriterion("coupon_id =", value, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdNotEqualTo(Long value) {
            addCriterion("coupon_id <>", value, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdGreaterThan(Long value) {
            addCriterion("coupon_id >", value, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdGreaterThanOrEqualTo(Long value) {
            addCriterion("coupon_id >=", value, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdLessThan(Long value) {
            addCriterion("coupon_id <", value, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdLessThanOrEqualTo(Long value) {
            addCriterion("coupon_id <=", value, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdIn(List<Long> values) {
            addCriterion("coupon_id in", values, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdNotIn(List<Long> values) {
            addCriterion("coupon_id not in", values, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdBetween(Long value1, Long value2) {
            addCriterion("coupon_id between", value1, value2, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdNotBetween(Long value1, Long value2) {
            addCriterion("coupon_id not between", value1, value2, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponStatusIsNull() {
            addCriterion("coupon_status is null");
            return (Criteria) this;
        }

        public Criteria andCouponStatusIsNotNull() {
            addCriterion("coupon_status is not null");
            return (Criteria) this;
        }

        public Criteria andCouponStatusEqualTo(Integer value) {
            addCriterion("coupon_status =", value, "couponStatus");
            return (Criteria) this;
        }

        public Criteria andCouponStatusNotEqualTo(Integer value) {
            addCriterion("coupon_status <>", value, "couponStatus");
            return (Criteria) this;
        }

        public Criteria andCouponStatusGreaterThan(Integer value) {
            addCriterion("coupon_status >", value, "couponStatus");
            return (Criteria) this;
        }

        public Criteria andCouponStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("coupon_status >=", value, "couponStatus");
            return (Criteria) this;
        }

        public Criteria andCouponStatusLessThan(Integer value) {
            addCriterion("coupon_status <", value, "couponStatus");
            return (Criteria) this;
        }

        public Criteria andCouponStatusLessThanOrEqualTo(Integer value) {
            addCriterion("coupon_status <=", value, "couponStatus");
            return (Criteria) this;
        }

        public Criteria andCouponStatusIn(List<Integer> values) {
            addCriterion("coupon_status in", values, "couponStatus");
            return (Criteria) this;
        }

        public Criteria andCouponStatusNotIn(List<Integer> values) {
            addCriterion("coupon_status not in", values, "couponStatus");
            return (Criteria) this;
        }

        public Criteria andCouponStatusBetween(Integer value1, Integer value2) {
            addCriterion("coupon_status between", value1, value2, "couponStatus");
            return (Criteria) this;
        }

        public Criteria andCouponStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("coupon_status not between", value1, value2, "couponStatus");
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

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andRecyUserIsNull() {
            addCriterion("recy_user is null");
            return (Criteria) this;
        }

        public Criteria andRecyUserIsNotNull() {
            addCriterion("recy_user is not null");
            return (Criteria) this;
        }

        public Criteria andRecyUserEqualTo(String value) {
            addCriterion("recy_user =", value, "recyUser");
            return (Criteria) this;
        }

        public Criteria andRecyUserNotEqualTo(String value) {
            addCriterion("recy_user <>", value, "recyUser");
            return (Criteria) this;
        }

        public Criteria andRecyUserGreaterThan(String value) {
            addCriterion("recy_user >", value, "recyUser");
            return (Criteria) this;
        }

        public Criteria andRecyUserGreaterThanOrEqualTo(String value) {
            addCriterion("recy_user >=", value, "recyUser");
            return (Criteria) this;
        }

        public Criteria andRecyUserLessThan(String value) {
            addCriterion("recy_user <", value, "recyUser");
            return (Criteria) this;
        }

        public Criteria andRecyUserLessThanOrEqualTo(String value) {
            addCriterion("recy_user <=", value, "recyUser");
            return (Criteria) this;
        }

        public Criteria andRecyUserLike(String value) {
            addCriterion("recy_user like", value, "recyUser");
            return (Criteria) this;
        }

        public Criteria andRecyUserNotLike(String value) {
            addCriterion("recy_user not like", value, "recyUser");
            return (Criteria) this;
        }

        public Criteria andRecyUserIn(List<String> values) {
            addCriterion("recy_user in", values, "recyUser");
            return (Criteria) this;
        }

        public Criteria andRecyUserNotIn(List<String> values) {
            addCriterion("recy_user not in", values, "recyUser");
            return (Criteria) this;
        }

        public Criteria andRecyUserBetween(String value1, String value2) {
            addCriterion("recy_user between", value1, value2, "recyUser");
            return (Criteria) this;
        }

        public Criteria andRecyUserNotBetween(String value1, String value2) {
            addCriterion("recy_user not between", value1, value2, "recyUser");
            return (Criteria) this;
        }

        public Criteria andCouponEncryptIsNull() {
            addCriterion("coupon_encrypt is null");
            return (Criteria) this;
        }

        public Criteria andCouponEncryptIsNotNull() {
            addCriterion("coupon_encrypt is not null");
            return (Criteria) this;
        }

        public Criteria andCouponEncryptEqualTo(String value) {
            addCriterion("coupon_encrypt =", value, "couponEncrypt");
            return (Criteria) this;
        }

        public Criteria andCouponEncryptNotEqualTo(String value) {
            addCriterion("coupon_encrypt <>", value, "couponEncrypt");
            return (Criteria) this;
        }

        public Criteria andCouponEncryptGreaterThan(String value) {
            addCriterion("coupon_encrypt >", value, "couponEncrypt");
            return (Criteria) this;
        }

        public Criteria andCouponEncryptGreaterThanOrEqualTo(String value) {
            addCriterion("coupon_encrypt >=", value, "couponEncrypt");
            return (Criteria) this;
        }

        public Criteria andCouponEncryptLessThan(String value) {
            addCriterion("coupon_encrypt <", value, "couponEncrypt");
            return (Criteria) this;
        }

        public Criteria andCouponEncryptLessThanOrEqualTo(String value) {
            addCriterion("coupon_encrypt <=", value, "couponEncrypt");
            return (Criteria) this;
        }

        public Criteria andCouponEncryptLike(String value) {
            addCriterion("coupon_encrypt like", value, "couponEncrypt");
            return (Criteria) this;
        }

        public Criteria andCouponEncryptNotLike(String value) {
            addCriterion("coupon_encrypt not like", value, "couponEncrypt");
            return (Criteria) this;
        }

        public Criteria andCouponEncryptIn(List<String> values) {
            addCriterion("coupon_encrypt in", values, "couponEncrypt");
            return (Criteria) this;
        }

        public Criteria andCouponEncryptNotIn(List<String> values) {
            addCriterion("coupon_encrypt not in", values, "couponEncrypt");
            return (Criteria) this;
        }

        public Criteria andCouponEncryptBetween(String value1, String value2) {
            addCriterion("coupon_encrypt between", value1, value2, "couponEncrypt");
            return (Criteria) this;
        }

        public Criteria andCouponEncryptNotBetween(String value1, String value2) {
            addCriterion("coupon_encrypt not between", value1, value2, "couponEncrypt");
            return (Criteria) this;
        }

        public Criteria andCouponManualcodeIsNull() {
            addCriterion("coupon_manualCode is null");
            return (Criteria) this;
        }

        public Criteria andCouponManualcodeIsNotNull() {
            addCriterion("coupon_manualCode is not null");
            return (Criteria) this;
        }

        public Criteria andCouponManualcodeEqualTo(String value) {
            addCriterion("coupon_manualCode =", value, "couponManualcode");
            return (Criteria) this;
        }

        public Criteria andCouponManualcodeNotEqualTo(String value) {
            addCriterion("coupon_manualCode <>", value, "couponManualcode");
            return (Criteria) this;
        }

        public Criteria andCouponManualcodeGreaterThan(String value) {
            addCriterion("coupon_manualCode >", value, "couponManualcode");
            return (Criteria) this;
        }

        public Criteria andCouponManualcodeGreaterThanOrEqualTo(String value) {
            addCriterion("coupon_manualCode >=", value, "couponManualcode");
            return (Criteria) this;
        }

        public Criteria andCouponManualcodeLessThan(String value) {
            addCriterion("coupon_manualCode <", value, "couponManualcode");
            return (Criteria) this;
        }

        public Criteria andCouponManualcodeLessThanOrEqualTo(String value) {
            addCriterion("coupon_manualCode <=", value, "couponManualcode");
            return (Criteria) this;
        }

        public Criteria andCouponManualcodeLike(String value) {
            addCriterion("coupon_manualCode like", value, "couponManualcode");
            return (Criteria) this;
        }

        public Criteria andCouponManualcodeNotLike(String value) {
            addCriterion("coupon_manualCode not like", value, "couponManualcode");
            return (Criteria) this;
        }

        public Criteria andCouponManualcodeIn(List<String> values) {
            addCriterion("coupon_manualCode in", values, "couponManualcode");
            return (Criteria) this;
        }

        public Criteria andCouponManualcodeNotIn(List<String> values) {
            addCriterion("coupon_manualCode not in", values, "couponManualcode");
            return (Criteria) this;
        }

        public Criteria andCouponManualcodeBetween(String value1, String value2) {
            addCriterion("coupon_manualCode between", value1, value2, "couponManualcode");
            return (Criteria) this;
        }

        public Criteria andCouponManualcodeNotBetween(String value1, String value2) {
            addCriterion("coupon_manualCode not between", value1, value2, "couponManualcode");
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