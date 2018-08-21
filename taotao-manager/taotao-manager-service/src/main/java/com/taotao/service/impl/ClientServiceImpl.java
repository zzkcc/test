package com.taotao.service.impl;



import com.taotao.mapper.ClientMapper;
import com.taotao.pojo.Client;
import com.taotao.service.ClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientMapper clientMapper;

    @Override //根据手机号查询客户信息
    public Object getClientByMobile(String mobile) {
//        //去除mobile字符串中的空格
//        String temp = mobile.replace(" ","");//去除所有空格后的字符串
//        //判断字符串是不是数字，符合不符合号码的格式等等......正则表达不会写
          String temp=transStr(mobile);
        Client client = clientMapper.getClientByMobile(temp);
        if(client==null){
            return new String("此手机号码不存在");
        }
        return (Client) client;
    }

    @Override//用户注册
    public boolean register(String address, String sex, String mobile, String name) {
        Object obj = getClientByMobile(mobile);//校验手机号码是否存在
        int realSex;//class中需要的性别代码
        if(obj instanceof String){
            switch (sex){
                case "保密":
                    realSex=0;
                    break;
                case "男":
                    realSex=1;
                    break;
                case "女":
                    realSex=2;
                    break;
                default:
                    realSex =0;
            }
            clientMapper.register(address, realSex, mobile, name);//插入数据库
            return true;
        }else{
             return false;
        }

    }
    //下订单时侯没有注册过的用过户临时保存，手机号识别
    public Client registerTemp(String mobile) {
        clientMapper.registerTemp(mobile);//插入数据库
        Client client = (Client)getClientByMobile(mobile);
        return client;
    }


    //去除mobile字符串中的空格
    private String transStr(String mobile){
        String temp = mobile.replace(" ","");//去除所有空格后的字符串
        //判断字符串是不是数字，符合不符合号码的格式等等......正则表达不会写
        return temp;

    }

}
