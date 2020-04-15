package com.neu.finalpro.pojo;

public class MainPagePojo {
    private long id;
    private String serialNum;
    private String category;
    private String name;
    private int amount;
    private double price;
    private String description;
    private String imgURL;
    private String discount;
//    private OrderPojo orderPojo;

    public MainPagePojo() {
    }

//    public OrderPojo getOrderPojo() {
//        return orderPojo;
//    }
//
//    public void setOrderPojo(OrderPojo orderPojo) {
//        this.orderPojo = orderPojo;
//    }

    public String getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(String serialNum) {
        this.serialNum = serialNum;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }
}
