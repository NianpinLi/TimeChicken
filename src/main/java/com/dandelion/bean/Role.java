/**
 *@author generator
 *@date 2019-10-22
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
}