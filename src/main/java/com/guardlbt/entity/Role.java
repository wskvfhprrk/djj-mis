package com.guardlbt.entity;

import lombok.Data;

@Data
public class Role {
    private Integer roleId;

    private Integer roleName;

    private Integer roleDescribe;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }


}