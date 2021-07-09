package com.kaoqin.service;

import com.kaoqin.dao.UserDao;
import com.kaoqin.pojo.User;
import com.kaoqin.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User getUserById(Integer id){
        return userDao.selectByPrimaryKey(id);
    }

    public User getUserByEmail(String email){return userDao.selectByEmail(email); }

    public User check(User user){
        User userByEmail = userDao.selectByEmail(user.getEmail());
        if(MD5Utils.valid(user.getPassword(), userByEmail.getPassword())){
            return userByEmail;
        }else {
            return null;
        }

    }

    public Integer addUser(User user){
        user.setPassword(MD5Utils.MD5(user.getPassword()));
        return userDao.insertSelective(user);
    }
}
