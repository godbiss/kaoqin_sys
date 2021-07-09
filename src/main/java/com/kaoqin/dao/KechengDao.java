package com.kaoqin.dao;

import com.kaoqin.pojo.Kecheng;
import com.kaoqin.pojo.KechengExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface KechengDao {
    long countByExample(KechengExample example);

    int deleteByExample(KechengExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Kecheng record);

    int insertSelective(Kecheng record);

    List<Kecheng> selectByExample(KechengExample example);

    Kecheng selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Kecheng record, @Param("example") KechengExample example);

    int updateByExample(@Param("record") Kecheng record, @Param("example") KechengExample example);

    int updateByPrimaryKeySelective(Kecheng record);

    int updateByPrimaryKey(Kecheng record);
}