/**
 *@author generator
 *@date 2019-12-11
 */
package com.dandelion.bean.example;

import java.util.ArrayList;
import java.util.List;

public class AuthorityExample {
    /**
     *  * authority
     */
    protected String orderByClause;

    /**
     *  * authority
     */
    protected boolean distinct;

    /**
     *  * authority
     */
    protected List<Criteria> oredCriteria;

    /**
     *自动生成方法
     */
    public AuthorityExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     *自动生成方法
     *@param orderByClause generator
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     *自动生成方法
     *@return java.lang.String
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     *自动生成方法
     *@param distinct generator
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     *自动生成方法
     *@return boolean
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     *自动生成方法
     *@return java.util.List<Criteria>
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     *自动生成方法
     *@param criteria generator
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     *自动生成方法
     *@return Criteria
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     *自动生成方法
     *@return Criteria
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     *自动生成方法
     *@return Criteria
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria(this);
        return criteria;
    }

    /**
     *自动生成方法
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     *自动生成方法
     *@param orderByClause generator
     *@return com.dandelion.bean.example.AuthorityExample
     */
    public AuthorityExample orderBy(String orderByClause) {
        this.setOrderByClause(orderByClause);
        return this;
    }

    /**
     *自动生成方法
     *@param orderByClauses generator
     *@return com.dandelion.bean.example.AuthorityExample
     */
    public AuthorityExample orderBy(String ... orderByClauses) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < orderByClauses.length; i++) {
            sb.append(orderByClauses[i]);
            if (i < orderByClauses.length - 1) {
                sb.append(" , ");
            }
        }
        this.setOrderByClause(sb.toString());
        return this;
    }

    /**
     * authority 2019-12-11
     */
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

        public Criteria andAuthorityIdIsNull() {
            addCriterion("authority_id is null");
            return (Criteria) this;
        }

        public Criteria andAuthorityIdIsNotNull() {
            addCriterion("authority_id is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorityIdEqualTo(Integer value) {
            addCriterion("authority_id =", value, "authorityId");
            return (Criteria) this;
        }

        public Criteria andAuthorityIdNotEqualTo(Integer value) {
            addCriterion("authority_id <>", value, "authorityId");
            return (Criteria) this;
        }

        public Criteria andAuthorityIdGreaterThan(Integer value) {
            addCriterion("authority_id >", value, "authorityId");
            return (Criteria) this;
        }

        public Criteria andAuthorityIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("authority_id >=", value, "authorityId");
            return (Criteria) this;
        }

        public Criteria andAuthorityIdLessThan(Integer value) {
            addCriterion("authority_id <", value, "authorityId");
            return (Criteria) this;
        }

        public Criteria andAuthorityIdLessThanOrEqualTo(Integer value) {
            addCriterion("authority_id <=", value, "authorityId");
            return (Criteria) this;
        }

        public Criteria andAuthorityIdIn(List<Integer> values) {
            addCriterion("authority_id in", values, "authorityId");
            return (Criteria) this;
        }

        public Criteria andAuthorityIdNotIn(List<Integer> values) {
            addCriterion("authority_id not in", values, "authorityId");
            return (Criteria) this;
        }

        public Criteria andAuthorityIdBetween(Integer value1, Integer value2) {
            addCriterion("authority_id between", value1, value2, "authorityId");
            return (Criteria) this;
        }

        public Criteria andAuthorityIdNotBetween(Integer value1, Integer value2) {
            addCriterion("authority_id not between", value1, value2, "authorityId");
            return (Criteria) this;
        }

        public Criteria andAuthorityNameIsNull() {
            addCriterion("authority_name is null");
            return (Criteria) this;
        }

        public Criteria andAuthorityNameIsNotNull() {
            addCriterion("authority_name is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorityNameEqualTo(String value) {
            addCriterion("authority_name =", value, "authorityName");
            return (Criteria) this;
        }

        public Criteria andAuthorityNameNotEqualTo(String value) {
            addCriterion("authority_name <>", value, "authorityName");
            return (Criteria) this;
        }

        public Criteria andAuthorityNameGreaterThan(String value) {
            addCriterion("authority_name >", value, "authorityName");
            return (Criteria) this;
        }

        public Criteria andAuthorityNameGreaterThanOrEqualTo(String value) {
            addCriterion("authority_name >=", value, "authorityName");
            return (Criteria) this;
        }

        public Criteria andAuthorityNameLessThan(String value) {
            addCriterion("authority_name <", value, "authorityName");
            return (Criteria) this;
        }

        public Criteria andAuthorityNameLessThanOrEqualTo(String value) {
            addCriterion("authority_name <=", value, "authorityName");
            return (Criteria) this;
        }

        public Criteria andAuthorityNameLike(String value) {
            addCriterion("authority_name like", value, "authorityName");
            return (Criteria) this;
        }

        public Criteria andAuthorityNameNotLike(String value) {
            addCriterion("authority_name not like", value, "authorityName");
            return (Criteria) this;
        }

        public Criteria andAuthorityNameIn(List<String> values) {
            addCriterion("authority_name in", values, "authorityName");
            return (Criteria) this;
        }

        public Criteria andAuthorityNameNotIn(List<String> values) {
            addCriterion("authority_name not in", values, "authorityName");
            return (Criteria) this;
        }

        public Criteria andAuthorityNameBetween(String value1, String value2) {
            addCriterion("authority_name between", value1, value2, "authorityName");
            return (Criteria) this;
        }

        public Criteria andAuthorityNameNotBetween(String value1, String value2) {
            addCriterion("authority_name not between", value1, value2, "authorityName");
            return (Criteria) this;
        }

        public Criteria andAuthorityUrlIsNull() {
            addCriterion("authority_url is null");
            return (Criteria) this;
        }

        public Criteria andAuthorityUrlIsNotNull() {
            addCriterion("authority_url is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorityUrlEqualTo(String value) {
            addCriterion("authority_url =", value, "authorityUrl");
            return (Criteria) this;
        }

        public Criteria andAuthorityUrlNotEqualTo(String value) {
            addCriterion("authority_url <>", value, "authorityUrl");
            return (Criteria) this;
        }

        public Criteria andAuthorityUrlGreaterThan(String value) {
            addCriterion("authority_url >", value, "authorityUrl");
            return (Criteria) this;
        }

        public Criteria andAuthorityUrlGreaterThanOrEqualTo(String value) {
            addCriterion("authority_url >=", value, "authorityUrl");
            return (Criteria) this;
        }

        public Criteria andAuthorityUrlLessThan(String value) {
            addCriterion("authority_url <", value, "authorityUrl");
            return (Criteria) this;
        }

        public Criteria andAuthorityUrlLessThanOrEqualTo(String value) {
            addCriterion("authority_url <=", value, "authorityUrl");
            return (Criteria) this;
        }

        public Criteria andAuthorityUrlLike(String value) {
            addCriterion("authority_url like", value, "authorityUrl");
            return (Criteria) this;
        }

        public Criteria andAuthorityUrlNotLike(String value) {
            addCriterion("authority_url not like", value, "authorityUrl");
            return (Criteria) this;
        }

        public Criteria andAuthorityUrlIn(List<String> values) {
            addCriterion("authority_url in", values, "authorityUrl");
            return (Criteria) this;
        }

        public Criteria andAuthorityUrlNotIn(List<String> values) {
            addCriterion("authority_url not in", values, "authorityUrl");
            return (Criteria) this;
        }

        public Criteria andAuthorityUrlBetween(String value1, String value2) {
            addCriterion("authority_url between", value1, value2, "authorityUrl");
            return (Criteria) this;
        }

        public Criteria andAuthorityUrlNotBetween(String value1, String value2) {
            addCriterion("authority_url not between", value1, value2, "authorityUrl");
            return (Criteria) this;
        }

        public Criteria andAuthorityIconIsNull() {
            addCriterion("authority_icon is null");
            return (Criteria) this;
        }

        public Criteria andAuthorityIconIsNotNull() {
            addCriterion("authority_icon is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorityIconEqualTo(String value) {
            addCriterion("authority_icon =", value, "authorityIcon");
            return (Criteria) this;
        }

        public Criteria andAuthorityIconNotEqualTo(String value) {
            addCriterion("authority_icon <>", value, "authorityIcon");
            return (Criteria) this;
        }

        public Criteria andAuthorityIconGreaterThan(String value) {
            addCriterion("authority_icon >", value, "authorityIcon");
            return (Criteria) this;
        }

        public Criteria andAuthorityIconGreaterThanOrEqualTo(String value) {
            addCriterion("authority_icon >=", value, "authorityIcon");
            return (Criteria) this;
        }

        public Criteria andAuthorityIconLessThan(String value) {
            addCriterion("authority_icon <", value, "authorityIcon");
            return (Criteria) this;
        }

        public Criteria andAuthorityIconLessThanOrEqualTo(String value) {
            addCriterion("authority_icon <=", value, "authorityIcon");
            return (Criteria) this;
        }

        public Criteria andAuthorityIconLike(String value) {
            addCriterion("authority_icon like", value, "authorityIcon");
            return (Criteria) this;
        }

        public Criteria andAuthorityIconNotLike(String value) {
            addCriterion("authority_icon not like", value, "authorityIcon");
            return (Criteria) this;
        }

        public Criteria andAuthorityIconIn(List<String> values) {
            addCriterion("authority_icon in", values, "authorityIcon");
            return (Criteria) this;
        }

        public Criteria andAuthorityIconNotIn(List<String> values) {
            addCriterion("authority_icon not in", values, "authorityIcon");
            return (Criteria) this;
        }

        public Criteria andAuthorityIconBetween(String value1, String value2) {
            addCriterion("authority_icon between", value1, value2, "authorityIcon");
            return (Criteria) this;
        }

        public Criteria andAuthorityIconNotBetween(String value1, String value2) {
            addCriterion("authority_icon not between", value1, value2, "authorityIcon");
            return (Criteria) this;
        }

        public Criteria andAuthorityIdentifierIsNull() {
            addCriterion("authority_identifier is null");
            return (Criteria) this;
        }

        public Criteria andAuthorityIdentifierIsNotNull() {
            addCriterion("authority_identifier is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorityIdentifierEqualTo(Integer value) {
            addCriterion("authority_identifier =", value, "authorityIdentifier");
            return (Criteria) this;
        }

        public Criteria andAuthorityIdentifierNotEqualTo(Integer value) {
            addCriterion("authority_identifier <>", value, "authorityIdentifier");
            return (Criteria) this;
        }

        public Criteria andAuthorityIdentifierGreaterThan(Integer value) {
            addCriterion("authority_identifier >", value, "authorityIdentifier");
            return (Criteria) this;
        }

        public Criteria andAuthorityIdentifierGreaterThanOrEqualTo(Integer value) {
            addCriterion("authority_identifier >=", value, "authorityIdentifier");
            return (Criteria) this;
        }

        public Criteria andAuthorityIdentifierLessThan(Integer value) {
            addCriterion("authority_identifier <", value, "authorityIdentifier");
            return (Criteria) this;
        }

        public Criteria andAuthorityIdentifierLessThanOrEqualTo(Integer value) {
            addCriterion("authority_identifier <=", value, "authorityIdentifier");
            return (Criteria) this;
        }

        public Criteria andAuthorityIdentifierIn(List<Integer> values) {
            addCriterion("authority_identifier in", values, "authorityIdentifier");
            return (Criteria) this;
        }

        public Criteria andAuthorityIdentifierNotIn(List<Integer> values) {
            addCriterion("authority_identifier not in", values, "authorityIdentifier");
            return (Criteria) this;
        }

        public Criteria andAuthorityIdentifierBetween(Integer value1, Integer value2) {
            addCriterion("authority_identifier between", value1, value2, "authorityIdentifier");
            return (Criteria) this;
        }

        public Criteria andAuthorityIdentifierNotBetween(Integer value1, Integer value2) {
            addCriterion("authority_identifier not between", value1, value2, "authorityIdentifier");
            return (Criteria) this;
        }

        public Criteria andAuthorityLevelIsNull() {
            addCriterion("authority_level is null");
            return (Criteria) this;
        }

        public Criteria andAuthorityLevelIsNotNull() {
            addCriterion("authority_level is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorityLevelEqualTo(Integer value) {
            addCriterion("authority_level =", value, "authorityLevel");
            return (Criteria) this;
        }

        public Criteria andAuthorityLevelNotEqualTo(Integer value) {
            addCriterion("authority_level <>", value, "authorityLevel");
            return (Criteria) this;
        }

        public Criteria andAuthorityLevelGreaterThan(Integer value) {
            addCriterion("authority_level >", value, "authorityLevel");
            return (Criteria) this;
        }

        public Criteria andAuthorityLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("authority_level >=", value, "authorityLevel");
            return (Criteria) this;
        }

        public Criteria andAuthorityLevelLessThan(Integer value) {
            addCriterion("authority_level <", value, "authorityLevel");
            return (Criteria) this;
        }

        public Criteria andAuthorityLevelLessThanOrEqualTo(Integer value) {
            addCriterion("authority_level <=", value, "authorityLevel");
            return (Criteria) this;
        }

        public Criteria andAuthorityLevelIn(List<Integer> values) {
            addCriterion("authority_level in", values, "authorityLevel");
            return (Criteria) this;
        }

        public Criteria andAuthorityLevelNotIn(List<Integer> values) {
            addCriterion("authority_level not in", values, "authorityLevel");
            return (Criteria) this;
        }

        public Criteria andAuthorityLevelBetween(Integer value1, Integer value2) {
            addCriterion("authority_level between", value1, value2, "authorityLevel");
            return (Criteria) this;
        }

        public Criteria andAuthorityLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("authority_level not between", value1, value2, "authorityLevel");
            return (Criteria) this;
        }

        public Criteria andParentAuthorityIdIsNull() {
            addCriterion("parent_authority_id is null");
            return (Criteria) this;
        }

        public Criteria andParentAuthorityIdIsNotNull() {
            addCriterion("parent_authority_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentAuthorityIdEqualTo(Integer value) {
            addCriterion("parent_authority_id =", value, "parentAuthorityId");
            return (Criteria) this;
        }

        public Criteria andParentAuthorityIdNotEqualTo(Integer value) {
            addCriterion("parent_authority_id <>", value, "parentAuthorityId");
            return (Criteria) this;
        }

        public Criteria andParentAuthorityIdGreaterThan(Integer value) {
            addCriterion("parent_authority_id >", value, "parentAuthorityId");
            return (Criteria) this;
        }

        public Criteria andParentAuthorityIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("parent_authority_id >=", value, "parentAuthorityId");
            return (Criteria) this;
        }

        public Criteria andParentAuthorityIdLessThan(Integer value) {
            addCriterion("parent_authority_id <", value, "parentAuthorityId");
            return (Criteria) this;
        }

        public Criteria andParentAuthorityIdLessThanOrEqualTo(Integer value) {
            addCriterion("parent_authority_id <=", value, "parentAuthorityId");
            return (Criteria) this;
        }

        public Criteria andParentAuthorityIdIn(List<Integer> values) {
            addCriterion("parent_authority_id in", values, "parentAuthorityId");
            return (Criteria) this;
        }

        public Criteria andParentAuthorityIdNotIn(List<Integer> values) {
            addCriterion("parent_authority_id not in", values, "parentAuthorityId");
            return (Criteria) this;
        }

        public Criteria andParentAuthorityIdBetween(Integer value1, Integer value2) {
            addCriterion("parent_authority_id between", value1, value2, "parentAuthorityId");
            return (Criteria) this;
        }

        public Criteria andParentAuthorityIdNotBetween(Integer value1, Integer value2) {
            addCriterion("parent_authority_id not between", value1, value2, "parentAuthorityId");
            return (Criteria) this;
        }

        public Criteria andAuthorityStatusIsNull() {
            addCriterion("authority_status is null");
            return (Criteria) this;
        }

        public Criteria andAuthorityStatusIsNotNull() {
            addCriterion("authority_status is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorityStatusEqualTo(Integer value) {
            addCriterion("authority_status =", value, "authorityStatus");
            return (Criteria) this;
        }

        public Criteria andAuthorityStatusNotEqualTo(Integer value) {
            addCriterion("authority_status <>", value, "authorityStatus");
            return (Criteria) this;
        }

        public Criteria andAuthorityStatusGreaterThan(Integer value) {
            addCriterion("authority_status >", value, "authorityStatus");
            return (Criteria) this;
        }

        public Criteria andAuthorityStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("authority_status >=", value, "authorityStatus");
            return (Criteria) this;
        }

        public Criteria andAuthorityStatusLessThan(Integer value) {
            addCriterion("authority_status <", value, "authorityStatus");
            return (Criteria) this;
        }

        public Criteria andAuthorityStatusLessThanOrEqualTo(Integer value) {
            addCriterion("authority_status <=", value, "authorityStatus");
            return (Criteria) this;
        }

        public Criteria andAuthorityStatusIn(List<Integer> values) {
            addCriterion("authority_status in", values, "authorityStatus");
            return (Criteria) this;
        }

        public Criteria andAuthorityStatusNotIn(List<Integer> values) {
            addCriterion("authority_status not in", values, "authorityStatus");
            return (Criteria) this;
        }

        public Criteria andAuthorityStatusBetween(Integer value1, Integer value2) {
            addCriterion("authority_status between", value1, value2, "authorityStatus");
            return (Criteria) this;
        }

        public Criteria andAuthorityStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("authority_status not between", value1, value2, "authorityStatus");
            return (Criteria) this;
        }

        public Criteria andAuthorityTypeIsNull() {
            addCriterion("authority_type is null");
            return (Criteria) this;
        }

        public Criteria andAuthorityTypeIsNotNull() {
            addCriterion("authority_type is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorityTypeEqualTo(Integer value) {
            addCriterion("authority_type =", value, "authorityType");
            return (Criteria) this;
        }

        public Criteria andAuthorityTypeNotEqualTo(Integer value) {
            addCriterion("authority_type <>", value, "authorityType");
            return (Criteria) this;
        }

        public Criteria andAuthorityTypeGreaterThan(Integer value) {
            addCriterion("authority_type >", value, "authorityType");
            return (Criteria) this;
        }

        public Criteria andAuthorityTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("authority_type >=", value, "authorityType");
            return (Criteria) this;
        }

        public Criteria andAuthorityTypeLessThan(Integer value) {
            addCriterion("authority_type <", value, "authorityType");
            return (Criteria) this;
        }

        public Criteria andAuthorityTypeLessThanOrEqualTo(Integer value) {
            addCriterion("authority_type <=", value, "authorityType");
            return (Criteria) this;
        }

        public Criteria andAuthorityTypeIn(List<Integer> values) {
            addCriterion("authority_type in", values, "authorityType");
            return (Criteria) this;
        }

        public Criteria andAuthorityTypeNotIn(List<Integer> values) {
            addCriterion("authority_type not in", values, "authorityType");
            return (Criteria) this;
        }

        public Criteria andAuthorityTypeBetween(Integer value1, Integer value2) {
            addCriterion("authority_type between", value1, value2, "authorityType");
            return (Criteria) this;
        }

        public Criteria andAuthorityTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("authority_type not between", value1, value2, "authorityType");
            return (Criteria) this;
        }

        public Criteria andCreateIdIsNull() {
            addCriterion("create_id is null");
            return (Criteria) this;
        }

        public Criteria andCreateIdIsNotNull() {
            addCriterion("create_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreateIdEqualTo(Integer value) {
            addCriterion("create_id =", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdNotEqualTo(Integer value) {
            addCriterion("create_id <>", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdGreaterThan(Integer value) {
            addCriterion("create_id >", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("create_id >=", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdLessThan(Integer value) {
            addCriterion("create_id <", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdLessThanOrEqualTo(Integer value) {
            addCriterion("create_id <=", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdIn(List<Integer> values) {
            addCriterion("create_id in", values, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdNotIn(List<Integer> values) {
            addCriterion("create_id not in", values, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdBetween(Integer value1, Integer value2) {
            addCriterion("create_id between", value1, value2, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdNotBetween(Integer value1, Integer value2) {
            addCriterion("create_id not between", value1, value2, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateNameIsNull() {
            addCriterion("create_name is null");
            return (Criteria) this;
        }

        public Criteria andCreateNameIsNotNull() {
            addCriterion("create_name is not null");
            return (Criteria) this;
        }

        public Criteria andCreateNameEqualTo(String value) {
            addCriterion("create_name =", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameNotEqualTo(String value) {
            addCriterion("create_name <>", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameGreaterThan(String value) {
            addCriterion("create_name >", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameGreaterThanOrEqualTo(String value) {
            addCriterion("create_name >=", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameLessThan(String value) {
            addCriterion("create_name <", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameLessThanOrEqualTo(String value) {
            addCriterion("create_name <=", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameLike(String value) {
            addCriterion("create_name like", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameNotLike(String value) {
            addCriterion("create_name not like", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameIn(List<String> values) {
            addCriterion("create_name in", values, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameNotIn(List<String> values) {
            addCriterion("create_name not in", values, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameBetween(String value1, String value2) {
            addCriterion("create_name between", value1, value2, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameNotBetween(String value1, String value2) {
            addCriterion("create_name not between", value1, value2, "createName");
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
    }

    /**
     * authority
     */
    public static class Criteria extends GeneratedCriteria {
        private AuthorityExample example;

        protected Criteria(AuthorityExample example) {
            super();
            this.example = example;
        }

        /**
         *自动生成方法
         *@return com.dandelion.bean.example.AuthorityExample
         */
        public AuthorityExample example() {
            return this.example;
        }

        /**
         *自动生成方法
         *@param ifAdd generator
         *@param add generator
         *@return Criteria
         */
        public Criteria andIf(boolean ifAdd, ICriteriaAdd add) {
            if (ifAdd) {
                add.add(this);
            }
            return this;
        }

        /**
         * 这是Mybatis Generator拓展插件生成的接口(请勿删除).
         * This class corresponds to the database table authority
         *
         * @mbg.generated
         * @author generator
         */
        public interface ICriteriaAdd {
            /**
             *自动生成方法
             *@param add generator
             *@return Criteria
             */
            Criteria add(Criteria add);
        }
    }

    /**
     * authority 2019-12-11
     */
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