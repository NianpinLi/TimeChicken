/**
 *@author generator
 *@date 2019-12-19
 */
package com.dandelion.bean;

import java.io.Serializable;

public class Notice implements Serializable {
    /**
     * 公告ID
     */
    private Integer noticeId;

    /**
     * 公告标题
     */
    private String noticeTitle;

    /**
     * 公告重要等级
     */
    private String noticeLevel;

    /**
     * 是否置顶  1置顶 0不置顶
     */
    private Byte roofPlacement;

    /**
     * 创建人ID
     */
    private Integer createId;

    /**
     * 创建人姓名
     */
    private String createName;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 公告内容
     */
    private String noticeContent;

    /**
     *  * notice
     */
    private static final long serialVersionUID = 1L;

    /**
     * 公告ID
     * @return notice_id 公告ID
     */
    public Integer getNoticeId() {
        return noticeId;
    }

    /**
     * 公告ID
     * @param noticeId 公告ID
     */
    public void setNoticeId(Integer noticeId) {
        this.noticeId = noticeId;
    }

    /**
     * 公告标题
     * @return notice_title 公告标题
     */
    public String getNoticeTitle() {
        return noticeTitle;
    }

    /**
     * 公告标题
     * @param noticeTitle 公告标题
     */
    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle == null ? null : noticeTitle.trim();
    }

    /**
     * 公告重要等级
     * @return notice_level 公告重要等级
     */
    public String getNoticeLevel() {
        return noticeLevel;
    }

    /**
     * 公告重要等级
     * @param noticeLevel 公告重要等级
     */
    public void setNoticeLevel(String noticeLevel) {
        this.noticeLevel = noticeLevel == null ? null : noticeLevel.trim();
    }

    /**
     * 是否置顶  1置顶 0不置顶
     * @return roof_placement 是否置顶  1置顶 0不置顶
     */
    public Byte getRoofPlacement() {
        return roofPlacement;
    }

    /**
     * 是否置顶  1置顶 0不置顶
     * @param roofPlacement 是否置顶  1置顶 0不置顶
     */
    public void setRoofPlacement(Byte roofPlacement) {
        this.roofPlacement = roofPlacement;
    }

    /**
     * 创建人ID
     * @return create_id 创建人ID
     */
    public Integer getCreateId() {
        return createId;
    }

    /**
     * 创建人ID
     * @param createId 创建人ID
     */
    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    /**
     * 创建人姓名
     * @return create_name 创建人姓名
     */
    public String getCreateName() {
        return createName;
    }

    /**
     * 创建人姓名
     * @param createName 创建人姓名
     */
    public void setCreateName(String createName) {
        this.createName = createName == null ? null : createName.trim();
    }

    /**
     * 创建时间
     * @return create_time 创建时间
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     * @param createTime 创建时间
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    /**
     * 公告内容
     * @return notice_content 公告内容
     */
    public String getNoticeContent() {
        return noticeContent;
    }

    /**
     * 公告内容
     * @param noticeContent 公告内容
     */
    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent == null ? null : noticeContent.trim();
    }

    /**
     *自动生成方法
     *@return java.lang.String
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", noticeId=").append(noticeId);
        sb.append(", noticeTitle=").append(noticeTitle);
        sb.append(", noticeLevel=").append(noticeLevel);
        sb.append(", roofPlacement=").append(roofPlacement);
        sb.append(", createId=").append(createId);
        sb.append(", createName=").append(createName);
        sb.append(", createTime=").append(createTime);
        sb.append(", noticeContent=").append(noticeContent);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    /**
     * 这是Mybatis Generator拓展插件生成的类(请勿删除).
     * This class corresponds to the database table notice
     *
     * @mbg.generated
     * @author generator
     */
    public static class Builder {
        /**
         * 这是Mybatis Generator拓展插件生成的属性(请勿删除).
         * This field corresponds to the database table notice
         *
         * @mbg.generated
         * @author generator
         */
        private Notice obj;

        /**
         *自动生成方法
         */
        public Builder() {
            this.obj = new Notice();
        }

        /**
         *自动生成方法
         *@param noticeId generator
         *@return Builder
         */
        public Builder noticeId(Integer noticeId) {
            obj.noticeId = noticeId;
            return this;
        }

        /**
         *自动生成方法
         *@param noticeTitle generator
         *@return Builder
         */
        public Builder noticeTitle(String noticeTitle) {
            obj.noticeTitle = noticeTitle;
            return this;
        }

        /**
         *自动生成方法
         *@param noticeLevel generator
         *@return Builder
         */
        public Builder noticeLevel(String noticeLevel) {
            obj.noticeLevel = noticeLevel;
            return this;
        }

        /**
         *自动生成方法
         *@param roofPlacement generator
         *@return Builder
         */
        public Builder roofPlacement(Byte roofPlacement) {
            obj.roofPlacement = roofPlacement;
            return this;
        }

        /**
         *自动生成方法
         *@param createId generator
         *@return Builder
         */
        public Builder createId(Integer createId) {
            obj.createId = createId;
            return this;
        }

        /**
         *自动生成方法
         *@param createName generator
         *@return Builder
         */
        public Builder createName(String createName) {
            obj.createName = createName;
            return this;
        }

        /**
         *自动生成方法
         *@param createTime generator
         *@return Builder
         */
        public Builder createTime(String createTime) {
            obj.createTime = createTime;
            return this;
        }

        /**
         *自动生成方法
         *@param noticeContent generator
         *@return Builder
         */
        public Builder noticeContent(String noticeContent) {
            obj.noticeContent = noticeContent;
            return this;
        }

        /**
         *自动生成方法
         *@return com.dandelion.bean.Notice
         */
        public Notice build() {
            return this.obj;
        }
    }

    /**
     * 这是Mybatis Generator拓展插件生成的枚举(请勿删除).
     * This class corresponds to the database table notice
     *
     * @mbg.generated
     * @author generator
     */
    public enum Column {
        /**notice_id */
noticeId("notice_id"),
        /**notice_title */
noticeTitle("notice_title"),
        /**notice_level */
noticeLevel("notice_level"),
        /**roof_placement */
roofPlacement("roof_placement"),
        /**create_id */
createId("create_id"),
        /**create_name */
createName("create_name"),
        /**create_time */
createTime("create_time"),
        /**notice_content */
noticeContent("notice_content");

        /**
         * 这是Mybatis Generator拓展插件生成的属性(请勿删除).
         * This field corresponds to the database table notice
         *
         * @mbg.generated
         * @author generator
         */
        private final String column;

        /**
         *自动生成方法
         *@return java.lang.String
         */
        public String value() {
            return this.column;
        }

        /**
         *自动生成方法
         *@return java.lang.String
         */
        public String getValue() {
            return this.column;
        }

        /**
         *自动生成方法
         *@param column generator
         */
        Column(String column) {
            this.column = column;
        }

        /**
         *自动生成方法
         *@return java.lang.String
         */
        public String desc() {
            return this.column + " DESC";
        }

        /**
         *自动生成方法
         *@return java.lang.String
         */
        public String asc() {
            return this.column + " ASC";
        }
    }
}