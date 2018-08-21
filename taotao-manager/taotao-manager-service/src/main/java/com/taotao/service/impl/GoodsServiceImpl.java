package com.taotao.service.impl;

import com.taotao.mapper.GoodsMapper;
import com.taotao.pojo.Goods;
import com.taotao.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    GoodsMapper goodsMapper;


    @Override
    public Object reqGoodInf(String id) {
        int rId=transStr(id);
        Object obj=goodsMapper.reqGoodsInf(rId);
        System.out.println(obj);
        if(obj instanceof Goods){
            return obj;
        }else{
            return new String("查询的商品不存在");
        }

    }

    //提取字符串中的数字
    public static int transStr(String string){
        //去除空格
        String temp= string.replace(" ","");
        StringBuilder sb = new StringBuilder(20);
        char[] ch = temp.toCharArray();
        for(char c:ch) {
            if(c>47&&c<57)
                sb.append(c);
        }
        return Integer.valueOf(sb.toString());

    }

    //下单之后商品数量减少1

    public void goodsMount(int goods_id,int oldnumber){

        goodsMapper.upDateMount(goods_id,--oldnumber);

    }




}
