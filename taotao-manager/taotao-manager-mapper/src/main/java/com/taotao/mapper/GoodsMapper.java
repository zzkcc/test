package com.taotao.mapper;

import com.taotao.pojo.Goods;
import org.apache.ibatis.annotations.Param;

public interface GoodsMapper {

    //根据货物id查询货物信息
    Goods reqGoodsInf(@Param("id") int id);

    void upDateMount(@Param("good_id") int goods_id,@Param("number") int number);
}
