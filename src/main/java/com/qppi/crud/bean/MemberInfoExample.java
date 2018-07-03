package com.qppi.crud.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MemberInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MemberInfoExample() {
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

        public Criteria andMemAccountIsNull() {
            addCriterion("mem_account is null");
            return (Criteria) this;
        }

        public Criteria andMemAccountIsNotNull() {
            addCriterion("mem_account is not null");
            return (Criteria) this;
        }

        public Criteria andMemAccountEqualTo(String value) {
            addCriterion("mem_account =", value, "memAccount");
            return (Criteria) this;
        }

        public Criteria andMemAccountNotEqualTo(String value) {
            addCriterion("mem_account <>", value, "memAccount");
            return (Criteria) this;
        }

        public Criteria andMemAccountGreaterThan(String value) {
            addCriterion("mem_account >", value, "memAccount");
            return (Criteria) this;
        }

        public Criteria andMemAccountGreaterThanOrEqualTo(String value) {
            addCriterion("mem_account >=", value, "memAccount");
            return (Criteria) this;
        }

        public Criteria andMemAccountLessThan(String value) {
            addCriterion("mem_account <", value, "memAccount");
            return (Criteria) this;
        }

        public Criteria andMemAccountLessThanOrEqualTo(String value) {
            addCriterion("mem_account <=", value, "memAccount");
            return (Criteria) this;
        }

        public Criteria andMemAccountLike(String value) {
            addCriterion("mem_account like", value, "memAccount");
            return (Criteria) this;
        }

        public Criteria andMemAccountNotLike(String value) {
            addCriterion("mem_account not like", value, "memAccount");
            return (Criteria) this;
        }

        public Criteria andMemAccountIn(List<String> values) {
            addCriterion("mem_account in", values, "memAccount");
            return (Criteria) this;
        }

        public Criteria andMemAccountNotIn(List<String> values) {
            addCriterion("mem_account not in", values, "memAccount");
            return (Criteria) this;
        }

        public Criteria andMemAccountBetween(String value1, String value2) {
            addCriterion("mem_account between", value1, value2, "memAccount");
            return (Criteria) this;
        }

        public Criteria andMemAccountNotBetween(String value1, String value2) {
            addCriterion("mem_account not between", value1, value2, "memAccount");
            return (Criteria) this;
        }

        public Criteria andMemPasswordIsNull() {
            addCriterion("mem_password is null");
            return (Criteria) this;
        }

        public Criteria andMemPasswordIsNotNull() {
            addCriterion("mem_password is not null");
            return (Criteria) this;
        }

        public Criteria andMemPasswordEqualTo(String value) {
            addCriterion("mem_password =", value, "memPassword");
            return (Criteria) this;
        }

        public Criteria andMemPasswordNotEqualTo(String value) {
            addCriterion("mem_password <>", value, "memPassword");
            return (Criteria) this;
        }

        public Criteria andMemPasswordGreaterThan(String value) {
            addCriterion("mem_password >", value, "memPassword");
            return (Criteria) this;
        }

        public Criteria andMemPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("mem_password >=", value, "memPassword");
            return (Criteria) this;
        }

        public Criteria andMemPasswordLessThan(String value) {
            addCriterion("mem_password <", value, "memPassword");
            return (Criteria) this;
        }

        public Criteria andMemPasswordLessThanOrEqualTo(String value) {
            addCriterion("mem_password <=", value, "memPassword");
            return (Criteria) this;
        }

        public Criteria andMemPasswordLike(String value) {
            addCriterion("mem_password like", value, "memPassword");
            return (Criteria) this;
        }

        public Criteria andMemPasswordNotLike(String value) {
            addCriterion("mem_password not like", value, "memPassword");
            return (Criteria) this;
        }

        public Criteria andMemPasswordIn(List<String> values) {
            addCriterion("mem_password in", values, "memPassword");
            return (Criteria) this;
        }

        public Criteria andMemPasswordNotIn(List<String> values) {
            addCriterion("mem_password not in", values, "memPassword");
            return (Criteria) this;
        }

        public Criteria andMemPasswordBetween(String value1, String value2) {
            addCriterion("mem_password between", value1, value2, "memPassword");
            return (Criteria) this;
        }

        public Criteria andMemPasswordNotBetween(String value1, String value2) {
            addCriterion("mem_password not between", value1, value2, "memPassword");
            return (Criteria) this;
        }

        public Criteria andMemNameIsNull() {
            addCriterion("mem_name is null");
            return (Criteria) this;
        }

        public Criteria andMemNameIsNotNull() {
            addCriterion("mem_name is not null");
            return (Criteria) this;
        }

        public Criteria andMemNameEqualTo(String value) {
            addCriterion("mem_name =", value, "memName");
            return (Criteria) this;
        }

        public Criteria andMemNameNotEqualTo(String value) {
            addCriterion("mem_name <>", value, "memName");
            return (Criteria) this;
        }

        public Criteria andMemNameGreaterThan(String value) {
            addCriterion("mem_name >", value, "memName");
            return (Criteria) this;
        }

        public Criteria andMemNameGreaterThanOrEqualTo(String value) {
            addCriterion("mem_name >=", value, "memName");
            return (Criteria) this;
        }

        public Criteria andMemNameLessThan(String value) {
            addCriterion("mem_name <", value, "memName");
            return (Criteria) this;
        }

        public Criteria andMemNameLessThanOrEqualTo(String value) {
            addCriterion("mem_name <=", value, "memName");
            return (Criteria) this;
        }

        public Criteria andMemNameLike(String value) {
            addCriterion("mem_name like", value, "memName");
            return (Criteria) this;
        }

        public Criteria andMemNameNotLike(String value) {
            addCriterion("mem_name not like", value, "memName");
            return (Criteria) this;
        }

        public Criteria andMemNameIn(List<String> values) {
            addCriterion("mem_name in", values, "memName");
            return (Criteria) this;
        }

        public Criteria andMemNameNotIn(List<String> values) {
            addCriterion("mem_name not in", values, "memName");
            return (Criteria) this;
        }

        public Criteria andMemNameBetween(String value1, String value2) {
            addCriterion("mem_name between", value1, value2, "memName");
            return (Criteria) this;
        }

        public Criteria andMemNameNotBetween(String value1, String value2) {
            addCriterion("mem_name not between", value1, value2, "memName");
            return (Criteria) this;
        }

        public Criteria andMemSexIsNull() {
            addCriterion("mem_sex is null");
            return (Criteria) this;
        }

        public Criteria andMemSexIsNotNull() {
            addCriterion("mem_sex is not null");
            return (Criteria) this;
        }

        public Criteria andMemSexEqualTo(String value) {
            addCriterion("mem_sex =", value, "memSex");
            return (Criteria) this;
        }

        public Criteria andMemSexNotEqualTo(String value) {
            addCriterion("mem_sex <>", value, "memSex");
            return (Criteria) this;
        }

        public Criteria andMemSexGreaterThan(String value) {
            addCriterion("mem_sex >", value, "memSex");
            return (Criteria) this;
        }

        public Criteria andMemSexGreaterThanOrEqualTo(String value) {
            addCriterion("mem_sex >=", value, "memSex");
            return (Criteria) this;
        }

        public Criteria andMemSexLessThan(String value) {
            addCriterion("mem_sex <", value, "memSex");
            return (Criteria) this;
        }

        public Criteria andMemSexLessThanOrEqualTo(String value) {
            addCriterion("mem_sex <=", value, "memSex");
            return (Criteria) this;
        }

        public Criteria andMemSexLike(String value) {
            addCriterion("mem_sex like", value, "memSex");
            return (Criteria) this;
        }

        public Criteria andMemSexNotLike(String value) {
            addCriterion("mem_sex not like", value, "memSex");
            return (Criteria) this;
        }

        public Criteria andMemSexIn(List<String> values) {
            addCriterion("mem_sex in", values, "memSex");
            return (Criteria) this;
        }

        public Criteria andMemSexNotIn(List<String> values) {
            addCriterion("mem_sex not in", values, "memSex");
            return (Criteria) this;
        }

        public Criteria andMemSexBetween(String value1, String value2) {
            addCriterion("mem_sex between", value1, value2, "memSex");
            return (Criteria) this;
        }

        public Criteria andMemSexNotBetween(String value1, String value2) {
            addCriterion("mem_sex not between", value1, value2, "memSex");
            return (Criteria) this;
        }

        public Criteria andMemNumIsNull() {
            addCriterion("mem_num is null");
            return (Criteria) this;
        }

        public Criteria andMemNumIsNotNull() {
            addCriterion("mem_num is not null");
            return (Criteria) this;
        }

        public Criteria andMemNumEqualTo(String value) {
            addCriterion("mem_num =", value, "memNum");
            return (Criteria) this;
        }

        public Criteria andMemNumNotEqualTo(String value) {
            addCriterion("mem_num <>", value, "memNum");
            return (Criteria) this;
        }

        public Criteria andMemNumGreaterThan(String value) {
            addCriterion("mem_num >", value, "memNum");
            return (Criteria) this;
        }

        public Criteria andMemNumGreaterThanOrEqualTo(String value) {
            addCriterion("mem_num >=", value, "memNum");
            return (Criteria) this;
        }

        public Criteria andMemNumLessThan(String value) {
            addCriterion("mem_num <", value, "memNum");
            return (Criteria) this;
        }

        public Criteria andMemNumLessThanOrEqualTo(String value) {
            addCriterion("mem_num <=", value, "memNum");
            return (Criteria) this;
        }

        public Criteria andMemNumLike(String value) {
            addCriterion("mem_num like", value, "memNum");
            return (Criteria) this;
        }

        public Criteria andMemNumNotLike(String value) {
            addCriterion("mem_num not like", value, "memNum");
            return (Criteria) this;
        }

        public Criteria andMemNumIn(List<String> values) {
            addCriterion("mem_num in", values, "memNum");
            return (Criteria) this;
        }

        public Criteria andMemNumNotIn(List<String> values) {
            addCriterion("mem_num not in", values, "memNum");
            return (Criteria) this;
        }

        public Criteria andMemNumBetween(String value1, String value2) {
            addCriterion("mem_num between", value1, value2, "memNum");
            return (Criteria) this;
        }

        public Criteria andMemNumNotBetween(String value1, String value2) {
            addCriterion("mem_num not between", value1, value2, "memNum");
            return (Criteria) this;
        }

        public Criteria andMemAddrIsNull() {
            addCriterion("mem_addr is null");
            return (Criteria) this;
        }

        public Criteria andMemAddrIsNotNull() {
            addCriterion("mem_addr is not null");
            return (Criteria) this;
        }

        public Criteria andMemAddrEqualTo(String value) {
            addCriterion("mem_addr =", value, "memAddr");
            return (Criteria) this;
        }

        public Criteria andMemAddrNotEqualTo(String value) {
            addCriterion("mem_addr <>", value, "memAddr");
            return (Criteria) this;
        }

        public Criteria andMemAddrGreaterThan(String value) {
            addCriterion("mem_addr >", value, "memAddr");
            return (Criteria) this;
        }

        public Criteria andMemAddrGreaterThanOrEqualTo(String value) {
            addCriterion("mem_addr >=", value, "memAddr");
            return (Criteria) this;
        }

        public Criteria andMemAddrLessThan(String value) {
            addCriterion("mem_addr <", value, "memAddr");
            return (Criteria) this;
        }

        public Criteria andMemAddrLessThanOrEqualTo(String value) {
            addCriterion("mem_addr <=", value, "memAddr");
            return (Criteria) this;
        }

        public Criteria andMemAddrLike(String value) {
            addCriterion("mem_addr like", value, "memAddr");
            return (Criteria) this;
        }

        public Criteria andMemAddrNotLike(String value) {
            addCriterion("mem_addr not like", value, "memAddr");
            return (Criteria) this;
        }

        public Criteria andMemAddrIn(List<String> values) {
            addCriterion("mem_addr in", values, "memAddr");
            return (Criteria) this;
        }

        public Criteria andMemAddrNotIn(List<String> values) {
            addCriterion("mem_addr not in", values, "memAddr");
            return (Criteria) this;
        }

        public Criteria andMemAddrBetween(String value1, String value2) {
            addCriterion("mem_addr between", value1, value2, "memAddr");
            return (Criteria) this;
        }

        public Criteria andMemAddrNotBetween(String value1, String value2) {
            addCriterion("mem_addr not between", value1, value2, "memAddr");
            return (Criteria) this;
        }

        public Criteria andMemEmailIsNull() {
            addCriterion("mem_email is null");
            return (Criteria) this;
        }

        public Criteria andMemEmailIsNotNull() {
            addCriterion("mem_email is not null");
            return (Criteria) this;
        }

        public Criteria andMemEmailEqualTo(String value) {
            addCriterion("mem_email =", value, "memEmail");
            return (Criteria) this;
        }

        public Criteria andMemEmailNotEqualTo(String value) {
            addCriterion("mem_email <>", value, "memEmail");
            return (Criteria) this;
        }

        public Criteria andMemEmailGreaterThan(String value) {
            addCriterion("mem_email >", value, "memEmail");
            return (Criteria) this;
        }

        public Criteria andMemEmailGreaterThanOrEqualTo(String value) {
            addCriterion("mem_email >=", value, "memEmail");
            return (Criteria) this;
        }

        public Criteria andMemEmailLessThan(String value) {
            addCriterion("mem_email <", value, "memEmail");
            return (Criteria) this;
        }

        public Criteria andMemEmailLessThanOrEqualTo(String value) {
            addCriterion("mem_email <=", value, "memEmail");
            return (Criteria) this;
        }

        public Criteria andMemEmailLike(String value) {
            addCriterion("mem_email like", value, "memEmail");
            return (Criteria) this;
        }

        public Criteria andMemEmailNotLike(String value) {
            addCriterion("mem_email not like", value, "memEmail");
            return (Criteria) this;
        }

        public Criteria andMemEmailIn(List<String> values) {
            addCriterion("mem_email in", values, "memEmail");
            return (Criteria) this;
        }

        public Criteria andMemEmailNotIn(List<String> values) {
            addCriterion("mem_email not in", values, "memEmail");
            return (Criteria) this;
        }

        public Criteria andMemEmailBetween(String value1, String value2) {
            addCriterion("mem_email between", value1, value2, "memEmail");
            return (Criteria) this;
        }

        public Criteria andMemEmailNotBetween(String value1, String value2) {
            addCriterion("mem_email not between", value1, value2, "memEmail");
            return (Criteria) this;
        }

        public Criteria andMemTelIsNull() {
            addCriterion("mem_tel is null");
            return (Criteria) this;
        }

        public Criteria andMemTelIsNotNull() {
            addCriterion("mem_tel is not null");
            return (Criteria) this;
        }

        public Criteria andMemTelEqualTo(String value) {
            addCriterion("mem_tel =", value, "memTel");
            return (Criteria) this;
        }

        public Criteria andMemTelNotEqualTo(String value) {
            addCriterion("mem_tel <>", value, "memTel");
            return (Criteria) this;
        }

        public Criteria andMemTelGreaterThan(String value) {
            addCriterion("mem_tel >", value, "memTel");
            return (Criteria) this;
        }

        public Criteria andMemTelGreaterThanOrEqualTo(String value) {
            addCriterion("mem_tel >=", value, "memTel");
            return (Criteria) this;
        }

        public Criteria andMemTelLessThan(String value) {
            addCriterion("mem_tel <", value, "memTel");
            return (Criteria) this;
        }

        public Criteria andMemTelLessThanOrEqualTo(String value) {
            addCriterion("mem_tel <=", value, "memTel");
            return (Criteria) this;
        }

        public Criteria andMemTelLike(String value) {
            addCriterion("mem_tel like", value, "memTel");
            return (Criteria) this;
        }

        public Criteria andMemTelNotLike(String value) {
            addCriterion("mem_tel not like", value, "memTel");
            return (Criteria) this;
        }

        public Criteria andMemTelIn(List<String> values) {
            addCriterion("mem_tel in", values, "memTel");
            return (Criteria) this;
        }

        public Criteria andMemTelNotIn(List<String> values) {
            addCriterion("mem_tel not in", values, "memTel");
            return (Criteria) this;
        }

        public Criteria andMemTelBetween(String value1, String value2) {
            addCriterion("mem_tel between", value1, value2, "memTel");
            return (Criteria) this;
        }

        public Criteria andMemTelNotBetween(String value1, String value2) {
            addCriterion("mem_tel not between", value1, value2, "memTel");
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

        public Criteria andCarIdIsNull() {
            addCriterion("car_id is null");
            return (Criteria) this;
        }

        public Criteria andCarIdIsNotNull() {
            addCriterion("car_id is not null");
            return (Criteria) this;
        }

        public Criteria andCarIdEqualTo(String value) {
            addCriterion("car_id =", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdNotEqualTo(String value) {
            addCriterion("car_id <>", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdGreaterThan(String value) {
            addCriterion("car_id >", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdGreaterThanOrEqualTo(String value) {
            addCriterion("car_id >=", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdLessThan(String value) {
            addCriterion("car_id <", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdLessThanOrEqualTo(String value) {
            addCriterion("car_id <=", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdLike(String value) {
            addCriterion("car_id like", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdNotLike(String value) {
            addCriterion("car_id not like", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdIn(List<String> values) {
            addCriterion("car_id in", values, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdNotIn(List<String> values) {
            addCriterion("car_id not in", values, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdBetween(String value1, String value2) {
            addCriterion("car_id between", value1, value2, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdNotBetween(String value1, String value2) {
            addCriterion("car_id not between", value1, value2, "carId");
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