package com.kaoqin.service;

import com.kaoqin.dao.KaoqinlogDao;
import com.kaoqin.pojo.Kaoqinlog;
import com.kaoqin.pojo.KaoqinlogExample;
import com.kaoqin.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class KaoqingService {

    @Autowired
    private KaoqinlogDao kaoqinlogDao;

    @Autowired
    private UserService userService;

    public Boolean generateKaoqinglogIfNotExist(String banjinum, String kechengname, String riqi, String teacher){
        List<User> userByBanjinum = userService.getUserByBanjinum(banjinum);
        boolean flag = false;
        for (User user :
                userByBanjinum) {
            KaoqinlogExample kaoqinlogExample = new KaoqinlogExample();
            KaoqinlogExample.Criteria criteria = kaoqinlogExample.createCriteria();
            criteria.andBanjinumEqualTo(user.getBanjinum()).andCodenumEqualTo(user.getCodenum())
                    .andKechengnameEqualTo(kechengname).andRiqiEqualTo(riqi).andTeacherEqualTo(teacher);

            List<Kaoqinlog> kaoqinlogs = kaoqinlogDao.selectByExample(kaoqinlogExample);
            if(kaoqinlogs.size() == 0){

                Kaoqinlog kaoqinlog = new Kaoqinlog();
                kaoqinlog.setBanjinum(user.getBanjinum());
                kaoqinlog.setCodenum(user.getCodenum());
                kaoqinlog.setCreatetime(new Date());
                kaoqinlog.setIskuangke(1);
                kaoqinlog.setKechengname(kechengname);
                kaoqinlog.setKuangkenum(1);
                kaoqinlog.setRiqi(riqi);
                kaoqinlog.setTeacher(teacher);

                if(kaoqinlogDao.insert(kaoqinlog) != 0){
                    flag = true;
                }


            }

        }

        return flag;
    }

    public List<Kaoqinlog> getKaoqinlogByBanjinumAndRiqiAndTeacher(String banjinum, String kechengname, String riqi, String teacher){
        KaoqinlogExample kaoqinlogExample = new KaoqinlogExample();
        KaoqinlogExample.Criteria criteria = kaoqinlogExample.createCriteria();
        criteria.andBanjinumEqualTo(banjinum).andRiqiEqualTo(riqi).andTeacherEqualTo(teacher).andKechengnameEqualTo(kechengname);

        List<Kaoqinlog> kaoqinlogList = kaoqinlogDao.selectByExample(kaoqinlogExample);
        return kaoqinlogList;

    }
}
