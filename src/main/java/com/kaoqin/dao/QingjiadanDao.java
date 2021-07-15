package com.kaoqin.dao;

import com.kaoqin.pojo.Qingjiadan;
import com.kaoqin.pojo.QingjiadanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QingjiadanDao {
    long countByExample(QingjiadanExample example);

    int deleteByExample(QingjiadanExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Qingjiadan record);

    int insertSelective(Qingjiadan record);

    List<Qingjiadan> selectByExample(QingjiadanExample example);

    Qingjiadan selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Qingjiadan record, @Param("example") QingjiadanExample example);

    int updateByExample(@Param("record") Qingjiadan record, @Param("example") QingjiadanExample example);

    int updateByPrimaryKeySelective(Qingjiadan record);

    int updateByPrimaryKey(Qingjiadan record);
}