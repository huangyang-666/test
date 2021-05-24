package com.huang.mapper;

import com.huang.pojo.employmee;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface employmeemapper {
    List<employmee> queryEmployees();
}
