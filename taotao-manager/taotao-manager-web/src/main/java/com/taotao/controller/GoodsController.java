package com.taotao.controller;

import com.taotao.pojo.Goods;
import com.taotao.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    GoodsService goodsService;


    //根据货物ID查询货物信息
    @ResponseBody
    @RequestMapping(value="/reqGoodsInfo/{id}",method = RequestMethod.GET,produces = {"application/json;charset=UTF-8"})
    public String reqGoodsInf(@PathVariable String id){
        Object obj =goodsService.reqGoodInf(id);
        if(obj instanceof Goods){
            Goods goods = (Goods)obj;
            return "所查询货物信息为："+System.lineSeparator()+
                    "ID:"+goods.getId()+
                    ",名字："+goods.getName()+
                    ",库存："+goods.getNumber()+
                    ",货物描述："+goods.getDescribe();
        }else{
            return (String)obj;
        }

    }

}
