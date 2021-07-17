package com.kaoqin.handler;

import com.alibaba.fastjson.JSONObject;
import com.kaoqin.pojo.Kaoqinlog;
import com.kaoqin.pojo.User;
import com.kaoqin.service.KaoqingService;
import com.kaoqin.service.UserService;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Controller
public class KaoqingController {

    @Autowired
    private KaoqingService kaoqingService;

    @Autowired
    private UserService userService;

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
