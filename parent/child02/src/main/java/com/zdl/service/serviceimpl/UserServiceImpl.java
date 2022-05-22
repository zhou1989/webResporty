package com.zdl.service.serviceimpl;

import com.zdl.mapper.ds2.UserMapper;
import com.zdl.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;

    public String getUser(){
        return userMapper.getUser();
    }
}
