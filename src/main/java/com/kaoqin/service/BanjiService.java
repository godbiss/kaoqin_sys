package com.kaoqin.service;

import com.kaoqin.dao.BanjiDao;
import com.kaoqin.pojo.Banji;
import com.kaoqin.pojo.BanjiExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BanjiService {

    @Autowired
    private BanjiDao banjiDao;

    public List<Banji> listBanji(){
        BanjiExample banjiExample = new BanjiExample();
        BanjiExample.Criteria criteria = banjiExample.createCriteria();
        criteria.andBanjinameNotEqualTo("无");
        List<Banji> banjis = banjiDao.selectByExample(banjiExample);

        return banjis;
    }

}
