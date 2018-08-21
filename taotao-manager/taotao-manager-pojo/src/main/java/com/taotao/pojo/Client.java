package com.taotao.pojo;

public class Client {
    /**
     * 客户id
     */
    private int id;
    /**
     * 客户名字
     */
    private String name;
    /**
     * 客户地址
     */
    private String address;
    /**
     * 客户手机号
     */
    private String mobile;
    /**
     * 客户性别
     */
    private String sex;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(int i) {
        switch (i){
            case 0:
                this.sex="保密";
                break;
            case 1:
                this.sex="男";
                break;
            case 2:
                this.sex="nv";
                break;
        }

    }

    public Client() {
    }

}
