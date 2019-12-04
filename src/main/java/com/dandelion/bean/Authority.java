/**
 *@author generator
 *@date 2019-12-04
 */
package com.dandelion.bean;

import java.io.Serializable;

public class Authority implements Serializable {
    /**
     * 权限ID
     */
    private Integer authorityId;

    /**
     * 权限名称
     */
    private String authorityName;

    /**
     * 权限路径
     */
    private String authorityUrl;

    /**
     * 权限图表样式
     */
    private String authorityIcon;

    /**
     * 权限标识 1增 2查 3改 4删
     */
    private Integer authorityIdentifier;

    /**
     * 权限等级 0为最高级
     */
    private Integer authorityLevel;

    /**
     * 上级权限ID -1为最上级权限
     */
    private Integer parentAuthorityId;

    /**
     * 权限状态 0停用 1启动 -1删除
     */
    private Integer authorityStatus;

    /**
     * 权限类型 1，页面 2，按钮
     */
    private Integer authorityType;

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
     *  * authority
     */
    private static final long serialVersionUID = 1L;

    /**
     * 权限ID
     * @return authority_id 权限ID
     */
    public Integer getAuthorityId() {
        return authorityId;
    }

    /**
     * 权限ID
     * @param authorityId 权限ID
     */
    public void setAuthorityId(Integer authorityId) {
        this.authorityId = authorityId;
    }

    /**
     * 权限名称
     * @return authority_name 权限名称
     */
    public String getAuthorityName() {
        return authorityName;
    }

    /**
     * 权限名称
     * @param authorityName 权限名称
     */
    public void setAuthorityName(String authorityName) {
        this.authorityName = authorityName == null ? null : authorityName.trim();
    }

    /**
     * 权限路径
     * @return authority_url 权限路径
     */
    public String getAuthorityUrl() {
        return authorityUrl;
    }

    /**
     * 权限路径
     * @param authorityUrl 权限路径
     */
    public void setAuthorityUrl(String authorityUrl) {
        this.authorityUrl = authorityUrl == null ? null : authorityUrl.trim();
    }

    /**
     * 权限图表样式
     * @return authority_icon 权限图表样式
     */
    public String getAuthorityIcon() {
        return authorityIcon;
    }

    /**
     * 权限图表样式
     * @param authorityIcon 权限图表样式
     */
    public void setAuthorityIcon(String authorityIcon) {
        this.authorityIcon = authorityIcon == null ? null : authorityIcon.trim();
    }

    /**
     * 权限标识 1增 2查 3改 4删
     * @return authority_identifier 权限标识 1增 2查 3改 4删
     */
    public Integer getAuthorityIdentifier() {
        return authorityIdentifier;
    }

    /**
     * 权限标识 1增 2查 3改 4删
     * @param authorityIdentifier 权限标识 1增 2查 3改 4删
     */
    public void setAuthorityIdentifier(Integer authorityIdentifier) {
        this.authorityIdentifier = authorityIdentifier;
    }

    /**
     * 权限等级 0为最高级
     * @return authority_level 权限等级 0为最高级
     */
    public Integer getAuthorityLevel() {
        return authorityLevel;
    }

    /**
     * 权限等级 0为最高级
     * @param authorityLevel 权限等级 0为最高级
     */
    public void setAuthorityLevel(Integer authorityLevel) {
        this.authorityLevel = authorityLevel;
    }

    /**
     * 上级权限ID -1为最上级权限
     * @return parent_authority_id 上级权限ID -1为最上级权限
     */
    public Integer getParentAuthorityId() {
        return parentAuthorityId;
    }

    /**
     * 上级权限ID -1为最上级权限
     * @param parentAuthorityId 上级权限ID -1为最上级权限
     */
    public void setParentAuthorityId(Integer parentAuthorityId) {
        this.parentAuthorityId = parentAuthorityId;
    }

    /**
     * 权限状态 0停用 1启动 -1删除
     * @return authority_status 权限状态 0停用 1启动 -1删除
     */
    public Integer getAuthorityStatus() {
        return authorityStatus;
    }

    /**
     * 权限状态 0停用 1启动 -1删除
     * @param authorityStatus 权限状态 0停用 1启动 -1删除
     */
    public void setAuthorityStatus(Integer authorityStatus) {
        this.authorityStatus = authorityStatus;
    }

    /**
     * 权限类型 1，页面 2，按钮
     * @return authority_type 权限类型 1，页面 2，按钮
     */
    public Integer getAuthorityType() {
        return authorityType;
    }

