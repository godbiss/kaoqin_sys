package com.kaoqin.service;

import com.github.pagehelper.PageHelper;
import com.kaoqin.dao.QingjiadanDao;
import com.kaoqin.pojo.Qingjiadan;
import com.kaoqin.pojo.QingjiadanExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class QingjiadanService {

    @Autowired
    private QingjiadanDao qingjiadanDao;

    public Integer addQingjiadan(String banjinum, String codenum, String qjtime1, String qjtime2, String qingjiacontent, String username){
        Qingjiadan qingjiadan = new Qingjiadan();
        qingjiadan.setBanjinum(banjinum);
        qingjiadan.setCodenum(codenum);
        qingjiadan.setQjtime1(qjtime1);
        qingjiadan.setQjtime2(qjtime2);
        qingjiadan.setCreatetime(new Date());
        qingjiadan.setShenhe("未审核");
        qingjiadan.setQingjiacontent(qingjiacontent);
        qingjiadan.setUsername(username);

        return qingjiadanDao.insertSelective(qingjiadan);
    }

    public Integer updateQingjiadanTeacher(Integer id, String shenhe, String shenhecontent){
        Qingjiadan qingjiadan = new Qingjiadan();
        qingjiadan.setId(id);
        qingjiadan.setShenhe(shenhe);
        qingjiadan.setShenhecontent(shenhecontent);

        return qingjiadanDao.updateByPrimaryKeySelective(qingjiadan);
    }

    public List<Qingjiadan> listQingjiadanByUsername(String username){
        QingjiadanExample qingjiadanExample = new QingjiadanExample();
        QingjiadanExample.Criteria criteria = qingjiadanExample.createCriteria();
        criteria.andUsernameEqualTo(username);

        return qingjiadanDao.selectByExample(qingjiadanExample);
    }

    public List<Qingjiadan> listQingjiadanByCodenum(String codenum){
        QingjiadanExample qingjiadanExample = new QingjiadanExample();
        QingjiadanExample.Criteria criteria = qingjiadanExample.createCriteria();
        criteria.andCodenumEqualTo(codenum);

        return qingjiadanDao.selectByExample(qingjiadanExample);
    }

    public Integer deleteQingjiadanByBanjinum(String banjinum){
        QingjiadanExample qingjiadanExample = new QingjiadanExample();
        QingjiadanExample.Criteria criteria = qingjiadanExample.createCriteria();
        criteria.andBanjinumEqualTo(banjinum);

        return qingjiadanDao.deleteByExample(qingjiadanExample);
    }
}
