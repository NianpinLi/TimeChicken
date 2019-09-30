package com.dandelion.bean;

public class Role {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.role_id
     *
     * @mbg.generated Sun Sep 29 17:19:34 CST 2019
     */
    private Integer roleId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.role_name
     *
     * @mbg.generated Sun Sep 29 17:19:34 CST 2019
     */
    private String roleName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.role_status
     *
     * @mbg.generated Sun Sep 29 17:19:34 CST 2019
     */
    private Integer roleStatus;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.role_describe
     *
     * @mbg.generated Sun Sep 29 17:19:34 CST 2019
     */
    private String roleDescribe;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.create_id
     *
     * @mbg.generated Sun Sep 29 17:19:34 CST 2019
     */
    private Integer createId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.create_name
     *
     * @mbg.generated Sun Sep 29 17:19:34 CST 2019
     */
    private String createName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.create_time
     *
     * @mbg.generated Sun Sep 29 17:19:34 CST 2019
     */
    private String createTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.role_id
     *
     * @return the value of role.role_id
     *
     * @mbg.generated Sun Sep 29 17:19:34 CST 2019
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.role_id
     *
     * @param roleId the value for role.role_id
     *
     * @mbg.generated Sun Sep 29 17:19:34 CST 2019
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.role_name
     *
     * @return the value of role.role_name
     *
     * @mbg.generated Sun Sep 29 17:19:34 CST 2019
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.role_name
     *
     * @param roleName the value for role.role_name
     *
     * @mbg.generated Sun Sep 29 17:19:34 CST 2019
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.role_status
     *
     * @return the value of role.role_status
     *
     * @mbg.generated Sun Sep 29 17:19:34 CST 2019
     */
    public Integer getRoleStatus() {
        return roleStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.role_status
     *
     * @param roleStatus the value for role.role_status
     *
     * @mbg.generated Sun Sep 29 17:19:34 CST 2019
     */
    public void setRoleStatus(Integer roleStatus) {
        this.roleStatus = roleStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.role_describe
     *
     * @return the value of role.role_describe
     *
     * @mbg.generated Sun Sep 29 17:19:34 CST 2019
     */
    public String getRoleDescribe() {
        return roleDescribe;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.role_describe
     *
     * @param roleDescribe the value for role.role_describe
     *
     * @mbg.generated Sun Sep 29 17:19:34 CST 2019
     */
    public void setRoleDescribe(String roleDescribe) {
        this.roleDescribe = roleDescribe == null ? null : roleDescribe.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.create_id
     *
     * @return the value of role.create_id
     *
     * @mbg.generated Sun Sep 29 17:19:34 CST 2019
     */
    public Integer getCreateId() {
        return createId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.create_id
     *
     * @param createId the value for role.create_id
     *
     * @mbg.generated Sun Sep 29 17:19:34 CST 2019
     */
    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.create_name
     *
     * @return the value of role.create_name
     *
     * @mbg.generated Sun Sep 29 17:19:34 CST 2019
     */
    public String getCreateName() {
        return createName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.create_name
     *
     * @param createName the value for role.create_name
     *
     * @mbg.generated Sun Sep 29 17:19:34 CST 2019
     */
    public void setCreateName(String createName) {
        this.createName = createName == null ? null : createName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.create_time
     *
     * @return the value of role.create_time
     *
     * @mbg.generated Sun Sep 29 17:19:34 CST 2019
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.create_time
     *
     * @param createTime the value for role.create_time
     *
     * @mbg.generated Sun Sep 29 17:19:34 CST 2019
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }
}