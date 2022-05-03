package com.zdl.mapper.ds1;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface TestProssMapper {

    public int insertTestData();

}
