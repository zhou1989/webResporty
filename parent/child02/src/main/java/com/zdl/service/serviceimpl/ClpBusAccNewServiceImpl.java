package com.zdl.service.serviceimpl;

import com.zdl.mapper.ds2.ClpBusAccNewMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class ClpBusAccNewServiceImpl {
    @Resource
    ClpBusAccNewMapper clpBusAccNewMapper;

    public int insertData(){
        int i= clpBusAccNewMapper.insertData();
        return i;
    }

}
