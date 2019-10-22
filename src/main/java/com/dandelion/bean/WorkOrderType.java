/**
 *@author generator
 *@date 2019-10-22
 */
package com.dandelion.bean;

import java.io.Serializable;

public class WorkOrderType implements Serializable {
    /**
     * 工单类型ID
     */
    private Integer typeId;

    /**
     * 工单类型名称
     */
    private String typeName;

    /**
     * 工单类型状态 1启用 2停用
     */
    private Byte typeStatus;

    /**
     * 工单流程
     */
    private String procedure;

    /**
     * 创建人Id
     */
    private Integer createId;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 创建人姓名
     */
    private String createName;

    /**
     *  * work_order_type
     */
    private static final long serialVersionUID = 1L;

    /**
     * 工单类型ID
     * @return type_id 工单类型ID
     */
    public Integer getTypeId() {
        return typeId;
    }

    /**
     * 工单类型ID
     * @param typeId 工单类型ID
     */
    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    /**
     * 工单类型名称
     * @return type_name 工单类型名称
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * 工单类型名称
     * @param typeName 工单类型名称
     */
    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    /**
     * 工单类型状态 1启用 2停用
     * @return type_status 工单类型状态 1启用 2停用
     */
    public Byte getTypeStatus() {
        return typeStatus;
    }

    /**
     * 工单类型状态 1启用 2停用
     * @param typeStatus 工单类型状态 1启用 2停用
     */
    public void setTypeStatus(Byte typeStatus) {
        this.typeStatus = typeStatus;
    }

    /**
     * 工单流程
     * @return procedure 工单流程
     */
    public String getProcedure() {
        return procedure;
    }

    /**
     * 工单流程
     * @param procedure 工单流程
     */
    public void setProcedure(String procedure) {
        this.procedure = procedure == null ? null : procedure.trim();
    }

    /**
     * 创建人Id
     * @return create_id 创建人Id
     */
    public Integer getCreateId() {
        return createId;
    }

    /**
     * 创建人Id
     * @param createId 创建人Id
     */
    public void setCreateId(Integer createId) {
        this.createId = createId;
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
     *自动生成方法
     *@return java.lang.String
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", typeId=").append(typeId);
        sb.append(", typeName=").append(typeName);
        sb.append(", typeStatus=").append(typeStatus);
        sb.append(", procedure=").append(procedure);
        sb.append(", createId=").append(createId);
        sb.append(", createTime=").append(createTime);
        sb.append(", createName=").append(createName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}