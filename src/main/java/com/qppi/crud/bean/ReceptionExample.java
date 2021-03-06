package com.qppi.crud.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReceptionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ReceptionExample() {
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

        public Criteria andCreateByIsNull() {
            addCriterion("create_by is null");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNotNull() {
            addCriterion("create_by is not null");
            return (Criteria) this;
        }

        public Criteria andCreateByEqualTo(String value) {
            addCriterion("create_by =", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotEqualTo(String value) {
            addCriterion("create_by <>", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThan(String value) {
            addCriterion("create_by >", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThanOrEqualTo(String value) {
            addCriterion("create_by >=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThan(String value) {
            addCriterion("create_by <", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThanOrEqualTo(String value) {
            addCriterion("create_by <=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLike(String value) {
            addCriterion("create_by like", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotLike(String value) {
            addCriterion("create_by not like", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByIn(List<String> values) {
            addCriterion("create_by in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotIn(List<String> values) {
            addCriterion("create_by not in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByBetween(String value1, String value2) {
            addCriterion("create_by between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotBetween(String value1, String value2) {
            addCriterion("create_by not between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andUpdateByIsNull() {
            addCriterion("update_by is null");
            return (Criteria) this;
        }

        public Criteria andUpdateByIsNotNull() {
            addCriterion("update_by is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateByEqualTo(String value) {
            addCriterion("update_by =", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotEqualTo(String value) {
            addCriterion("update_by <>", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThan(String value) {
            addCriterion("update_by >", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThanOrEqualTo(String value) {
            addCriterion("update_by >=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThan(String value) {
            addCriterion("update_by <", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThanOrEqualTo(String value) {
            addCriterion("update_by <=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLike(String value) {
            addCriterion("update_by like", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotLike(String value) {
            addCriterion("update_by not like", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByIn(List<String> values) {
            addCriterion("update_by in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotIn(List<String> values) {
            addCriterion("update_by not in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByBetween(String value1, String value2) {
            addCriterion("update_by between", value1, value2, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotBetween(String value1, String value2) {
            addCriterion("update_by not between", value1, value2, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNull() {
            addCriterion("update_date is null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNotNull() {
            addCriterion("update_date is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateEqualTo(Date value) {
            addCriterion("update_date =", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotEqualTo(Date value) {
            addCriterion("update_date <>", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThan(Date value) {
            addCriterion("update_date >", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("update_date >=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThan(Date value) {
            addCriterion("update_date <", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThanOrEqualTo(Date value) {
            addCriterion("update_date <=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIn(List<Date> values) {
            addCriterion("update_date in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotIn(List<Date> values) {
            addCriterion("update_date not in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateBetween(Date value1, Date value2) {
            addCriterion("update_date between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotBetween(Date value1, Date value2) {
            addCriterion("update_date not between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andDelFlagIsNull() {
            addCriterion("del_flag is null");
            return (Criteria) this;
        }

        public Criteria andDelFlagIsNotNull() {
            addCriterion("del_flag is not null");
            return (Criteria) this;
        }

        public Criteria andDelFlagEqualTo(String value) {
            addCriterion("del_flag =", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotEqualTo(String value) {
            addCriterion("del_flag <>", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagGreaterThan(String value) {
            addCriterion("del_flag >", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagGreaterThanOrEqualTo(String value) {
            addCriterion("del_flag >=", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLessThan(String value) {
            addCriterion("del_flag <", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLessThanOrEqualTo(String value) {
            addCriterion("del_flag <=", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLike(String value) {
            addCriterion("del_flag like", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotLike(String value) {
            addCriterion("del_flag not like", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagIn(List<String> values) {
            addCriterion("del_flag in", values, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotIn(List<String> values) {
            addCriterion("del_flag not in", values, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagBetween(String value1, String value2) {
            addCriterion("del_flag between", value1, value2, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotBetween(String value1, String value2) {
            addCriterion("del_flag not between", value1, value2, "delFlag");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(String value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(String value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(String value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(String value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(String value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLike(String value) {
            addCriterion("order_id like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotLike(String value) {
            addCriterion("order_id not like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<String> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<String> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(String value1, String value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(String value1, String value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andSerIdIsNull() {
            addCriterion("ser_id is null");
            return (Criteria) this;
        }

        public Criteria andSerIdIsNotNull() {
            addCriterion("ser_id is not null");
            return (Criteria) this;
        }

        public Criteria andSerIdEqualTo(String value) {
            addCriterion("ser_id =", value, "serId");
            return (Criteria) this;
        }

        public Criteria andSerIdNotEqualTo(String value) {
            addCriterion("ser_id <>", value, "serId");
            return (Criteria) this;
        }

        public Criteria andSerIdGreaterThan(String value) {
            addCriterion("ser_id >", value, "serId");
            return (Criteria) this;
        }

        public Criteria andSerIdGreaterThanOrEqualTo(String value) {
            addCriterion("ser_id >=", value, "serId");
            return (Criteria) this;
        }

        public Criteria andSerIdLessThan(String value) {
            addCriterion("ser_id <", value, "serId");
            return (Criteria) this;
        }

        public Criteria andSerIdLessThanOrEqualTo(String value) {
            addCriterion("ser_id <=", value, "serId");
            return (Criteria) this;
        }

        public Criteria andSerIdLike(String value) {
            addCriterion("ser_id like", value, "serId");
            return (Criteria) this;
        }

        public Criteria andSerIdNotLike(String value) {
            addCriterion("ser_id not like", value, "serId");
            return (Criteria) this;
        }

        public Criteria andSerIdIn(List<String> values) {
            addCriterion("ser_id in", values, "serId");
            return (Criteria) this;
        }

        public Criteria andSerIdNotIn(List<String> values) {
            addCriterion("ser_id not in", values, "serId");
            return (Criteria) this;
        }

        public Criteria andSerIdBetween(String value1, String value2) {
            addCriterion("ser_id between", value1, value2, "serId");
            return (Criteria) this;
        }

        public Criteria andSerIdNotBetween(String value1, String value2) {
            addCriterion("ser_id not between", value1, value2, "serId");
            return (Criteria) this;
        }

        public Criteria andCarLcIsNull() {
            addCriterion("car_lc is null");
            return (Criteria) this;
        }

        public Criteria andCarLcIsNotNull() {
            addCriterion("car_lc is not null");
            return (Criteria) this;
        }

        public Criteria andCarLcEqualTo(String value) {
            addCriterion("car_lc =", value, "carLc");
            return (Criteria) this;
        }

        public Criteria andCarLcNotEqualTo(String value) {
            addCriterion("car_lc <>", value, "carLc");
            return (Criteria) this;
        }

        public Criteria andCarLcGreaterThan(String value) {
            addCriterion("car_lc >", value, "carLc");
            return (Criteria) this;
        }

        public Criteria andCarLcGreaterThanOrEqualTo(String value) {
            addCriterion("car_lc >=", value, "carLc");
            return (Criteria) this;
        }

        public Criteria andCarLcLessThan(String value) {
            addCriterion("car_lc <", value, "carLc");
            return (Criteria) this;
        }

        public Criteria andCarLcLessThanOrEqualTo(String value) {
            addCriterion("car_lc <=", value, "carLc");
            return (Criteria) this;
        }

        public Criteria andCarLcLike(String value) {
            addCriterion("car_lc like", value, "carLc");
            return (Criteria) this;
        }

        public Criteria andCarLcNotLike(String value) {
            addCriterion("car_lc not like", value, "carLc");
            return (Criteria) this;
        }

        public Criteria andCarLcIn(List<String> values) {
            addCriterion("car_lc in", values, "carLc");
            return (Criteria) this;
        }

        public Criteria andCarLcNotIn(List<String> values) {
            addCriterion("car_lc not in", values, "carLc");
            return (Criteria) this;
        }

        public Criteria andCarLcBetween(String value1, String value2) {
            addCriterion("car_lc between", value1, value2, "carLc");
            return (Criteria) this;
        }

        public Criteria andCarLcNotBetween(String value1, String value2) {
            addCriterion("car_lc not between", value1, value2, "carLc");
            return (Criteria) this;
        }

        public Criteria andRecheckIdIsNull() {
            addCriterion("recheck_id is null");
            return (Criteria) this;
        }

        public Criteria andRecheckIdIsNotNull() {
            addCriterion("recheck_id is not null");
            return (Criteria) this;
        }

        public Criteria andRecheckIdEqualTo(String value) {
            addCriterion("recheck_id =", value, "recheckId");
            return (Criteria) this;
        }

        public Criteria andRecheckIdNotEqualTo(String value) {
            addCriterion("recheck_id <>", value, "recheckId");
            return (Criteria) this;
        }

        public Criteria andRecheckIdGreaterThan(String value) {
            addCriterion("recheck_id >", value, "recheckId");
            return (Criteria) this;
        }

        public Criteria andRecheckIdGreaterThanOrEqualTo(String value) {
            addCriterion("recheck_id >=", value, "recheckId");
            return (Criteria) this;
        }

        public Criteria andRecheckIdLessThan(String value) {
            addCriterion("recheck_id <", value, "recheckId");
            return (Criteria) this;
        }

        public Criteria andRecheckIdLessThanOrEqualTo(String value) {
            addCriterion("recheck_id <=", value, "recheckId");
            return (Criteria) this;
        }

        public Criteria andRecheckIdLike(String value) {
            addCriterion("recheck_id like", value, "recheckId");
            return (Criteria) this;
        }

        public Criteria andRecheckIdNotLike(String value) {
            addCriterion("recheck_id not like", value, "recheckId");
            return (Criteria) this;
        }

        public Criteria andRecheckIdIn(List<String> values) {
            addCriterion("recheck_id in", values, "recheckId");
            return (Criteria) this;
        }

        public Criteria andRecheckIdNotIn(List<String> values) {
            addCriterion("recheck_id not in", values, "recheckId");
            return (Criteria) this;
        }

        public Criteria andRecheckIdBetween(String value1, String value2) {
            addCriterion("recheck_id between", value1, value2, "recheckId");
            return (Criteria) this;
        }

        public Criteria andRecheckIdNotBetween(String value1, String value2) {
            addCriterion("recheck_id not between", value1, value2, "recheckId");
            return (Criteria) this;
        }

        public Criteria andTimeInIsNull() {
            addCriterion("time_in is null");
            return (Criteria) this;
        }

        public Criteria andTimeInIsNotNull() {
            addCriterion("time_in is not null");
            return (Criteria) this;
        }

        public Criteria andTimeInEqualTo(Date value) {
            addCriterion("time_in =", value, "timeIn");
            return (Criteria) this;
        }

        public Criteria andTimeInNotEqualTo(Date value) {
            addCriterion("time_in <>", value, "timeIn");
            return (Criteria) this;
        }

        public Criteria andTimeInGreaterThan(Date value) {
            addCriterion("time_in >", value, "timeIn");
            return (Criteria) this;
        }

        public Criteria andTimeInGreaterThanOrEqualTo(Date value) {
            addCriterion("time_in >=", value, "timeIn");
            return (Criteria) this;
        }

        public Criteria andTimeInLessThan(Date value) {
            addCriterion("time_in <", value, "timeIn");
            return (Criteria) this;
        }

        public Criteria andTimeInLessThanOrEqualTo(Date value) {
            addCriterion("time_in <=", value, "timeIn");
            return (Criteria) this;
        }

        public Criteria andTimeInIn(List<Date> values) {
            addCriterion("time_in in", values, "timeIn");
            return (Criteria) this;
        }

        public Criteria andTimeInNotIn(List<Date> values) {
            addCriterion("time_in not in", values, "timeIn");
            return (Criteria) this;
        }

        public Criteria andTimeInBetween(Date value1, Date value2) {
            addCriterion("time_in between", value1, value2, "timeIn");
            return (Criteria) this;
        }

        public Criteria andTimeInNotBetween(Date value1, Date value2) {
            addCriterion("time_in not between", value1, value2, "timeIn");
            return (Criteria) this;
        }

        public Criteria andIsAgreeIsNull() {
            addCriterion("is_agree is null");
            return (Criteria) this;
        }

        public Criteria andIsAgreeIsNotNull() {
            addCriterion("is_agree is not null");
            return (Criteria) this;
        }

        public Criteria andIsAgreeEqualTo(String value) {
            addCriterion("is_agree =", value, "isAgree");
            return (Criteria) this;
        }

        public Criteria andIsAgreeNotEqualTo(String value) {
            addCriterion("is_agree <>", value, "isAgree");
            return (Criteria) this;
        }

        public Criteria andIsAgreeGreaterThan(String value) {
            addCriterion("is_agree >", value, "isAgree");
            return (Criteria) this;
        }

        public Criteria andIsAgreeGreaterThanOrEqualTo(String value) {
            addCriterion("is_agree >=", value, "isAgree");
            return (Criteria) this;
        }

        public Criteria andIsAgreeLessThan(String value) {
            addCriterion("is_agree <", value, "isAgree");
            return (Criteria) this;
        }

        public Criteria andIsAgreeLessThanOrEqualTo(String value) {
            addCriterion("is_agree <=", value, "isAgree");
            return (Criteria) this;
        }

        public Criteria andIsAgreeLike(String value) {
            addCriterion("is_agree like", value, "isAgree");
            return (Criteria) this;
        }

        public Criteria andIsAgreeNotLike(String value) {
            addCriterion("is_agree not like", value, "isAgree");
            return (Criteria) this;
        }

        public Criteria andIsAgreeIn(List<String> values) {
            addCriterion("is_agree in", values, "isAgree");
            return (Criteria) this;
        }

        public Criteria andIsAgreeNotIn(List<String> values) {
            addCriterion("is_agree not in", values, "isAgree");
            return (Criteria) this;
        }

        public Criteria andIsAgreeBetween(String value1, String value2) {
            addCriterion("is_agree between", value1, value2, "isAgree");
            return (Criteria) this;
        }

        public Criteria andIsAgreeNotBetween(String value1, String value2) {
            addCriterion("is_agree not between", value1, value2, "isAgree");
            return (Criteria) this;
        }

        public Criteria andMemInfoIsNull() {
            addCriterion("mem_info is null");
            return (Criteria) this;
        }

        public Criteria andMemInfoIsNotNull() {
            addCriterion("mem_info is not null");
            return (Criteria) this;
        }

        public Criteria andMemInfoEqualTo(String value) {
            addCriterion("mem_info =", value, "memInfo");
            return (Criteria) this;
        }

        public Criteria andMemInfoNotEqualTo(String value) {
            addCriterion("mem_info <>", value, "memInfo");
            return (Criteria) this;
        }

        public Criteria andMemInfoGreaterThan(String value) {
            addCriterion("mem_info >", value, "memInfo");
            return (Criteria) this;
        }

        public Criteria andMemInfoGreaterThanOrEqualTo(String value) {
            addCriterion("mem_info >=", value, "memInfo");
            return (Criteria) this;
        }

        public Criteria andMemInfoLessThan(String value) {
            addCriterion("mem_info <", value, "memInfo");
            return (Criteria) this;
        }

        public Criteria andMemInfoLessThanOrEqualTo(String value) {
            addCriterion("mem_info <=", value, "memInfo");
            return (Criteria) this;
        }

        public Criteria andMemInfoLike(String value) {
            addCriterion("mem_info like", value, "memInfo");
            return (Criteria) this;
        }

        public Criteria andMemInfoNotLike(String value) {
            addCriterion("mem_info not like", value, "memInfo");
            return (Criteria) this;
        }

        public Criteria andMemInfoIn(List<String> values) {
            addCriterion("mem_info in", values, "memInfo");
            return (Criteria) this;
        }

        public Criteria andMemInfoNotIn(List<String> values) {
            addCriterion("mem_info not in", values, "memInfo");
            return (Criteria) this;
        }

        public Criteria andMemInfoBetween(String value1, String value2) {
            addCriterion("mem_info between", value1, value2, "memInfo");
            return (Criteria) this;
        }

        public Criteria andMemInfoNotBetween(String value1, String value2) {
            addCriterion("mem_info not between", value1, value2, "memInfo");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNull() {
            addCriterion("remarks is null");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNotNull() {
            addCriterion("remarks is not null");
            return (Criteria) this;
        }

        public Criteria andRemarksEqualTo(String value) {
            addCriterion("remarks =", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotEqualTo(String value) {
            addCriterion("remarks <>", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThan(String value) {
            addCriterion("remarks >", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("remarks >=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThan(String value) {
            addCriterion("remarks <", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThanOrEqualTo(String value) {
            addCriterion("remarks <=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLike(String value) {
            addCriterion("remarks like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotLike(String value) {
            addCriterion("remarks not like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksIn(List<String> values) {
            addCriterion("remarks in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotIn(List<String> values) {
            addCriterion("remarks not in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksBetween(String value1, String value2) {
            addCriterion("remarks between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotBetween(String value1, String value2) {
            addCriterion("remarks not between", value1, value2, "remarks");
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