package com.dandelion.bean;

public class Admin {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin.admin_id
     *
     * @mbg.generated Tue Aug 13 10:22:59 CST 2019
     */
    private Integer adminId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin.admin_name
     *
     * @mbg.generated Tue Aug 13 10:22:59 CST 2019
     */
    private String adminName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin.admin_password
     *
     * @mbg.generated Tue Aug 13 10:22:59 CST 2019
     */
    private String adminPassword;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin.real_name
     *
     * @mbg.generated Tue Aug 13 10:22:59 CST 2019
     */
    private String realName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin.status
     *
     * @mbg.generated Tue Aug 13 10:22:59 CST 2019
     */
    private Boolean status;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin.admin_id
     *
     * @return the value of admin.admin_id
     *
     * @mbg.generated Tue Aug 13 10:22:59 CST 2019
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
     * @mbg.generated Tue Aug 13 10:22:59 CST 2019
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
     * @mbg.generated Tue Aug 13 10:22:59 CST 2019
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
     * @mbg.generated Tue Aug 13 10:22:59 CST 2019
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
     * @mbg.generated Tue Aug 13 10:22:59 CST 2019
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
     * @mbg.generated Tue Aug 13 10:22:59 CST 2019
     */
    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword == null ? null : adminPassword.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin.real_name
     *
     * @return the value of admin.real_name
     *
     * @mbg.generated Tue Aug 13 10:22:59 CST 2019
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
     * @mbg.generated Tue Aug 13 10:22:59 CST 2019
     */
    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin.status
     *
     * @return the value of admin.status
     *
     * @mbg.generated Tue Aug 13 10:22:59 CST 2019
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin.status
     *
     * @param status the value for admin.status
     *
     * @mbg.generated Tue Aug 13 10:22:59 CST 2019
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }
}