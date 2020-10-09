package com.yqfk.pojo;

public class Product {
    private int pId;
    private String msg;
    private int price;
    private int num;
    private String pictureId;
    private String factory;
    private String description;

    public Product() {
    }

    public Product(int pId, String msg, int price, int num, String pictureId, String factory, String description) {
        this.pId = pId;
        this.msg = msg;
        this.price = price;
        this.num = num;
        this.pictureId = pictureId;
        this.factory = factory;
        this.description = description;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getPictureId() {
        return pictureId;
    }

    public void setPictureId(String pictureId) {
        this.pictureId = pictureId;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pId=" + pId +
                ", msg='" + msg + '\'' +
                ", price=" + price +
                ", num=" + num +
                ", pictureId='" + pictureId + '\'' +
                ", factory='" + factory + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
