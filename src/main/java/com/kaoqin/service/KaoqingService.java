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

    public Boolean generateKaoqinglogIfNotExist(String banjinum, String kechengname,
                                                String riqi, String teacher, Integer courseIndex){
        List<User> userByBanjinum = userService.getUserByBanjinum(banjinum);
        boolean flag = false;
        for (User user :
                userByBanjinum) {
            KaoqinlogExample kaoqinlogExample = new KaoqinlogExample();
            KaoqinlogExample.Criteria criteria = kaoqinlogExample.createCriteria();
            criteria.andBanjinumEqualTo(user.getBanjinum()).andCodenumEqualTo(user.getCodenum())
                    .andKechengnameEqualTo(kechengname).andRiqiEqualTo(riqi).andTeacherEqualTo(teacher)
                    .andCourseindexEqualTo(courseIndex);

            List<Kaoqinlog> kaoqinlogs = kaoqinlogDao.selectByExample(kaoqinlogExample);
            if(kaoqinlogs.size() == 0){
//                Integer maxKuangkenum = getMaxKuangkenumByCodenumAndKechengname(user.getCodenum(), kechengname);

                Kaoqinlog kaoqinlog = new Kaoqinlog();
                kaoqinlog.setBanjinum(user.getBanjinum());
                kaoqinlog.setCodenum(user.getCodenum());
                kaoqinlog.setCreatetime(new Date());
                kaoqinlog.setIskuangke(2);
                kaoqinlog.setKechengname(kechengname);
                kaoqinlog.setKuangkenum(0);
                kaoqinlog.setRiqi(riqi);
                kaoqinlog.setTeacher(teacher);
                kaoqinlog.setCourseindex(courseIndex);
                kaoqinlog.setKechenglock(1);
                kaoqinlog.setQiandaotype(0);

                if(kaoqinlogDao.insert(kaoqinlog) != 0){
                    flag = true;
                }

            }

        }

        return flag;
    }

    public Integer getMaxKuangkenumByCodenumAndKechengname(String codenum, String kechengname){
        KaoqinlogExample kaoqinlogExample = new KaoqinlogExample();
        KaoqinlogExample.Criteria criteria = kaoqinlogExample.createCriteria();
        criteria.andCodenumEqualTo(codenum).andKechengnameEqualTo(kechengname);

        List<Kaoqinlog> kaoqinlogList = kaoqinlogDao.selectByExample(kaoqinlogExample);
        Integer maxKuangkenum = 0;
        for (Kaoqinlog kaoqinlogTemp :
                kaoqinlogList) {
            Integer tempKuangkenum = kaoqinlogTemp.getKuangkenum();
            if(tempKuangkenum > maxKuangkenum){
                maxKuangkenum = tempKuangkenum;
            }
        }

        return maxKuangkenum;

    }

    public List<Kaoqinlog> getKaoqinlogByBanjinumAndRiqiAndTeacher(String banjinum, String kechengname, String riqi, String teacher){
        KaoqinlogExample kaoqinlogExample = new KaoqinlogExample();
        KaoqinlogExample.Criteria criteria = kaoqinlogExample.createCriteria();
        criteria.andBanjinumEqualTo(banjinum).andRiqiEqualTo(riqi).andTeacherEqualTo(teacher).andKechengnameEqualTo(kechengname);

        List<Kaoqinlog> kaoqinlogList = kaoqinlogDao.selectByExample(kaoqinlogExample);
        return kaoqinlogList;

    }

    public List<Kaoqinlog> getKaoqinlogByBanjinumAndKechengname(String banjinum, String kechengname){
        KaoqinlogExample kaoqinlogExample = new KaoqinlogExample();
        KaoqinlogExample.Criteria criteria = kaoqinlogExample.createCriteria();
        criteria.andBanjinumEqualTo(banjinum);

        List<Kaoqinlog> kaoqinlogList = kaoqinlogDao.selectByExample(kaoqinlogExample);
        return kaoqinlogList;

    }

    public List<Kaoqinlog> getKaoqinlogByCodenum(String codenum){
        KaoqinlogExample kaoqinlogExample = new KaoqinlogExample();
        KaoqinlogExample.Criteria criteria = kaoqinlogExample.createCriteria();
        criteria.andCodenumEqualTo(codenum);

        return kaoqinlogDao.selectByExample(kaoqinlogExample);
    }


    public Integer updateKaoqinlogZhuangtai(Integer id, String codenum, Integer isKuangke) {
        KaoqinlogExample kaoqinlogExample = new KaoqinlogExample();
        KaoqinlogExample.Criteria criteria = kaoqinlogExample.createCriteria();
        criteria.andIdEqualTo(id);

        Kaoqinlog kaoqinlog = new Kaoqinlog();
        kaoqinlog.setId(id);
        kaoqinlog.setCodenum(codenum);
        kaoqinlog.setIskuangke(isKuangke);

        return kaoqinlogDao.updateByExampleSelective(kaoqinlog, kaoqinlogExample);
    }


    public Integer updateKaoqinlogKuangkenum(String codenum, String kechengname, Integer kuangkenum){
        KaoqinlogExample kaoqinlogExample = new KaoqinlogExample();
        KaoqinlogExample.Criteria criteria = kaoqinlogExample.createCriteria();
        criteria.andCodenumEqualTo(codenum).andKechengnameEqualTo(kechengname);

        Kaoqinlog kaoqinlog = new Kaoqinlog();
        kaoqinlog.setKuangkenum(kuangkenum);

        return kaoqinlogDao.updateByExampleSelective(kaoqinlog, kaoqinlogExample);
    }

    public Kaoqinlog getKaoqinlogById(Integer id){
        return kaoqinlogDao.selectByPrimaryKey(id);
    }

    public Integer deleteKaoqinlogByKechengname(String kechengname, String riqi){
        KaoqinlogExample kaoqinlogExample = new KaoqinlogExample();
        KaoqinlogExample.Criteria criteria = kaoqinlogExample.createCriteria();
        criteria.andKechengnameEqualTo(kechengname).andRiqiEqualTo(riqi);

        return kaoqinlogDao.deleteByExample(kaoqinlogExample);
    }

    public Integer updateKaoqinlogKechenglock(String banjinum, String kechengname, String riqi, Integer kechenglock){
        KaoqinlogExample kaoqinlogExample = new KaoqinlogExample();
        KaoqinlogExample.Criteria criteria = kaoqinlogExample.createCriteria();
        criteria.andKechengnameEqualTo(kechengname).andRiqiEqualTo(riqi).andBanjinumEqualTo(banjinum);

        //下课时将未签到的人状态改成旷课并修改旷课数
        if(kechenglock == 1){
            List<Kaoqinlog> kaoqinlogs = kaoqinlogDao.selectByExample(kaoqinlogExample);
            for (Kaoqinlog kaoqinlog :
                    kaoqinlogs) {
                if (kaoqinlog.getIskuangke() == 2) {
                    updateKaoqinlogKuangkenum(kaoqinlog.getCodenum(), kaoqinlog.getKechengname(), kaoqinlog.getKuangkenum() + 1);
                }
            }
            updateKaoqinlogZhuangtaiByBanjinumAndRiqiIfIsKuangke(banjinum, kechengname, riqi, 1);

        }

        Kaoqinlog kaoqinlog = new Kaoqinlog();
        kaoqinlog.setKechenglock(kechenglock);

        return kaoqinlogDao.updateByExampleSelective(kaoqinlog, kaoqinlogExample);

    }

    public Integer updateKaoqinlogZhuangtaiByBanjinumAndRiqiIfIsKuangke(String banjinum, String kechengname, String riqi, Integer isKuangke){
        KaoqinlogExample kaoqinlogExample = new KaoqinlogExample();
        KaoqinlogExample.Criteria criteria = kaoqinlogExample.createCriteria();
        criteria.andRiqiEqualTo(riqi).andBanjinumEqualTo(banjinum).andIskuangkeEqualTo(2).andKechengnameEqualTo(kechengname);

        Kaoqinlog kaoqinlog = new Kaoqinlog();
        kaoqinlog.setIskuangke(isKuangke);

        return kaoqinlogDao.updateByExampleSelective(kaoqinlog, kaoqinlogExample);
    }

    public Integer updateKaoqinlogQiandaotypeByBanjinumAndRiqi(String banjinum, String kechengname, String riqi, Integer qiandaotype){
        KaoqinlogExample kaoqinlogExample = new KaoqinlogExample();
        KaoqinlogExample.Criteria criteria = kaoqinlogExample.createCriteria();
        criteria.andRiqiEqualTo(riqi).andBanjinumEqualTo(banjinum).andKechengnameEqualTo(kechengname);

        Kaoqinlog kaoqinlog = new Kaoqinlog();
        kaoqinlog.setQiandaotype(qiandaotype);

        return kaoqinlogDao.updateByExampleSelective(kaoqinlog, kaoqinlogExample);
    }

    public List<Kaoqinlog> getKaoqinlogByCodenumAndKechengname(String codenum, String kechengname){
        KaoqinlogExample kaoqinlogExample = new KaoqinlogExample();
        KaoqinlogExample.Criteria criteria = kaoqinlogExample.createCriteria();
        criteria.andCodenumEqualTo(codenum).andKechengnameEqualTo(kechengname);

        return kaoqinlogDao.selectByExample(kaoqinlogExample);
    }

    public Integer deleteKaoqinlogByBanjinum(String banjinum){
        KaoqinlogExample kaoqinlogExample = new KaoqinlogExample();
        KaoqinlogExample.Criteria criteria = kaoqinlogExample.createCriteria();
        criteria.andBanjinumEqualTo(banjinum);

       return kaoqinlogDao.deleteByExample(kaoqinlogExample);
    }

    public Integer deleteKaoqinlogByRiqi(String riqi){
        KaoqinlogExample kaoqinlogExample = new KaoqinlogExample();
        KaoqinlogExample.Criteria criteria = kaoqinlogExample.createCriteria();
        criteria.andRiqiEqualTo(riqi);

       return kaoqinlogDao.deleteByExample(kaoqinlogExample);
    }

    public Integer deleteKaoqinlogByKechengname(String kechengname){
        KaoqinlogExample kaoqinlogExample = new KaoqinlogExample();
        KaoqinlogExample.Criteria criteria = kaoqinlogExample.createCriteria();
        criteria.andKechengnameEqualTo(kechengname);

        return kaoqinlogDao.deleteByExample(kaoqinlogExample);
    }
}
