/**
 *@author generator
 *@date 2019-10-30
 */
package com.dandelion.bean.example;

import java.util.ArrayList;
import java.util.List;

public class RoleExample {
    /**
     *  * role
     */
    protected String orderByClause;

    /**
     *  * role
     */
    protected boolean distinct;

    /**
     *  * role
     */
    protected List<Criteria> oredCriteria;

    /**
     *自动生成方法
     */
    public RoleExample() {
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
     *@return com.dandelion.bean.example.RoleExample
     */
    public RoleExample orderBy(String orderByClause) {
        this.setOrderByClause(orderByClause);
        return this;
    }

    /**
     *自动生成方法
     *@param orderByClauses generator
     *@return com.dandelion.bean.example.RoleExample
     */
    public RoleExample orderBy(String ... orderByClauses) {
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
     * role 2019-10-30
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

        public Criteria andRoleIdIsNull() {
            addCriterion("role_id is null");
            return (Criteria) this;
        }

        public Criteria andRoleIdIsNotNull() {
            addCriterion("role_id is not null");
            return (Criteria) this;
        }

        public Criteria andRoleIdEqualTo(Integer value) {
            addCriterion("role_id =", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotEqualTo(Integer value) {
            addCriterion("role_id <>", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdGreaterThan(Integer value) {
            addCriterion("role_id >", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("role_id >=", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLessThan(Integer value) {
            addCriterion("role_id <", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLessThanOrEqualTo(Integer value) {
            addCriterion("role_id <=", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdIn(List<Integer> values) {
            addCriterion("role_id in", values, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotIn(List<Integer> values) {
            addCriterion("role_id not in", values, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdBetween(Integer value1, Integer value2) {
            addCriterion("role_id between", value1, value2, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("role_id not between", value1, value2, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleNameIsNull() {
            addCriterion("role_name is null");
            return (Criteria) this;
        }

        public Criteria andRoleNameIsNotNull() {
            addCriterion("role_name is not null");
            return (Criteria) this;
        }

        public Criteria andRoleNameEqualTo(String value) {
            addCriterion("role_name =", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameNotEqualTo(String value) {
            addCriterion("role_name <>", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameGreaterThan(String value) {
            addCriterion("role_name >", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameGreaterThanOrEqualTo(String value) {
            addCriterion("role_name >=", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameLessThan(String value) {
            addCriterion("role_name <", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameLessThanOrEqualTo(String value) {
            addCriterion("role_name <=", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameLike(String value) {
            addCriterion("role_name like", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameNotLike(String value) {
            addCriterion("role_name not like", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameIn(List<String> values) {
            addCriterion("role_name in", values, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameNotIn(List<String> values) {
            addCriterion("role_name not in", values, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameBetween(String value1, String value2) {
            addCriterion("role_name between", value1, value2, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameNotBetween(String value1, String value2) {
            addCriterion("role_name not between", value1, value2, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleStatusIsNull() {
            addCriterion("role_status is null");
            return (Criteria) this;
        }

        public Criteria andRoleStatusIsNotNull() {
            addCriterion("role_status is not null");
            return (Criteria) this;
        }

        public Criteria andRoleStatusEqualTo(Integer value) {
            addCriterion("role_status =", value, "roleStatus");
            return (Criteria) this;
        }

        public Criteria andRoleStatusNotEqualTo(Integer value) {
            addCriterion("role_status <>", value, "roleStatus");
            return (Criteria) this;
        }

        public Criteria andRoleStatusGreaterThan(Integer value) {
            addCriterion("role_status >", value, "roleStatus");
            return (Criteria) this;
        }

        public Criteria andRoleStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("role_status >=", value, "roleStatus");
            return (Criteria) this;
        }

        public Criteria andRoleStatusLessThan(Integer value) {
            addCriterion("role_status <", value, "roleStatus");
            return (Criteria) this;
        }

        public Criteria andRoleStatusLessThanOrEqualTo(Integer value) {
            addCriterion("role_status <=", value, "roleStatus");
            return (Criteria) this;
        }

        public Criteria andRoleStatusIn(List<Integer> values) {
            addCriterion("role_status in", values, "roleStatus");
            return (Criteria) this;
        }

        public Criteria andRoleStatusNotIn(List<Integer> values) {
            addCriterion("role_status not in", values, "roleStatus");
            return (Criteria) this;
        }

        public Criteria andRoleStatusBetween(Integer value1, Integer value2) {
            addCriterion("role_status between", value1, value2, "roleStatus");
            return (Criteria) this;
        }

        public Criteria andRoleStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("role_status not between", value1, value2, "roleStatus");
            return (Criteria) this;
        }

        public Criteria andRoleDescribeIsNull() {
            addCriterion("role_describe is null");
            return (Criteria) this;
        }

        public Criteria andRoleDescribeIsNotNull() {
            addCriterion("role_describe is not null");
            return (Criteria) this;
        }

        public Criteria andRoleDescribeEqualTo(String value) {
            addCriterion("role_describe =", value, "roleDescribe");
            return (Criteria) this;
        }

        public Criteria andRoleDescribeNotEqualTo(String value) {
            addCriterion("role_describe <>", value, "roleDescribe");
            return (Criteria) this;
        }

        public Criteria andRoleDescribeGreaterThan(String value) {
            addCriterion("role_describe >", value, "roleDescribe");
            return (Criteria) this;
        }

        public Criteria andRoleDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("role_describe >=", value, "roleDescribe");
            return (Criteria) this;
        }

        public Criteria andRoleDescribeLessThan(String value) {
            addCriterion("role_describe <", value, "roleDescribe");
            return (Criteria) this;
        }

        public Criteria andRoleDescribeLessThanOrEqualTo(String value) {
            addCriterion("role_describe <=", value, "roleDescribe");
            return (Criteria) this;
        }

        public Criteria andRoleDescribeLike(String value) {
            addCriterion("role_describe like", value, "roleDescribe");
            return (Criteria) this;
        }

        public Criteria andRoleDescribeNotLike(String value) {
            addCriterion("role_describe not like", value, "roleDescribe");
            return (Criteria) this;
        }

        public Criteria andRoleDescribeIn(List<String> values) {
            addCriterion("role_describe in", values, "roleDescribe");
            return (Criteria) this;
        }

        public Criteria andRoleDescribeNotIn(List<String> values) {
            addCriterion("role_describe not in", values, "roleDescribe");
            return (Criteria) this;
        }

        public Criteria andRoleDescribeBetween(String value1, String value2) {
            addCriterion("role_describe between", value1, value2, "roleDescribe");
            return (Criteria) this;
        }

        public Criteria andRoleDescribeNotBetween(String value1, String value2) {
            addCriterion("role_describe not between", value1, value2, "roleDescribe");
            return (Criteria) this;
        }

        public Criteria andParentRoleIdIsNull() {
            addCriterion("parent_role_id is null");
            return (Criteria) this;
        }

        public Criteria andParentRoleIdIsNotNull() {
            addCriterion("parent_role_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentRoleIdEqualTo(Integer value) {
            addCriterion("parent_role_id =", value, "parentRoleId");
            return (Criteria) this;
        }

        public Criteria andParentRoleIdNotEqualTo(Integer value) {
            addCriterion("parent_role_id <>", value, "parentRoleId");
            return (Criteria) this;
        }

        public Criteria andParentRoleIdGreaterThan(Integer value) {
            addCriterion("parent_role_id >", value, "parentRoleId");
            return (Criteria) this;
        }

        public Criteria andParentRoleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("parent_role_id >=", value, "parentRoleId");
            return (Criteria) this;
        }

        public Criteria andParentRoleIdLessThan(Integer value) {
            addCriterion("parent_role_id <", value, "parentRoleId");
            return (Criteria) this;
        }

        public Criteria andParentRoleIdLessThanOrEqualTo(Integer value) {
            addCriterion("parent_role_id <=", value, "parentRoleId");
            return (Criteria) this;
        }

        public Criteria andParentRoleIdIn(List<Integer> values) {
            addCriterion("parent_role_id in", values, "parentRoleId");
            return (Criteria) this;
        }

        public Criteria andParentRoleIdNotIn(List<Integer> values) {
            addCriterion("parent_role_id not in", values, "parentRoleId");
            return (Criteria) this;
        }

        public Criteria andParentRoleIdBetween(Integer value1, Integer value2) {
            addCriterion("parent_role_id between", value1, value2, "parentRoleId");
            return (Criteria) this;
        }

        public Criteria andParentRoleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("parent_role_id not between", value1, value2, "parentRoleId");
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
     * role
     */
    public static class Criteria extends GeneratedCriteria {
        private RoleExample example;

        protected Criteria(RoleExample example) {
            super();
            this.example = example;
        }

        /**
         *自动生成方法
         *@return com.dandelion.bean.example.RoleExample
         */
        public RoleExample example() {
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
         * This class corresponds to the database table role
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
     * role 2019-10-30
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