    /**
     * 权限类型 1，页面 2，按钮
     * @param authorityType 权限类型 1，页面 2，按钮
     */
    public void setAuthorityType(Integer authorityType) {
        this.authorityType = authorityType;
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
     *自动生成方法
     *@return java.lang.String
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", authorityId=").append(authorityId);
        sb.append(", authorityName=").append(authorityName);
        sb.append(", authorityUrl=").append(authorityUrl);
        sb.append(", authorityIcon=").append(authorityIcon);
        sb.append(", authorityIdentifier=").append(authorityIdentifier);
        sb.append(", authorityLevel=").append(authorityLevel);
        sb.append(", parentAuthorityId=").append(parentAuthorityId);
        sb.append(", authorityStatus=").append(authorityStatus);
        sb.append(", authorityType=").append(authorityType);
        sb.append(", createId=").append(createId);
        sb.append(", createName=").append(createName);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    /**
     * 这是Mybatis Generator拓展插件生成的类(请勿删除).
     * This class corresponds to the database table authority
     *
     * @mbg.generated
     * @author generator
     */
    public static class Builder {
        /**
         * 这是Mybatis Generator拓展插件生成的属性(请勿删除).
         * This field corresponds to the database table authority
         *
         * @mbg.generated
         * @author generator
         */
        private Authority obj;

        /**
         *自动生成方法
         */
        public Builder() {
            this.obj = new Authority();
        }

        /**
         *自动生成方法
         *@param authorityId generator
         *@return Builder
         */
        public Builder authorityId(Integer authorityId) {
            obj.authorityId = authorityId;
            return this;
        }

        /**
         *自动生成方法
         *@param authorityName generator
         *@return Builder
         */
        public Builder authorityName(String authorityName) {
            obj.authorityName = authorityName;
            return this;
        }

        /**
         *自动生成方法
         *@param authorityUrl generator
         *@return Builder
         */
        public Builder authorityUrl(String authorityUrl) {
            obj.authorityUrl = authorityUrl;
            return this;
        }

        /**
         *自动生成方法
         *@param authorityIcon generator
         *@return Builder
         */
        public Builder authorityIcon(String authorityIcon) {
            obj.authorityIcon = authorityIcon;
            return this;
        }

        /**
         *自动生成方法
         *@param authorityIdentifier generator
         *@return Builder
         */
        public Builder authorityIdentifier(Integer authorityIdentifier) {
            obj.authorityIdentifier = authorityIdentifier;
            return this;
        }

        /**
         *自动生成方法
         *@param authorityLevel generator
         *@return Builder
         */
        public Builder authorityLevel(Integer authorityLevel) {
            obj.authorityLevel = authorityLevel;
            return this;
        }

        /**
         *自动生成方法
         *@param parentAuthorityId generator
         *@return Builder
         */
        public Builder parentAuthorityId(Integer parentAuthorityId) {
            obj.parentAuthorityId = parentAuthorityId;
            return this;
        }

        /**
         *自动生成方法
         *@param authorityStatus generator
         *@return Builder
         */
        public Builder authorityStatus(Integer authorityStatus) {
            obj.authorityStatus = authorityStatus;
            return this;
        }

        /**
         *自动生成方法
         *@param authorityType generator
         *@return Builder
         */
        public Builder authorityType(Integer authorityType) {
            obj.authorityType = authorityType;
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
         *@return com.dandelion.bean.Authority
         */
        public Authority build() {
            return this.obj;
        }
    }

    /**
     * 这是Mybatis Generator拓展插件生成的枚举(请勿删除).
     * This class corresponds to the database table authority
     *
     * @mbg.generated
     * @author generator
     */
    public enum Column {
        /**authority_id */
authorityId("authority_id"),
        /**authority_name */
authorityName("authority_name"),
        /**authority_url */
authorityUrl("authority_url"),
        /**authority_icon */
authorityIcon("authority_icon"),
        /**authority_identifier */
authorityIdentifier("authority_identifier"),
        /**authority_level */
authorityLevel("authority_level"),
        /**parent_authority_id */
parentAuthorityId("parent_authority_id"),
        /**authority_status */
authorityStatus("authority_status"),
        /**authority_type */
authorityType("authority_type"),
        /**create_id */
createId("create_id"),
        /**create_name */
createName("create_name"),
        /**create_time */
createTime("create_time");

        /**
         * 这是Mybatis Generator拓展插件生成的属性(请勿删除).
         * This field corresponds to the database table authority
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