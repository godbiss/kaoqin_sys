package com.kaoqin.dao;

import com.kaoqin.pojo.Banji;
import com.kaoqin.pojo.BanjiExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BanjiDao {
    long countByExample(BanjiExample example);

    int deleteByExample(BanjiExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Banji record);

    int insertSelective(Banji record);

    List<Banji> selectByExample(BanjiExample example);

    Banji selectByPrimaryKey(Integer id);

    Banji selectByBanjinum(String banjinum);

    int updateByExampleSelective(@Param("record") Banji record, @Param("example") BanjiExample example);

    int updateByExample(@Param("record") Banji record, @Param("example") BanjiExample example);

    int updateByPrimaryKeySelective(Banji record);

    int updateByPrimaryKey(Banji record);
}
