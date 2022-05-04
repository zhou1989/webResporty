package com.zdl.service.serviceimpl;

import com.zdl.mapper.ds1.ApiBlkEacBalMapper;
import com.zdl.service.TestProssService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TestProssServiceImpl implements TestProssService {

    @Resource
    ApiBlkEacBalMapper apiBlkEacBalMapper;

    @Override
    public void insertTestData() {
        apiBlkEacBalMapper.insertTestData();
        System.out.print("ooncjnkzxj");
    }
}
