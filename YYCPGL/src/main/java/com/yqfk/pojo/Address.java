package com.yqfk.pojo;

public class Address {
    private int uId;
    private int aId;
    private String aName;
    private String address;
    private String tel;
    private String detail;
    private int def;

    public Address() {
    }

    public Address(int uId, int aId, String aName, String address, String tel, String detail, int def) {
        this.uId = uId;
        this.aId = aId;
        this.aName = aName;
        this.address = address;
        this.tel = tel;
        this.detail = detail;
        this.def = def;
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public int getaId() {
        return aId;
    }

    public void setaId(int aId) {
        this.aId = aId;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    @Override
    public String toString() {
        return "Address{" +
                "uId=" + uId +
                ", aId=" + aId +
                ", aName='" + aName + '\'' +
                ", address='" + address + '\'' +
                ", tel='" + tel + '\'' +
                ", detail='" + detail + '\'' +
                ", def=" + def +
                '}';
    }
}
