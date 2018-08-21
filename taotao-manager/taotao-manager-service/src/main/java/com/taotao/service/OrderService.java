package com.taotao.service;

import com.taotao.pojo.Order;

import java.util.List;

public interface OrderService {

    //查询订单id
    List<Order> reqId(int good_id, int client_id);

    //下单
    Object buyIt(String goods_id,String mobile);


}
