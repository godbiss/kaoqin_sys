package com.kaoqin.handler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.kaoqin.pojo.Kaoqinlog;
import com.kaoqin.pojo.Kecheng;
import com.kaoqin.pojo.User;
import com.kaoqin.service.CourseService;
import com.kaoqin.service.KaoqingService;
import com.kaoqin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class KaoqingController {

    @Autowired
    private KaoqingService kaoqingService;

    @Autowired
    private UserService userService;

    @Autowired
    private CourseService courseService;

    @RequestMapping(value = "/kaoqinlog/admin/generate", method = RequestMethod.PUT)
    @ResponseBody
    public JSONObject generateKaoqinlog(@RequestBody String reqstr){
        JSONObject req = JSONObject.parseObject(reqstr);
        Date dateTemp = new Date();
        String shangketime = (String) req.get("shangketime");
        String[] timeSplit = shangketime.split(" ");
        String[] ymdsplit = timeSplit[0].split("-");

        //引用日历类设置日期
        GregorianCalendar gc = new GregorianCalendar();
        gc.set(Calendar.YEAR, Integer.parseInt(ymdsplit[0]));//设置年
        gc.set(Calendar.MONTH, Integer.parseInt(ymdsplit[1])-1);//这里0是1月..以此向后推
        gc.set(Calendar.DAY_OF_MONTH, Integer.parseInt(ymdsplit[2]));//设置天
        // 将时分秒,毫秒域清零
        gc.set(Calendar.HOUR_OF_DAY, 23);
        gc.set(Calendar.MINUTE, 59);
        gc.set(Calendar.SECOND, 59);

        dateTemp = gc.getTime();

        System.out.println(dateTemp);

        Kecheng kecheng = new Kecheng();
        if(req.get("id") != null){
            kecheng.setId((Integer) req.get("id"));
        }
        kecheng.setBanji((String) req.get("banjiname"));
        kecheng.setBanjinum((String) req.get("banjinum"));
        kecheng.setCreatetime(new Date());
        kecheng.setKechengname1((String) req.get("kechengname1"));
        kecheng.setKechengname2((String) req.get("kechengname2"));
        kecheng.setKechengname3((String) req.get("kechengname3"));
        kecheng.setKechengname4((String) req.get("kechengname4"));
        kecheng.setKechengname5((String) req.get("kechengname5"));
        kecheng.setKechengname6((String) req.get("kechengname6"));
        kecheng.setKechengname7((String) req.get("kechengname7"));
        kecheng.setShangketime(dateTemp);

        JSONObject res = new JSONObject();

        res.put("success", false);

        //初始化考勤表
        if(kecheng.getKechengname1() != null){
            kaoqingService.generateKaoqinglogIfNotExist(kecheng.getBanjinum(),
                    kecheng.getKechengname1(), timeSplit[0],
                    courseService.getTeacherByCourse(kecheng.getKechengname1()).getTeacher(), 1);
            res.put("success", true);
        }
        if(kecheng.getKechengname2() != null){
            kaoqingService.generateKaoqinglogIfNotExist(kecheng.getBanjinum(),
                    kecheng.getKechengname2(), timeSplit[0],
                    courseService.getTeacherByCourse(kecheng.getKechengname2()).getTeacher(), 2);
            res.put("success", true);
        }
        if(kecheng.getKechengname3() != null){
            kaoqingService.generateKaoqinglogIfNotExist(kecheng.getBanjinum(),
                    kecheng.getKechengname3(), timeSplit[0],
                    courseService.getTeacherByCourse(kecheng.getKechengname3()).getTeacher(), 3);
            res.put("success", true);
        }
        if(kecheng.getKechengname4() != null){
            kaoqingService.generateKaoqinglogIfNotExist(kecheng.getBanjinum(),
                    kecheng.getKechengname4(), timeSplit[0],
                    courseService.getTeacherByCourse(kecheng.getKechengname4()).getTeacher(), 4);
            res.put("success", true);
        }
        if(kecheng.getKechengname5() != null){
            kaoqingService.generateKaoqinglogIfNotExist(kecheng.getBanjinum(),
                    kecheng.getKechengname5(), timeSplit[0],
                    courseService.getTeacherByCourse(kecheng.getKechengname5()).getTeacher(), 5);
            res.put("success", true);
        }
        if(kecheng.getKechengname6() != null){
            kaoqingService.generateKaoqinglogIfNotExist(kecheng.getBanjinum(),
                    kecheng.getKechengname6(), timeSplit[0],
                    courseService.getTeacherByCourse(kecheng.getKechengname6()).getTeacher(), 6);
            res.put("success", true);
        }
        if(kecheng.getKechengname7() != null){
            kaoqingService.generateKaoqinglogIfNotExist(kecheng.getBanjinum(),
                    kecheng.getKechengname7(), timeSplit[0],
                    courseService.getTeacherByCourse(kecheng.getKechengname7()).getTeacher(), 7);
            res.put("success", true);
        }


        return res;
    }

    @RequestMapping(value = "/kaoqinlog/teacher/list", method = RequestMethod.GET)
    @ResponseBody
    public List<JSONObject> listKaoqinlog(@RequestParam("banjinum") String banjinum,
                                         @RequestParam("kechengname") String kechengname,
                                         @RequestParam("riqi") String riqi,
                                         @RequestParam("teacher") String teacher) throws IOException {
        String riqitemp = "";
        if(riqi.split("-")[1].length() == 1){
            riqitemp = riqi.split("-")[0] + "-0" + riqi.split("-")[1] + "-" + riqi.split("-")[2];
        }else if(riqi.split("-")[2].length() == 1){
            riqitemp = riqi.split("-")[0] + "-" + riqi.split("-")[1] + "-0" + riqi.split("-")[2];
        }else {
            riqitemp = riqi;
        }

        kechengname = new String(kechengname.getBytes("iso8859-1"),"utf-8");
//        kaoqingService.generateKaoqinglogIfNotExist(banjinum, kechengname, riqi, teacher);
        List<Kaoqinlog> kaoqinlogList = kaoqingService.getKaoqinlogByBanjinumAndRiqiAndTeacher(banjinum, kechengname, riqitemp, teacher);

        List<JSONObject> jsonObjectList = new ArrayList<>();

        for (Kaoqinlog kaoqinlog:
             kaoqinlogList) {
            User userByCodenum = userService.getUserByCodenum(kaoqinlog.getCodenum());
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("stdname", userByCodenum.getUsername());
            jsonObject.put("codenum", kaoqinlog.getCodenum());
            jsonObject.put("banjinum", kaoqinlog.getBanjinum());
            jsonObject.put("banjiname", userByCodenum.getBanji().getBanjiname());
            jsonObject.put("isKuangke", kaoqinlog.getIskuangke());
            jsonObject.put("kuangkenum", kaoqinlog.getKuangkenum());
            jsonObject.put("kaoqinlogid", kaoqinlog.getId());
//            jsonObject.put("kechenglock", kaoqinlog.getKechenglock());
//            jsonObject.put("qiandaotype", kaoqinlog.getQiandaotype());

            jsonObjectList.add(jsonObject);
        }

        return jsonObjectList;
    }

    @RequestMapping(value = "/kaoqinlog/teacher/update/kechenglock", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject updateKaoqinlogKechenglock(@RequestBody JSONObject req){
        String banjinum = (String) req.get("banjinum");
        String kechengname = (String) req.get("kechengname");
        String riqi = (String) req.get("riqi");
        Integer kechenglock = (Integer) req.get("kechenglock");

        String riqitemp = "";
        if(riqi.split("-")[1].length() == 1){
            riqitemp = riqi.split("-")[0] + "-0" + riqi.split("-")[1] + "-" + riqi.split("-")[2];
        }else if(riqi.split("-")[2].length() == 1){
            riqitemp = riqi.split("-")[0] + "-" + riqi.split("-")[1] + "-0" + riqi.split("-")[2];
        }else {
            riqitemp = riqi;
        }

        JSONObject resp = new JSONObject();
        if(kaoqingService.updateKaoqinlogKechenglock(banjinum, kechengname, riqitemp, kechenglock) != 0){
            resp.put("success", true);
        }else {
            resp.put("success", false);
        }

        return resp;
    }

    @RequestMapping(value = "/kaoqinlog/teacher/update", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject updateKaoqinlogZhuangtai(@RequestBody JSONObject req){
        Integer id = (Integer) req.get("id");
        String codenum = (String) req.get("codenum");
        String kechengname = (String) req.get("kechengname");
        Integer isKuangke = (Integer) req.get("isKuangke");
        Integer kuangkenum = (Integer) req.get("kuangkenum");

        Kaoqinlog kaoqinlogById = kaoqingService.getKaoqinlogById(id);
        if(kaoqinlogById.getIskuangke() != isKuangke){
            if(isKuangke == 1 && kaoqinlogById.getIskuangke() == 2){
                kuangkenum = kuangkenum + 1;
            }else if(isKuangke == 1 && kaoqinlogById.getIskuangke() == 0){
                kuangkenum = kuangkenum + 1;
            }else if(isKuangke == 0 && kaoqinlogById.getIskuangke() == 1){
                kuangkenum = kuangkenum - 1;
            }
        }

        Integer integer = kaoqingService.updateKaoqinlogZhuangtai(id, codenum, isKuangke);
        Integer integer1 = kaoqingService.updateKaoqinlogKuangkenum(codenum, kechengname, kuangkenum);
        JSONObject res = new JSONObject();
        if(integer != 0 && integer1 != 0){
            res.put("success", true);
        }else {
            res.put("success", false);
        }


        return res;
    }

    @RequestMapping(value = "/kaoqinlog/student/update", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject updateKaoqinlogZhuangtaiForStd(@RequestBody JSONObject req){
        Integer id = (Integer) req.get("id");
        String codenum = (String) req.get("codenum");
        String kechengname = (String) req.get("kechengname");
        Integer isKuangke = (Integer) req.get("isKuangke");
        Integer kuangkenum = (Integer) req.get("kuangkenum");
        Integer qiandaotype = (Integer) req.get("qiandaotype");

        System.out.println(kuangkenum);

        Kaoqinlog kaoqinlogById = kaoqingService.getKaoqinlogById(id);
        if(qiandaotype == kaoqinlogById.getQiandaotype()){
            if(kaoqinlogById.getIskuangke() != isKuangke){
                if(isKuangke == 1 && kaoqinlogById.getIskuangke() == 2){
                    kuangkenum = kuangkenum + 1;
                }else if(isKuangke == 1 && kaoqinlogById.getIskuangke() == 0){
                    kuangkenum = kuangkenum + 1;
                }else if(isKuangke == 0 && kaoqinlogById.getIskuangke() == 1){
                    kuangkenum = kuangkenum - 1;
                }
            }
        }

        Integer integer = kaoqingService.updateKaoqinlogZhuangtai(id, codenum, isKuangke);
        Integer integer1 = kaoqingService.updateKaoqinlogKuangkenum(codenum, kechengname, kuangkenum);
        JSONObject res = new JSONObject();
        if(integer != 0 && integer1 != 0){
            res.put("success", true);
        }else {
            res.put("success", false);
        }


        return res;
    }

    @RequestMapping(value = "/kaoqinlog/teacher/update/qiandaotype", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject updateQiandaotype(@RequestBody JSONObject req) {
        String banjinum = (String) req.get("banjinum");
        String kechengname = (String) req.get("kechengname");
        String riqi = (String) req.get("riqi");
        Integer qiandaotype = (Integer) req.get("qiandaotype");

        String riqitemp = "";
        if (riqi.split("-")[1].length() == 1) {
            riqitemp = riqi.split("-")[0] + "-0" + riqi.split("-")[1] + "-" + riqi.split("-")[2];
        }else if(riqi.split("-")[2].length() == 1){
            riqitemp = riqi.split("-")[0] + "-" + riqi.split("-")[1] + "-0" + riqi.split("-")[2];
        }else {
            riqitemp = riqi;
        }

        JSONObject res = new JSONObject();

        Integer integer = kaoqingService.updateKaoqinlogQiandaotypeByBanjinumAndRiqi(banjinum, kechengname, riqitemp, qiandaotype);
        if (integer != 0) {
            res.put("success", true);
        } else {
            res.put("success", false);
        }

        return res;
    }

    @RequestMapping(value = "/kaoqinlog/student/list/{codenum}", method = RequestMethod.GET)
    @ResponseBody
    public List<Kaoqinlog> listKaoqinlogForStd(@PathVariable("codenum") String codenum){

        return  kaoqingService.getKaoqinlogByCodenum(codenum);
    }


    @RequestMapping(value = "/kaoqinlog/student/baogao/{codenum}/{kechengname}", method = RequestMethod.GET)
    @ResponseBody
    public List<Kaoqinlog> getBaogaoByWeek(@PathVariable("codenum") String codenum,
                                           @PathVariable("kechengname") String kechengnamePath) throws UnsupportedEncodingException, ParseException {
        String kechengname = new String(kechengnamePath.getBytes("iso8859-1"), "utf-8");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        List<Kaoqinlog> res = new ArrayList<>();

        GregorianCalendar calendar = new GregorianCalendar();
        GregorianCalendar calendar2 = new GregorianCalendar();
        calendar.setTime(new Date());

        List<Kaoqinlog> kaoqinlogs = kaoqingService.getKaoqinlogByCodenumAndKechengname(codenum, kechengname);
        for (Kaoqinlog kaoqinlog :
                kaoqinlogs) {
            calendar2.setTime(simpleDateFormat.parse(kaoqinlog.getRiqi()));
            if(calendar.getWeeksInWeekYear() == calendar2.getWeeksInWeekYear()){
                res.add(kaoqinlog);
            }

        }

        return res;
    }
}
