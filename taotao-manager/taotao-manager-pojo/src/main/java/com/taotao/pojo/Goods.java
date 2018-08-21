package com.taotao.pojo;

public class Goods {
    /**
     * 货物id
     */
    private int id;
    /**
     * 货物名字
     */
    private String name;
    /**
     * 货物数量
     */
    private int number;
    /**
     * 货物描述
     */
    private String describe;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
