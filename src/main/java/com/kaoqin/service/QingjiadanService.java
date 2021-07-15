package com.kaoqin.service;

import com.kaoqin.dao.QingjiadanDao;
import com.kaoqin.pojo.Qingjiadan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class QingjiadanService {

    @Autowired
    private QingjiadanDao qingjiadanDao;

    public Integer addQingjiadan(String banjinum, String codenum, String qjtime1, String qjtime2, String qingjiacontent){
        Qingjiadan qingjiadan = new Qingjiadan();
        qingjiadan.setBanjinum(banjinum);
        qingjiadan.setCodenum(codenum);
        qingjiadan.setQjtime1(qjtime1);
        qingjiadan.setQjtime2(qjtime2);
        qingjiadan.setCreatetime(new Date());
        qingjiadan.setShenhe("未审核");
        qingjiadan.setQingjiacontent(qingjiacontent);

        return qingjiadanDao.insertSelective(qingjiadan);
    }

    public Integer updateQingjiadanTeacher(Integer id, String shenhe, String shenhecontent, String username){
        Qingjiadan qingjiadan = new Qingjiadan();
        qingjiadan.setId(id);
        qingjiadan.setShenhe(shenhe);
        qingjiadan.setShenhecontent(shenhecontent);
        qingjiadan.setUsername(username);

        return qingjiadanDao.updateByPrimaryKeySelective(qingjiadan);
    }
}
