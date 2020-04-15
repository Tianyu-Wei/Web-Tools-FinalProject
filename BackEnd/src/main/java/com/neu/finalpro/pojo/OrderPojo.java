package com.neu.finalpro.pojo;

import javax.mail.search.SearchTerm;
import java.util.HashSet;
import java.util.Set;

public class OrderPojo {

    private String orderNum;
    private String item;
    private String status;
    private UserAccountPojo useraccountpojo;
    private Set<MainPagePojo> purchaseitem = new HashSet<>();

    public OrderPojo() {
    }

    public Set<MainPagePojo> getPurchaseitem() {
        return purchaseitem;
    }

    public void setPurchaseitem(Set<MainPagePojo> purchaseitem) {
        this.purchaseitem = purchaseitem;
    }

    public UserAccountPojo getUseraccountpojo() {
        return useraccountpojo;
    }

    public void setUseraccountpojo(UserAccountPojo useraccountpojo) {
        this.useraccountpojo = useraccountpojo;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
