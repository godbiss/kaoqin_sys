package com.kaoqin.service;

import com.kaoqin.dao.BanjiDao;
import com.kaoqin.pojo.Banji;
import com.kaoqin.pojo.BanjiExample;
import com.kaoqin.pojo.Kecheng;
import com.kaoqin.pojo.Qingjiadan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BanjiService {

    @Autowired
    private BanjiDao banjiDao;

    @Autowired
    private KechengService kechengService;

    @Autowired
    private KaoqingService kaoqingService;

    @Autowired
    private QingjiadanService qingjiadanService;

    public List<Banji> listBanji(){
        BanjiExample banjiExample = new BanjiExample();
        BanjiExample.Criteria criteria = banjiExample.createCriteria();
        criteria.andBanjinameNotEqualTo("无");
        List<Banji> banjis = banjiDao.selectByExample(banjiExample);

        return banjis;
    }

    public Banji getBanjiBybanjinum(String banjinum){
        BanjiExample banjiExample = new BanjiExample();
        BanjiExample.Criteria criteria = banjiExample.createCriteria();
        criteria.andBanjinumEqualTo(banjinum);
        Banji banji = banjiDao.selectByExample(banjiExample).get(0);

        return banji;
    }

    public Integer addBanji(Banji banji){
        banji.setCreatetime(new Date());
       return banjiDao.insert(banji);
    }

    public Integer deleteBanji(Integer id){
        Banji banji = banjiDao.selectByPrimaryKey(id);

        kaoqingService.deleteKaoqinlogByBanjinum(banji.getBanjinum());
        kechengService.deleteKechengByBanjinum(banji.getBanjinum());
        qingjiadanService.deleteQingjiadanByBanjinum(banji.getBanjinum());

        return banjiDao.deleteByPrimaryKey(id);
    }

    public Integer updateBanji(Banji banji){
        return banjiDao.updateByPrimaryKeySelective(banji);
    }
}
