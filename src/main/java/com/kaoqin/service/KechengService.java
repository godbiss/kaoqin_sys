package com.kaoqin.service;

import com.kaoqin.dao.KechengDao;
import com.kaoqin.pojo.Kecheng;
import com.kaoqin.pojo.KechengExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class KechengService {

    @Autowired
    private KechengDao kechengDao;

    public Integer updateKechengById(Kecheng kecheng){
        return kechengDao.updateByPrimaryKey(kecheng);
    }

    public Integer addKecheng(Kecheng kecheng){
        return kechengDao.insert(kecheng);
    }

    public Integer deleteKecheng(Integer id){
        return kechengDao.deleteByPrimaryKey(id);
    }

    public Integer deleteKechengByBanjinum(String banjinum){
        KechengExample kechengExample = new KechengExample();
        KechengExample.Criteria criteria = kechengExample.createCriteria();
        criteria.andBanjinumEqualTo(banjinum);

        return kechengDao.deleteByExample(kechengExample);
    }

    public void deleteKechengByKechengnameAll(String kechengname){
        List<Kecheng> kechengByKechengname1 = getKechengByKechengname1(kechengname);
        if(kechengByKechengname1.size() != 0){
            for (Kecheng kecheng :
                    kechengByKechengname1) {
                kechengDao.deleteByPrimaryKey(kecheng.getId());
            }
        }
        List<Kecheng> kechengByKechengname2 = getKechengByKechengname1(kechengname);
        if(kechengByKechengname2.size() != 0){
            for (Kecheng kecheng :
                    kechengByKechengname2) {
                kechengDao.deleteByPrimaryKey(kecheng.getId());
            }
        }
        List<Kecheng> kechengByKechengname3 = getKechengByKechengname1(kechengname);
        if(kechengByKechengname3.size() != 0){
            for (Kecheng kecheng :
                    kechengByKechengname3) {
                kechengDao.deleteByPrimaryKey(kecheng.getId());
            }
        }
        List<Kecheng> kechengByKechengname4 = getKechengByKechengname1(kechengname);
        if(kechengByKechengname4.size() != 0){
            for (Kecheng kecheng :
                    kechengByKechengname4) {
                kechengDao.deleteByPrimaryKey(kecheng.getId());
            }
        }
        List<Kecheng> kechengByKechengname5 = getKechengByKechengname1(kechengname);
        if(kechengByKechengname1.size() != 0){
            for (Kecheng kecheng :
                    kechengByKechengname5) {
                kechengDao.deleteByPrimaryKey(kecheng.getId());
            }
        }
        List<Kecheng> kechengByKechengname6 = getKechengByKechengname1(kechengname);
        if(kechengByKechengname1.size() != 0){
            for (Kecheng kecheng :
                    kechengByKechengname6) {
                kechengDao.deleteByPrimaryKey(kecheng.getId());
            }
        }
        List<Kecheng> kechengByKechengname7 = getKechengByKechengname1(kechengname);
        if(kechengByKechengname7.size() != 0){
            for (Kecheng kecheng :
                    kechengByKechengname7) {
                kechengDao.deleteByPrimaryKey(kecheng.getId());
            }
        }
    }

    public Kecheng getKechengById(Integer id){
        return kechengDao.selectByPrimaryKey(id);
    }

    public List<Kecheng> getKechengByBanjinum(String banjinum){
        KechengExample kechengExample = new KechengExample();
        KechengExample.Criteria criteria = kechengExample.createCriteria();
        criteria.andBanjinumEqualTo(banjinum);

        List<Kecheng> kechengList = kechengDao.selectByExample(kechengExample);
        
        return kechengList;
    }

    public List<Kecheng> getKechengByKechengname1(String kechengname1){
        KechengExample kechengExample = new KechengExample();
        KechengExample.Criteria criteria = kechengExample.createCriteria();
        criteria.andKechengname1EqualTo(kechengname1);

        List<Kecheng> kechengs = kechengDao.selectByExample(kechengExample);
        return kechengs;
    }

    public List<Kecheng> getKechengByKechengname2(String kechengname2){
        KechengExample kechengExample = new KechengExample();
        KechengExample.Criteria criteria = kechengExample.createCriteria();
        criteria.andKechengname2EqualTo(kechengname2);

        List<Kecheng> kechengs = kechengDao.selectByExample(kechengExample);
        return kechengs;
    }

    public List<Kecheng> getKechengByKechengname3(String kechengname3){
        KechengExample kechengExample = new KechengExample();
        KechengExample.Criteria criteria = kechengExample.createCriteria();
        criteria.andKechengname3EqualTo(kechengname3);

        List<Kecheng> kechengs = kechengDao.selectByExample(kechengExample);
        return kechengs;
    }

    public List<Kecheng> getKechengByKechengname4(String kechengname4){
        KechengExample kechengExample = new KechengExample();
        KechengExample.Criteria criteria = kechengExample.createCriteria();
        criteria.andKechengname4EqualTo(kechengname4);

        List<Kecheng> kechengs = kechengDao.selectByExample(kechengExample);
        return kechengs;
    }

    public List<Kecheng> getKechengByKechengname5(String kechengname5){
        KechengExample kechengExample = new KechengExample();
        KechengExample.Criteria criteria = kechengExample.createCriteria();
        criteria.andKechengname5EqualTo(kechengname5);

        List<Kecheng> kechengs = kechengDao.selectByExample(kechengExample);
        return kechengs;
    }

    public List<Kecheng> getKechengByKechengname6(String kechengname6){
        KechengExample kechengExample = new KechengExample();
        KechengExample.Criteria criteria = kechengExample.createCriteria();
        criteria.andKechengname6EqualTo(kechengname6);

        List<Kecheng> kechengs = kechengDao.selectByExample(kechengExample);
        return kechengs;
    }



}
