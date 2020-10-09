package com.yqfk.pojo;

import java.util.Date;

public class Order {

    private int uId;
    private long oId;
    private String uName;
    private String address;
    private String tel;
    private float money;
    private String status;
    private Date orderDate;

    public Order() {
    }

    public Order(int uId, long oId, String uName, String address, String tel, float money, String status, Date orderDate) {
        this.uId = uId;
        this.oId = oId;
        this.uName = uName;
        this.address = address;
        this.tel = tel;
        this.money = money;
        this.status = status;
        this.orderDate = orderDate;
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public long getoId() {
        return oId;
    }

    public void setoId(long oId) {
        this.oId = oId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
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

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "uId=" + uId +
                ", oId=" + oId +
                ", uName='" + uName + '\'' +
                ", address='" + address + '\'' +
                ", tel='" + tel + '\'' +
                ", money=" + money +
                ", status='" + status + '\'' +
                ", orderDate=" + orderDate +
                '}';
    }
}
