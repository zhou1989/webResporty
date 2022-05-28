package com.zdl;

import com.zdl.test.com.proxy.UserInvocationHandler;
import com.zdl.test.com.mapper.UserMapper;

import java.lang.reflect.Proxy;


public class DynamicProxyUserMain {

    public static void main(String [] args){

        UserMapper userMapper = (UserMapper) Proxy.newProxyInstance(UserMapper.class.getClassLoader(),new Class[]{UserMapper.class}, new UserInvocationHandler());
        userMapper.showName();
        userMapper.saying();
        System.out.println(userMapper);
        System.out.println(userMapper.getClass());

    }

}
