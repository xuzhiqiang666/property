package com.itheima.mapper;

import com.itheima.domain.Log;
import org.apache.ibatis.annotations.Insert;

public interface LogMapper {

    @Insert("insert into t_log(id,name,time,url,cost) values(#{id},#{name},#{time},#{url},#{cost})")
    public void insert(Log log);
}
