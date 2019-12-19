/**
 *@author generator
 *@date 2019-12-19
 */
package com.dandelion.bean.example;

import java.util.ArrayList;
import java.util.List;

public class NoticeExample {
    /**
     *  * notice
     */
    protected String orderByClause;

    /**
     *  * notice
     */
    protected boolean distinct;

    /**
     *  * notice
     */
    protected List<Criteria> oredCriteria;

    /**
     *自动生成方法
     */
    public NoticeExample() {
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
     *@return com.dandelion.bean.example.NoticeExample
     */
    public NoticeExample orderBy(String orderByClause) {
        this.setOrderByClause(orderByClause);
        return this;
    }

    /**
     *自动生成方法
     *@param orderByClauses generator
     *@return com.dandelion.bean.example.NoticeExample
     */
    public NoticeExample orderBy(String ... orderByClauses) {
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
     * notice 2019-12-19
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

        public Criteria andNoticeIdIsNull() {
            addCriterion("notice_id is null");
            return (Criteria) this;
        }

        public Criteria andNoticeIdIsNotNull() {
            addCriterion("notice_id is not null");
            return (Criteria) this;
        }

        public Criteria andNoticeIdEqualTo(Integer value) {
            addCriterion("notice_id =", value, "noticeId");
            return (Criteria) this;
        }

        public Criteria andNoticeIdNotEqualTo(Integer value) {
            addCriterion("notice_id <>", value, "noticeId");
            return (Criteria) this;
        }

        public Criteria andNoticeIdGreaterThan(Integer value) {
            addCriterion("notice_id >", value, "noticeId");
            return (Criteria) this;
        }

        public Criteria andNoticeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("notice_id >=", value, "noticeId");
            return (Criteria) this;
        }

        public Criteria andNoticeIdLessThan(Integer value) {
            addCriterion("notice_id <", value, "noticeId");
            return (Criteria) this;
        }

        public Criteria andNoticeIdLessThanOrEqualTo(Integer value) {
            addCriterion("notice_id <=", value, "noticeId");
            return (Criteria) this;
        }

        public Criteria andNoticeIdIn(List<Integer> values) {
            addCriterion("notice_id in", values, "noticeId");
            return (Criteria) this;
        }

        public Criteria andNoticeIdNotIn(List<Integer> values) {
            addCriterion("notice_id not in", values, "noticeId");
            return (Criteria) this;
        }

        public Criteria andNoticeIdBetween(Integer value1, Integer value2) {
            addCriterion("notice_id between", value1, value2, "noticeId");
            return (Criteria) this;
        }

        public Criteria andNoticeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("notice_id not between", value1, value2, "noticeId");
            return (Criteria) this;
        }

        public Criteria andNoticeTitleIsNull() {
            addCriterion("notice_title is null");
            return (Criteria) this;
        }

        public Criteria andNoticeTitleIsNotNull() {
            addCriterion("notice_title is not null");
            return (Criteria) this;
        }

        public Criteria andNoticeTitleEqualTo(String value) {
            addCriterion("notice_title =", value, "noticeTitle");
            return (Criteria) this;
        }

        public Criteria andNoticeTitleNotEqualTo(String value) {
            addCriterion("notice_title <>", value, "noticeTitle");
            return (Criteria) this;
        }

        public Criteria andNoticeTitleGreaterThan(String value) {
            addCriterion("notice_title >", value, "noticeTitle");
            return (Criteria) this;
        }

        public Criteria andNoticeTitleGreaterThanOrEqualTo(String value) {
            addCriterion("notice_title >=", value, "noticeTitle");
            return (Criteria) this;
        }

        public Criteria andNoticeTitleLessThan(String value) {
            addCriterion("notice_title <", value, "noticeTitle");
            return (Criteria) this;
        }

        public Criteria andNoticeTitleLessThanOrEqualTo(String value) {
            addCriterion("notice_title <=", value, "noticeTitle");
            return (Criteria) this;
        }

        public Criteria andNoticeTitleLike(String value) {
            addCriterion("notice_title like", value, "noticeTitle");
            return (Criteria) this;
        }

        public Criteria andNoticeTitleNotLike(String value) {
            addCriterion("notice_title not like", value, "noticeTitle");
            return (Criteria) this;
        }

        public Criteria andNoticeTitleIn(List<String> values) {
            addCriterion("notice_title in", values, "noticeTitle");
            return (Criteria) this;
        }

        public Criteria andNoticeTitleNotIn(List<String> values) {
            addCriterion("notice_title not in", values, "noticeTitle");
            return (Criteria) this;
        }

        public Criteria andNoticeTitleBetween(String value1, String value2) {
            addCriterion("notice_title between", value1, value2, "noticeTitle");
            return (Criteria) this;
        }

