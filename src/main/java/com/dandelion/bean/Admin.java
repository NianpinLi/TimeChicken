package com.dandelion.bean;

public class Admin {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin.admin_id
     *
     * @mbg.generated Wed Sep 04 11:29:47 CST 2019
     */
    private Integer adminId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin.admin_name
     *
     * @mbg.generated Wed Sep 04 11:29:47 CST 2019
     */
    private String adminName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin.admin_password
     *
     * @mbg.generated Wed Sep 04 11:29:47 CST 2019
     */
    private String adminPassword;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin.admin_status
     *
     * @mbg.generated Wed Sep 04 11:29:47 CST 2019
     */
    private Byte adminStatus;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin.real_name
     *
     * @mbg.generated Wed Sep 04 11:29:47 CST 2019
     */
    private String realName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin.create_id
     *
     * @mbg.generated Wed Sep 04 11:29:47 CST 2019
     */
    private Integer createId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin.create_name
     *
     * @mbg.generated Wed Sep 04 11:29:47 CST 2019
     */
    private String createName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin.create_time
     *
     * @mbg.generated Wed Sep 04 11:29:47 CST 2019
     */
    private String createTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin.admin_id
     *
     * @return the value of admin.admin_id
     *
     * @mbg.generated Wed Sep 04 11:29:47 CST 2019
     */
    public Integer getAdminId() {
        return adminId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin.admin_id
     *
     * @param adminId the value for admin.admin_id
     *
     * @mbg.generated Wed Sep 04 11:29:47 CST 2019
     */
    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin.admin_name
     *
     * @return the value of admin.admin_name
     *
     * @mbg.generated Wed Sep 04 11:29:47 CST 2019
     */
    public String getAdminName() {
        return adminName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin.admin_name
     *
     * @param adminName the value for admin.admin_name
     *
     * @mbg.generated Wed Sep 04 11:29:47 CST 2019
     */
    public void setAdminName(String adminName) {
        this.adminName = adminName == null ? null : adminName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin.admin_password
     *
     * @return the value of admin.admin_password
     *
     * @mbg.generated Wed Sep 04 11:29:47 CST 2019
     */
    public String getAdminPassword() {
        return adminPassword;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin.admin_password
     *
     * @param adminPassword the value for admin.admin_password
     *
     * @mbg.generated Wed Sep 04 11:29:47 CST 2019
     */
    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword == null ? null : adminPassword.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin.admin_status
     *
     * @return the value of admin.admin_status
     *
     * @mbg.generated Wed Sep 04 11:29:47 CST 2019
     */
    public Byte getAdminStatus() {
        return adminStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin.admin_status
     *
     * @param adminStatus the value for admin.admin_status
     *
     * @mbg.generated Wed Sep 04 11:29:47 CST 2019
     */
    public void setAdminStatus(Byte adminStatus) {
        this.adminStatus = adminStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin.real_name
     *
     * @return the value of admin.real_name
     *
     * @mbg.generated Wed Sep 04 11:29:47 CST 2019
     */
    public String getRealName() {
        return realName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin.real_name
     *
     * @param realName the value for admin.real_name
     *
     * @mbg.generated Wed Sep 04 11:29:47 CST 2019
     */
    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin.create_id
     *
     * @return the value of admin.create_id
     *
     * @mbg.generated Wed Sep 04 11:29:47 CST 2019
     */
    public Integer getCreateId() {
        return createId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin.create_id
     *
     * @param createId the value for admin.create_id
     *
     * @mbg.generated Wed Sep 04 11:29:47 CST 2019
     */
    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin.create_name
     *
     * @return the value of admin.create_name
     *
     * @mbg.generated Wed Sep 04 11:29:47 CST 2019
     */
    public String getCreateName() {
        return createName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin.create_name
     *
     * @param createName the value for admin.create_name
     *
     * @mbg.generated Wed Sep 04 11:29:47 CST 2019
     */
    public void setCreateName(String createName) {
        this.createName = createName == null ? null : createName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin.create_time
     *
     * @return the value of admin.create_time
     *
     * @mbg.generated Wed Sep 04 11:29:47 CST 2019
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin.create_time
     *
     * @param createTime the value for admin.create_time
     *
     * @mbg.generated Wed Sep 04 11:29:47 CST 2019
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }
}