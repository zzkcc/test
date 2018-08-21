package com.taotao.service.impl;



import com.taotao.mapper.OrderMapper;
import com.taotao.pojo.Client;
import com.taotao.pojo.Goods;
import com.taotao.pojo.Order;
import com.taotao.service.ClientService;
import com.taotao.service.GoodsService;
import com.taotao.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.taotao.service.impl.GoodsServiceImpl.*;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    GoodsService goodsService;

    @Autowired
    ClientService clientService;


    @Override
    public List<Order> reqId(int good_id, int client_id) {

        return orderMapper.reqId(good_id,client_id);
    }

    @Override
    public Object buyIt(String goods_id, String mobile) {
        int id=transStr(goods_id);//处理id字符串
//        GoodsServiceImpl gsi = new GoodsServiceImpl();//获取一个goods服务对象
        //验证请求ID有没有，库存够不够
//       Object object= gsi.reqGoodInf(goods_id);
        Object object=goodsService.reqGoodInf(goods_id);
       if(object instanceof String){
           return new String("所需要购买的商品不存在！");
       }else{
           Goods goods = (Goods)object;
           if(goods.getNumber()<=0){
               return new String("所购买商品库存不足");
           }else{
//               ClientServiceImpl csi = new ClientServiceImpl();
               Object obj=clientService.getClientByMobile(mobile);//查询是否是老客户
               Client client =null;
               if(obj instanceof String){//不是老客户
                   client =clientService.registerTemp(mobile);//临时注册
               }else{//是老客户直接返回老客户对象
                   client=(Client)obj;
               }
               //商品数量减一
               int temp = goods.getNumber();//购买之前的数量
               int tempId=goods.getId();//临时保存商品ID
               goodsService.goodsMount(tempId,temp);//更新库存
               Date date = new Date();
               String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
               Timestamp time = Timestamp.valueOf(nowTime);
               orderMapper.buyIt(time,id,1,client.getId());//插入订单表
               return client;
           }
       }
    }



}
