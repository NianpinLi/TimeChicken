/**
 *@author generator
 *@date 2019-10-30
 */
package com.dandelion.bean.example;

import java.util.ArrayList;
import java.util.List;

public class WorkOrderTypeExample {
    /**
     *  * work_order_type
     */
    protected String orderByClause;

    /**
     *  * work_order_type
     */
    protected boolean distinct;

    /**
     *  * work_order_type
     */
    protected List<Criteria> oredCriteria;

    /**
     *自动生成方法
     */
    public WorkOrderTypeExample() {
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
     * 这是Mybatis Generator拓展插件生成的方法(请勿删除).
     * This method corresponds to the database table work_order_type
     *
     * @mbg.generated
     * @author generator
     */
    public WorkOrderTypeExample orderBy(String orderByClause) {
        this.setOrderByClause(orderByClause);
        return this;
    }

    /**
     * 这是Mybatis Generator拓展插件生成的方法(请勿删除).
     * This method corresponds to the database table work_order_type
     *
     * @mbg.generated
     * @author generator
     */
    public WorkOrderTypeExample orderBy(String ... orderByClauses) {
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
     * work_order_type 2019-10-30
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

        public Criteria andTypeIdIsNull() {
            addCriterion("type_id is null");
            return (Criteria) this;
        }

        public Criteria andTypeIdIsNotNull() {
            addCriterion("type_id is not null");
            return (Criteria) this;
        }

        public Criteria andTypeIdEqualTo(Integer value) {
            addCriterion("type_id =", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotEqualTo(Integer value) {
            addCriterion("type_id <>", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThan(Integer value) {
            addCriterion("type_id >", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("type_id >=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThan(Integer value) {
            addCriterion("type_id <", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("type_id <=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdIn(List<Integer> values) {
            addCriterion("type_id in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotIn(List<Integer> values) {
            addCriterion("type_id not in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("type_id between", value1, value2, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("type_id not between", value1, value2, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeNameIsNull() {
            addCriterion("type_name is null");
            return (Criteria) this;
        }

        public Criteria andTypeNameIsNotNull() {
            addCriterion("type_name is not null");
            return (Criteria) this;
        }

        public Criteria andTypeNameEqualTo(String value) {
            addCriterion("type_name =", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameNotEqualTo(String value) {
            addCriterion("type_name <>", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameGreaterThan(String value) {
            addCriterion("type_name >", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("type_name >=", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameLessThan(String value) {
            addCriterion("type_name <", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameLessThanOrEqualTo(String value) {
            addCriterion("type_name <=", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameLike(String value) {
            addCriterion("type_name like", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameNotLike(String value) {
            addCriterion("type_name not like", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameIn(List<String> values) {
            addCriterion("type_name in", values, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameNotIn(List<String> values) {
            addCriterion("type_name not in", values, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameBetween(String value1, String value2) {
            addCriterion("type_name between", value1, value2, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameNotBetween(String value1, String value2) {
            addCriterion("type_name not between", value1, value2, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeStatusIsNull() {
            addCriterion("type_status is null");
            return (Criteria) this;
        }

        public Criteria andTypeStatusIsNotNull() {
            addCriterion("type_status is not null");
            return (Criteria) this;
        }

        public Criteria andTypeStatusEqualTo(Byte value) {
            addCriterion("type_status =", value, "typeStatus");
            return (Criteria) this;
        }

        public Criteria andTypeStatusNotEqualTo(Byte value) {
            addCriterion("type_status <>", value, "typeStatus");
            return (Criteria) this;
        }

        public Criteria andTypeStatusGreaterThan(Byte value) {
            addCriterion("type_status >", value, "typeStatus");
            return (Criteria) this;
        }

        public Criteria andTypeStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("type_status >=", value, "typeStatus");
            return (Criteria) this;
        }

        public Criteria andTypeStatusLessThan(Byte value) {
            addCriterion("type_status <", value, "typeStatus");
            return (Criteria) this;
        }

        public Criteria andTypeStatusLessThanOrEqualTo(Byte value) {
            addCriterion("type_status <=", value, "typeStatus");
            return (Criteria) this;
        }

        public Criteria andTypeStatusIn(List<Byte> values) {
            addCriterion("type_status in", values, "typeStatus");
            return (Criteria) this;
        }

        public Criteria andTypeStatusNotIn(List<Byte> values) {
            addCriterion("type_status not in", values, "typeStatus");
            return (Criteria) this;
        }

        public Criteria andTypeStatusBetween(Byte value1, Byte value2) {
            addCriterion("type_status between", value1, value2, "typeStatus");
            return (Criteria) this;
        }

        public Criteria andTypeStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("type_status not between", value1, value2, "typeStatus");
            return (Criteria) this;
        }

        public Criteria andProcedureIsNull() {
            addCriterion("procedure is null");
            return (Criteria) this;
        }

        public Criteria andProcedureIsNotNull() {
            addCriterion("procedure is not null");
            return (Criteria) this;
        }

        public Criteria andProcedureEqualTo(String value) {
            addCriterion("procedure =", value, "procedure");
            return (Criteria) this;
        }

        public Criteria andProcedureNotEqualTo(String value) {
            addCriterion("procedure <>", value, "procedure");
            return (Criteria) this;
        }

        public Criteria andProcedureGreaterThan(String value) {
            addCriterion("procedure >", value, "procedure");
            return (Criteria) this;
        }

        public Criteria andProcedureGreaterThanOrEqualTo(String value) {
            addCriterion("procedure >=", value, "procedure");
            return (Criteria) this;
        }

        public Criteria andProcedureLessThan(String value) {
            addCriterion("procedure <", value, "procedure");
            return (Criteria) this;
        }

        public Criteria andProcedureLessThanOrEqualTo(String value) {
            addCriterion("procedure <=", value, "procedure");
            return (Criteria) this;
        }

        public Criteria andProcedureLike(String value) {
            addCriterion("procedure like", value, "procedure");
            return (Criteria) this;
        }

        public Criteria andProcedureNotLike(String value) {
            addCriterion("procedure not like", value, "procedure");
            return (Criteria) this;
        }

        public Criteria andProcedureIn(List<String> values) {
            addCriterion("procedure in", values, "procedure");
            return (Criteria) this;
        }

        public Criteria andProcedureNotIn(List<String> values) {
            addCriterion("procedure not in", values, "procedure");
            return (Criteria) this;
        }

        public Criteria andProcedureBetween(String value1, String value2) {
            addCriterion("procedure between", value1, value2, "procedure");
            return (Criteria) this;
        }

        public Criteria andProcedureNotBetween(String value1, String value2) {
            addCriterion("procedure not between", value1, value2, "procedure");
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
    }

    /**
     * work_order_type
     */
    public static class Criteria extends GeneratedCriteria {
        private WorkOrderTypeExample example;

        protected Criteria(WorkOrderTypeExample example) {
            super();
            this.example = example;
        }

        /**
         * 这是Mybatis Generator拓展插件生成的方法(请勿删除).
         * This method corresponds to the database table work_order_type
         *
         * @mbg.generated
         * @author generator
         */
        public WorkOrderTypeExample example() {
            return this.example;
        }

        /**
         * 这是Mybatis Generator拓展插件生成的方法(请勿删除).
         * This method corresponds to the database table work_order_type
         *
         * @mbg.generated
         * @author generator
         */
        public Criteria andIf(boolean ifAdd, ICriteriaAdd add) {
            if (ifAdd) {
                add.add(this);
            }
            return this;
        }

        /**
         * 这是Mybatis Generator拓展插件生成的接口(请勿删除).
         * This class corresponds to the database table work_order_type
         *
         * @mbg.generated
         * @author generator
         */
        public interface ICriteriaAdd {
            /**
             * 这是Mybatis Generator拓展插件生成的方法(请勿删除).
             * This method corresponds to the database table work_order_type
             *
             * @mbg.generated
             * @author generator
             */
            Criteria add(Criteria add);
        }
    }

    /**
     * work_order_type 2019-10-30
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