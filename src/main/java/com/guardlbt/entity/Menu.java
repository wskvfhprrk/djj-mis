package com.guardlbt.entity;

public class Menu {
    private Integer menuId;

    private String menuName;

    private String url;

    private Integer mPid;

    private String menuCode;

    private String permissionUi;

    private String permission;

    private String menuDescribe;

    private Integer orderBy;

    private Integer menuType;

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Integer getmPid() {
        return mPid;
    }

    public void setmPid(Integer mPid) {
        this.mPid = mPid;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode == null ? null : menuCode.trim();
    }

    public String getPermissionUi() {
        return permissionUi;
    }

    public void setPermissionUi(String permissionUi) {
        this.permissionUi = permissionUi == null ? null : permissionUi.trim();
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission == null ? null : permission.trim();
    }

    public String getMenuDescribe() {
        return menuDescribe;
    }

    public void setMenuDescribe(String menuDescribe) {
        this.menuDescribe = menuDescribe == null ? null : menuDescribe.trim();
    }

    public Integer getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(Integer orderBy) {
        this.orderBy = orderBy;
    }

    public Integer getMenuType() {
        return menuType;
    }

    public void setMenuType(Integer menuType) {
        this.menuType = menuType;
    }
}