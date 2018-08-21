package com.taotao.mapper;


import com.taotao.pojo.Client;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClientMapper {

    //根据手机号查询客户信息
    Client getClientByMobile(@Param("mobile")String mobile );

    //新客户注册
    void register(@Param("address")String address, @Param("sex")int sex, @Param("mobile")String mobile, @Param("name")String name);

    //只有手机号的临时注册
    void registerTemp( @Param("mobile")String mobile);


}
