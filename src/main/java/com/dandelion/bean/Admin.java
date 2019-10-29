/**
 *@author generator
 *@date 2019-10-29
 */
package com.dandelion.bean;

import java.io.Serializable;

public class Admin implements Serializable {
    /**
     * ID 自增
     */
    private Integer adminId;

    /**
     * 用户登录名
     */
    private String adminName;

    /**
     * 用户登录密码
     */
    private String adminPassword;

    /**
     * 用户状态 1启用 0停用 -1删除
     */
    private Byte adminStatus;

    /**
     * 用户真实姓名
     */
    private String realName;

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
     *  * admin
     */
    private static final long serialVersionUID = 1L;

    /**
     * ID 自增
     * @return admin_id ID 自增
     */
    public Integer getAdminId() {
        return adminId;
    }

    /**
     * ID 自增
     * @param adminId ID 自增
     */
    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    /**
     * 用户登录名
     * @return admin_name 用户登录名
     */
    public String getAdminName() {
        return adminName;
    }

    /**
     * 用户登录名
     * @param adminName 用户登录名
     */
    public void setAdminName(String adminName) {
        this.adminName = adminName == null ? null : adminName.trim();
    }

    /**
     * 用户登录密码
     * @return admin_password 用户登录密码
     */
    public String getAdminPassword() {
        return adminPassword;
    }

    /**
     * 用户登录密码
     * @param adminPassword 用户登录密码
     */
    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword == null ? null : adminPassword.trim();
    }

    /**
     * 用户状态 1启用 0停用 -1删除
     * @return admin_status 用户状态 1启用 0停用 -1删除
     */
    public Byte getAdminStatus() {
        return adminStatus;
    }

    /**
     * 用户状态 1启用 0停用 -1删除
     * @param adminStatus 用户状态 1启用 0停用 -1删除
     */
    public void setAdminStatus(Byte adminStatus) {
        this.adminStatus = adminStatus;
    }

    /**
     * 用户真实姓名
     * @return real_name 用户真实姓名
     */
    public String getRealName() {
        return realName;
    }

    /**
     * 用户真实姓名
     * @param realName 用户真实姓名
     */
    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
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
        sb.append(", adminId=").append(adminId);
        sb.append(", adminName=").append(adminName);
        sb.append(", adminPassword=").append(adminPassword);
        sb.append(", adminStatus=").append(adminStatus);
        sb.append(", realName=").append(realName);
        sb.append(", createId=").append(createId);
        sb.append(", createName=").append(createName);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    /**
     * 这是Mybatis Generator拓展插件生成的类(请勿删除).
     * This class corresponds to the database table admin
     *
     * @mbg.generated
     * @author generator
     */
    public static class Builder {
        /**
         * 这是Mybatis Generator拓展插件生成的属性(请勿删除).
         * This field corresponds to the database table admin
         *
         * @mbg.generated
         * @author generator
         */
        private Admin obj;

        /**
         * 这是Mybatis Generator拓展插件生成的方法(请勿删除).
         * This method corresponds to the database table admin
         *
         * @mbg.generated
         * @author generator
         */
        public Builder() {
            this.obj = new Admin();
        }

        /**
         * 这是Mybatis Generator拓展插件生成的方法(请勿删除).
         * This method corresponds to the database table admin
         *
         * @mbg.generated
         * @author generator
         */
        public Builder adminId(Integer adminId) {
            obj.adminId = adminId;
            return this;
        }

        /**
         * 这是Mybatis Generator拓展插件生成的方法(请勿删除).
         * This method corresponds to the database table admin
         *
         * @mbg.generated
         * @author generator
         */
        public Builder adminName(String adminName) {
            obj.adminName = adminName;
            return this;
        }

        /**
         * 这是Mybatis Generator拓展插件生成的方法(请勿删除).
         * This method corresponds to the database table admin
         *
         * @mbg.generated
         * @author generator
         */
        public Builder adminPassword(String adminPassword) {
            obj.adminPassword = adminPassword;
            return this;
        }

        /**
         * 这是Mybatis Generator拓展插件生成的方法(请勿删除).
         * This method corresponds to the database table admin
         *
         * @mbg.generated
         * @author generator
         */
        public Builder adminStatus(Byte adminStatus) {
            obj.adminStatus = adminStatus;
            return this;
        }

        /**
         * 这是Mybatis Generator拓展插件生成的方法(请勿删除).
         * This method corresponds to the database table admin
         *
         * @mbg.generated
         * @author generator
         */
        public Builder realName(String realName) {
            obj.realName = realName;
            return this;
        }

        /**
         * 这是Mybatis Generator拓展插件生成的方法(请勿删除).
         * This method corresponds to the database table admin
         *
         * @mbg.generated
         * @author generator
         */
        public Builder createId(Integer createId) {
            obj.createId = createId;
            return this;
        }

        /**
         * 这是Mybatis Generator拓展插件生成的方法(请勿删除).
         * This method corresponds to the database table admin
         *
         * @mbg.generated
         * @author generator
         */
        public Builder createName(String createName) {
            obj.createName = createName;
            return this;
        }

        /**
         * 这是Mybatis Generator拓展插件生成的方法(请勿删除).
         * This method corresponds to the database table admin
         *
         * @mbg.generated
         * @author generator
         */
        public Builder createTime(String createTime) {
            obj.createTime = createTime;
            return this;
        }

        /**
         * 这是Mybatis Generator拓展插件生成的方法(请勿删除).
         * This method corresponds to the database table admin
         *
         * @mbg.generated
         * @author generator
         */
        public Admin build() {
            return this.obj;
        }
    }

    /**
     * 这是Mybatis Generator拓展插件生成的枚举(请勿删除).
     * This class corresponds to the database table admin
     *
     * @mbg.generated
     * @author generator
     */
    public enum Column {
        adminId("admin_id"),
        adminName("admin_name"),
        adminPassword("admin_password"),
        adminStatus("admin_status"),
        realName("real_name"),
        createId("create_id"),
        createName("create_name"),
        createTime("create_time");

        /**
         * 这是Mybatis Generator拓展插件生成的属性(请勿删除).
         * This field corresponds to the database table admin
         *
         * @mbg.generated
         * @author generator
         */
        private final String column;

        /**
         * 这是Mybatis Generator拓展插件生成的方法(请勿删除).
         * This method corresponds to the database table admin
         *
         * @mbg.generated
         * @author generator
         */
        public String value() {
            return this.column;
        }

        /**
         * 这是Mybatis Generator拓展插件生成的方法(请勿删除).
         * This method corresponds to the database table admin
         *
         * @mbg.generated
         * @author generator
         */
        public String getValue() {
            return this.column;
        }

        /**
         * 这是Mybatis Generator拓展插件生成的方法(请勿删除).
         * This method corresponds to the database table admin
         *
         * @mbg.generated
         * @author generator
         */
        Column(String column) {
            this.column = column;
        }

        /**
         * 这是Mybatis Generator拓展插件生成的方法(请勿删除).
         * This method corresponds to the database table admin
         *
         * @mbg.generated
         * @author generator
         */
        public String desc() {
            return this.column + " DESC";
        }

        /**
         * 这是Mybatis Generator拓展插件生成的方法(请勿删除).
         * This method corresponds to the database table admin
         *
         * @mbg.generated
         * @author generator
         */
        public String asc() {
            return this.column + " ASC";
        }
    }
}