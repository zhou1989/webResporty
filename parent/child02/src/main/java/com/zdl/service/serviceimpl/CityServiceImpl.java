package com.zdl.service.serviceimpl;

import com.zdl.mapper.ds1.CityMapper;
import com.zdl.service.CityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CityServiceImpl implements CityService {
    @Resource
    CityMapper cityMapper;

    public String getCity(){
        return cityMapper.getCity();
    }
}
