/**
 *@author generator
 *@date 2019-12-04
 */
package com.dandelion.bean;

import java.io.Serializable;

public class Role implements Serializable {
    /**
     * 角色Id
     */
    private Integer roleId;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 角色状态 0停用 1启用 -1删除
     */
    private Integer roleStatus;

    /**
     * 角色描述
     */
    private String roleDescribe;

    /**
     * 上级角色Id -1为最顶级
     */
    private Integer parentRoleId;

    /**
     * 创建人ID
     */
    private Integer createId;

    /**
     * 创建人名称
     */
    private String createName;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     *  * role
     */
    private static final long serialVersionUID = 1L;

    /**
     * 角色Id
     * @return role_id 角色Id
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * 角色Id
     * @param roleId 角色Id
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * 角色名称
     * @return role_name 角色名称
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * 角色名称
     * @param roleName 角色名称
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    /**
     * 角色状态 0停用 1启用 -1删除
     * @return role_status 角色状态 0停用 1启用 -1删除
     */
    public Integer getRoleStatus() {
        return roleStatus;
    }

    /**
     * 角色状态 0停用 1启用 -1删除
     * @param roleStatus 角色状态 0停用 1启用 -1删除
     */
    public void setRoleStatus(Integer roleStatus) {
        this.roleStatus = roleStatus;
    }

    /**
     * 角色描述
     * @return role_describe 角色描述
     */
    public String getRoleDescribe() {
        return roleDescribe;
    }

    /**
     * 角色描述
     * @param roleDescribe 角色描述
     */
    public void setRoleDescribe(String roleDescribe) {
        this.roleDescribe = roleDescribe == null ? null : roleDescribe.trim();
    }

    /**
     * 上级角色Id -1为最顶级
     * @return parent_role_id 上级角色Id -1为最顶级
     */
    public Integer getParentRoleId() {
        return parentRoleId;
    }

    /**
     * 上级角色Id -1为最顶级
     * @param parentRoleId 上级角色Id -1为最顶级
     */
    public void setParentRoleId(Integer parentRoleId) {
        this.parentRoleId = parentRoleId;
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
     * 创建人名称
     * @return create_name 创建人名称
     */
    public String getCreateName() {
        return createName;
    }

    /**
     * 创建人名称
     * @param createName 创建人名称
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
        sb.append(", roleId=").append(roleId);
        sb.append(", roleName=").append(roleName);
        sb.append(", roleStatus=").append(roleStatus);
        sb.append(", roleDescribe=").append(roleDescribe);
        sb.append(", parentRoleId=").append(parentRoleId);
        sb.append(", createId=").append(createId);
        sb.append(", createName=").append(createName);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    /**
     * 这是Mybatis Generator拓展插件生成的类(请勿删除).
     * This class corresponds to the database table role
     *
     * @mbg.generated
     * @author generator
     */
    public static class Builder {
        /**
         * 这是Mybatis Generator拓展插件生成的属性(请勿删除).
         * This field corresponds to the database table role
         *
         * @mbg.generated
         * @author generator
         */
        private Role obj;

        /**
         *自动生成方法
         */
        public Builder() {
            this.obj = new Role();
        }

        /**
         *自动生成方法
         *@param roleId generator
         *@return Builder
         */
        public Builder roleId(Integer roleId) {
            obj.roleId = roleId;
            return this;
        }

        /**
         *自动生成方法
         *@param roleName generator
         *@return Builder
         */
        public Builder roleName(String roleName) {
            obj.roleName = roleName;
            return this;
        }

        /**
         *自动生成方法
         *@param roleStatus generator
         *@return Builder
         */
        public Builder roleStatus(Integer roleStatus) {
            obj.roleStatus = roleStatus;
            return this;
        }

        /**
         *自动生成方法
         *@param roleDescribe generator
         *@return Builder
         */
        public Builder roleDescribe(String roleDescribe) {
            obj.roleDescribe = roleDescribe;
            return this;
        }

        /**
         *自动生成方法
         *@param parentRoleId generator
         *@return Builder
         */
        public Builder parentRoleId(Integer parentRoleId) {
            obj.parentRoleId = parentRoleId;
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
         *@return com.dandelion.bean.Role
         */
        public Role build() {
            return this.obj;
        }
    }

    /**
     * 这是Mybatis Generator拓展插件生成的枚举(请勿删除).
     * This class corresponds to the database table role
     *
     * @mbg.generated
     * @author generator
     */
    public enum Column {
        /**role_id */
roleId("role_id"),
        /**role_name */
roleName("role_name"),
        /**role_status */
roleStatus("role_status"),
        /**role_describe */
roleDescribe("role_describe"),
        /**parent_role_id */
parentRoleId("parent_role_id"),
        /**create_id */
createId("create_id"),
        /**create_name */
createName("create_name"),
        /**create_time */
createTime("create_time");

        /**
         * 这是Mybatis Generator拓展插件生成的属性(请勿删除).
         * This field corresponds to the database table role
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