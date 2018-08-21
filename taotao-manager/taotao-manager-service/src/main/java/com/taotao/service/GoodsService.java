package com.taotao.service;

import com.taotao.pojo.Goods;

public interface GoodsService {
    //根据ID查询货物信息
    Object reqGoodInf(String id);

    void goodsMount(int goods_id,int oldnumber);
}
