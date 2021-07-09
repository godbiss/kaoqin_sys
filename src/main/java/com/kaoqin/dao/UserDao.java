package com.kaoqin.dao;

import com.kaoqin.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    User selectByEmail(String email);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}
