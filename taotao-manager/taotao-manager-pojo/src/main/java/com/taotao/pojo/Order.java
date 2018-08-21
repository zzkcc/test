package com.taotao.pojo;

import java.sql.Date;

public class Order {
    /**
     * 订单编号
     */
    private String id;
    /**
     * 订单时间
     */
    private Date time;
    /**
     * 货物编号
     */
    private int goodId;


    /**
     * 订单状态
     */
    private Boolean state;
    /**
     * 订单客户
     */
    private Client client;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getGoodId() {
        return goodId;
    }

    public void setGoodId(int goodId) {
        this.goodId = goodId;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
