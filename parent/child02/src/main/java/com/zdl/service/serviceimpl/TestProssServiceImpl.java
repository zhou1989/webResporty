package com.zdl.service.serviceimpl;

import com.zdl.mapper.ds1.TestProssMapper;
import com.zdl.service.TestProssService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TestProssServiceImpl implements TestProssService {

    @Resource
    TestProssMapper testProssMapper;

    @Override
    public int insertTestData() {
        int n =testProssMapper.insertTestData();
        return n;
    }
}
