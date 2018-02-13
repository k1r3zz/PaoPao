package com.user.paopao.entity;

import java.io.Serializable;

/**
 * author :kira
 * date: 2018/1/30.
 * description:登录数据
 */

public class LoginEntity implements Serializable {


    /**
     * token : 0dff1a7a4d39080dad73a67d4bcacd9f
     * sourceip : 116.228.49.54
     * name : 苏矿军AA
     * code : 77
     * loginName : 15821086864
     * userType : 1
     * roleCode :
     * parentCode :
     * storeCode : 1254845974
     * storeName : 上海汽车专卖店
     * provinceCode : 002
     * cityCode : 003
     * areaCode : 004
     * townCode :
     * address : 上海普陀区中江路389弄
     * operationtime : 2018-01-05 14:25:53
     * istimeout :
     */

    private String token;
    private String sourceip;
    private String name;
    private String code;
    private String loginName;
    private String userType;
    private String roleCode;
    private String parentCode;
    private String storeCode;
    private String storeName;
    private String provinceCode;
    private String cityCode;
    private String areaCode;
    private String townCode;
    private String address;
    private String operationtime;
    private String istimeout;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getSourceip() {
        return sourceip;
    }

    public void setSourceip(String sourceip) {
        this.sourceip = sourceip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getTownCode() {
        return townCode;
    }

    public void setTownCode(String townCode) {
        this.townCode = townCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOperationtime() {
        return operationtime;
    }

    public void setOperationtime(String operationtime) {
        this.operationtime = operationtime;
    }

    public String getIstimeout() {
        return istimeout;
    }

    public void setIstimeout(String istimeout) {
        this.istimeout = istimeout;
    }

    @Override
    public String toString() {
        return "LoginEntity{" +
                "token='" + token + '\'' +
                ", sourceip='" + sourceip + '\'' +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", loginName='" + loginName + '\'' +
                ", userType='" + userType + '\'' +
                ", roleCode='" + roleCode + '\'' +
                ", parentCode='" + parentCode + '\'' +
                ", storeCode='" + storeCode + '\'' +
                ", storeName='" + storeName + '\'' +
                ", provinceCode='" + provinceCode + '\'' +
                ", cityCode='" + cityCode + '\'' +
                ", areaCode='" + areaCode + '\'' +
                ", townCode='" + townCode + '\'' +
                ", address='" + address + '\'' +
                ", operationtime='" + operationtime + '\'' +
                ", istimeout='" + istimeout + '\'' +
                '}';
    }
}
