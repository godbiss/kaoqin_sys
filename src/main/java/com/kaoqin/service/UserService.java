package com.kaoqin.service;

import com.kaoqin.dao.UserDao;
import com.kaoqin.pojo.User;
import com.kaoqin.pojo.UserExample;
import com.kaoqin.utils.MD5Utils;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Log4j2
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User getUserById(Integer id){
        return userDao.selectByPrimaryKey(id);
    }

    public User getUserByCodenum(String codenum){
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andCodenumEqualTo(codenum);
        User user = userDao.selectByExample(userExample).get(0);
        return user;
    }

    public List<User> getUserByBanjinum(String banjinum){
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andBanjinumEqualTo(banjinum);

        List<User> users = userDao.selectByExample(userExample);
        return users;
    }

    public User check(User user){
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andCodenumEqualTo(user.getCodenum());
        User userByExample = userDao.selectByExample(userExample).get(0);
        log.info(userByExample);
        if(MD5Utils.valid(user.getPassword(), userByExample.getPassword())){
            return userByExample;
        }else {
            return null;
        }

    }

    public Integer addUser(User user){
        user.setCreatetime(new Date());
        user.setPassword(MD5Utils.MD5(user.getPassword()));
        return userDao.insertSelective(user);
    }

    public Integer updateUser(User user){
        return userDao.updateByPrimaryKey(user);
    }
}
