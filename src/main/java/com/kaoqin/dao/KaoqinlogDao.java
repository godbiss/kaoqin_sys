package com.kaoqin.dao;

import com.kaoqin.pojo.Kaoqinlog;
import com.kaoqin.pojo.KaoqinlogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface KaoqinlogDao {
    long countByExample(KaoqinlogExample example);

    int deleteByExample(KaoqinlogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Kaoqinlog record);

    int insertSelective(Kaoqinlog record);

    List<Kaoqinlog> selectByExample(KaoqinlogExample example);

    Kaoqinlog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Kaoqinlog record, @Param("example") KaoqinlogExample example);

    int updateByExample(@Param("record") Kaoqinlog record, @Param("example") KaoqinlogExample example);

    int updateByPrimaryKeySelective(Kaoqinlog record);

    int updateByPrimaryKey(Kaoqinlog record);
}