package com.taotao.controller;

import com.taotao.pojo.Client;
import com.taotao.pojo.Order;
import com.taotao.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

import static com.taotao.service.impl.GoodsServiceImpl.transStr;

@Controller
@RequestMapping("/buy")
public class OrderController {
    @Autowired
    OrderService orderService;

    @ResponseBody
    @RequestMapping(value = "/{goods_id}/{mobile}",method = RequestMethod.GET,produces ={"application/json;charset=UTF-8"})
    public String buyIt(@PathVariable String goods_id,@PathVariable String mobile){
        Object obj =orderService.buyIt(goods_id, mobile);
        if(obj instanceof String){
            return (String) obj;
        }else{
            Client client = (Client) obj;
            int id=transStr(goods_id);//处理id字符串
            List<Order> arr=orderService.reqId(id,client.getId());//获取到客户订单集合
            StringBuilder sb= new StringBuilder(10);
            for(int i=0;i<arr.size();i++){
                sb.append(arr.get(i).getId()+",");
               if(i==arr.size()-1){
                   sb.append(arr.get(i).getId()+"。");
               }
            }
            return new String("您货物ID为："+id+"的订单编号为："+sb.toString());


        }
    }
}
