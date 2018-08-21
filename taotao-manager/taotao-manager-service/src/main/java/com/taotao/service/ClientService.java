package com.taotao.service;


import com.taotao.pojo.Client;

import java.util.List;

public interface ClientService {

    //根据手机号查询客户信息
    Object getClientByMobile(String mobile);

    //用户注册
    boolean register(String address, String sex, String mobile, String name);

    Client registerTemp(String mobile);
}
