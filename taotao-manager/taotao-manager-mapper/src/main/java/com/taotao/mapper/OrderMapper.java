package com.taotao.mapper;

import com.taotao.pojo.Order;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.List;

public interface OrderMapper {
    //根据ID查询订单
    List<Order> reqId(@Param("goods_id") int goods_id,@Param("client_id") int client_id);

    //客户下单
    void buyIt(@Param("time")Timestamp time,@Param("goods_id") int goods_id,@Param("state") int state,@Param("client_id") int client_id);
}