        public Criteria andNoticeTitleNotBetween(String value1, String value2) {
            addCriterion("notice_title not between", value1, value2, "noticeTitle");
            return (Criteria) this;
        }

        public Criteria andNoticeLevelIsNull() {
            addCriterion("notice_level is null");
            return (Criteria) this;
        }

        public Criteria andNoticeLevelIsNotNull() {
            addCriterion("notice_level is not null");
            return (Criteria) this;
        }

        public Criteria andNoticeLevelEqualTo(String value) {
            addCriterion("notice_level =", value, "noticeLevel");
            return (Criteria) this;
        }

        public Criteria andNoticeLevelNotEqualTo(String value) {
            addCriterion("notice_level <>", value, "noticeLevel");
            return (Criteria) this;
        }

        public Criteria andNoticeLevelGreaterThan(String value) {
            addCriterion("notice_level >", value, "noticeLevel");
            return (Criteria) this;
        }

        public Criteria andNoticeLevelGreaterThanOrEqualTo(String value) {
            addCriterion("notice_level >=", value, "noticeLevel");
            return (Criteria) this;
        }

        public Criteria andNoticeLevelLessThan(String value) {
            addCriterion("notice_level <", value, "noticeLevel");
            return (Criteria) this;
        }

        public Criteria andNoticeLevelLessThanOrEqualTo(String value) {
            addCriterion("notice_level <=", value, "noticeLevel");
            return (Criteria) this;
        }

        public Criteria andNoticeLevelLike(String value) {
            addCriterion("notice_level like", value, "noticeLevel");
            return (Criteria) this;
        }

        public Criteria andNoticeLevelNotLike(String value) {
            addCriterion("notice_level not like", value, "noticeLevel");
            return (Criteria) this;
        }

        public Criteria andNoticeLevelIn(List<String> values) {
            addCriterion("notice_level in", values, "noticeLevel");
            return (Criteria) this;
        }

        public Criteria andNoticeLevelNotIn(List<String> values) {
            addCriterion("notice_level not in", values, "noticeLevel");
            return (Criteria) this;
        }

        public Criteria andNoticeLevelBetween(String value1, String value2) {
            addCriterion("notice_level between", value1, value2, "noticeLevel");
            return (Criteria) this;
        }

        public Criteria andNoticeLevelNotBetween(String value1, String value2) {
            addCriterion("notice_level not between", value1, value2, "noticeLevel");
            return (Criteria) this;
        }

        public Criteria andRoofPlacementIsNull() {
            addCriterion("roof_placement is null");
            return (Criteria) this;
        }

        public Criteria andRoofPlacementIsNotNull() {
            addCriterion("roof_placement is not null");
            return (Criteria) this;
        }

        public Criteria andRoofPlacementEqualTo(Byte value) {
            addCriterion("roof_placement =", value, "roofPlacement");
            return (Criteria) this;
        }

        public Criteria andRoofPlacementNotEqualTo(Byte value) {
            addCriterion("roof_placement <>", value, "roofPlacement");
            return (Criteria) this;
        }

        public Criteria andRoofPlacementGreaterThan(Byte value) {
            addCriterion("roof_placement >", value, "roofPlacement");
            return (Criteria) this;
        }

        public Criteria andRoofPlacementGreaterThanOrEqualTo(Byte value) {
            addCriterion("roof_placement >=", value, "roofPlacement");
            return (Criteria) this;
        }

        public Criteria andRoofPlacementLessThan(Byte value) {
            addCriterion("roof_placement <", value, "roofPlacement");
            return (Criteria) this;
        }

        public Criteria andRoofPlacementLessThanOrEqualTo(Byte value) {
            addCriterion("roof_placement <=", value, "roofPlacement");
            return (Criteria) this;
        }

        public Criteria andRoofPlacementIn(List<Byte> values) {
            addCriterion("roof_placement in", values, "roofPlacement");
            return (Criteria) this;
        }

        public Criteria andRoofPlacementNotIn(List<Byte> values) {
            addCriterion("roof_placement not in", values, "roofPlacement");
            return (Criteria) this;
        }

        public Criteria andRoofPlacementBetween(Byte value1, Byte value2) {
            addCriterion("roof_placement between", value1, value2, "roofPlacement");
            return (Criteria) this;
        }

        public Criteria andRoofPlacementNotBetween(Byte value1, Byte value2) {
            addCriterion("roof_placement not between", value1, value2, "roofPlacement");
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
     * notice
     */
    public static class Criteria extends GeneratedCriteria {
        private NoticeExample example;

        protected Criteria(NoticeExample example) {
            super();
            this.example = example;
        }

        /**
         *自动生成方法
         *@return com.dandelion.bean.example.NoticeExample
         */
        public NoticeExample example() {
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
         * This class corresponds to the database table notice
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
     * notice 2019-12-19
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