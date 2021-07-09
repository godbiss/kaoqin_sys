package com.kaoqin.dao;

import com.kaoqin.pojo.Qingjiadan;

public interface QingjiadanDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Qingjiadan record);

    int insertSelective(Qingjiadan record);

    Qingjiadan selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Qingjiadan record);

    int updateByPrimaryKey(Qingjiadan record);
}