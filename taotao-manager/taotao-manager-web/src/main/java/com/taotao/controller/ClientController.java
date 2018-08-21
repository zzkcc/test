package com.taotao.controller;


import com.taotao.pojo.Client;
import com.taotao.service.ClientService;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/client")
public class ClientController {
    @Autowired
    ClientService clientService;

    //根据手机号查询客户信息
    @ResponseBody
    @RequestMapping(value ="/getClientByMobile/{mobile}",method = RequestMethod.GET,produces = {"application/json;charset=UTF-8"})
    public String getClientByMobile(@PathVariable String mobile){
        Object obj =clientService.getClientByMobile(mobile);
        if(mobile==null|| obj instanceof String){
            return (String) obj;
        } else{
            Client client=(Client) obj;
            return "id："+client.getId()
                    +",名字："+client.getName()
                    +",性别："+client.getSex()
                    +",电话："+client.getMobile()
                    +",地址："+client.getAddress();
        }
    }
    //注册
    @ResponseBody
    @RequestMapping(value="/register/{address}/{sex}/{mobile}/{name}",method = RequestMethod.GET,produces = {"application/json;charset=UTF-8"})
    public String register(@PathVariable String address,@PathVariable String sex,@PathVariable String mobile,@PathVariable String name ){
       boolean bl =clientService.register(address,sex,mobile,name);
        Client client = (Client) clientService.getClientByMobile(mobile);
       if(bl){
           return "注册成功！您的ID是："+client.getId();
       }
          return "注册失败！您的手机号:"+client.getMobile()+"已经被"+client.getName()+"占用！！";

    }


























//
//    String 对象转换编码为utf-8
//    private static String covenString(String string){
//        try {
//            return new String(string.getBytes(),"ISO-8859-1");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace( );
//        }
//        return null;
//
//    }


}
