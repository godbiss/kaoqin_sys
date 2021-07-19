package com.kaoqin.handler;

import com.alibaba.fastjson.JSONObject;
import com.kaoqin.pojo.Course;
import com.kaoqin.pojo.Kaoqinlog;
import com.kaoqin.pojo.Kecheng;
import com.kaoqin.service.CourseService;
import com.kaoqin.service.KaoqingService;
import com.kaoqin.service.KechengService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

@Log4j2
@Controller
public class KechengController {

    @Autowired
    private KechengService kechengService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private KaoqingService kaoqingService;

    @RequestMapping(value = "/kecheng/{banjinum}", method = RequestMethod.GET)
    @ResponseBody
    public List<Kecheng> listKecheng(@PathVariable("banjinum") String banjinum){
        return kechengService.getKechengByBanjinum(banjinum);
    }

    @RequestMapping(value = "/kecheng/del/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public JSONObject deleteKecheng(@PathVariable Integer id){
        JSONObject jsonObject = new JSONObject();

        if(id != null && !id.equals("")){
            Kecheng kechengById = kechengService.getKechengById(id);
            Integer i = kechengService.deleteKecheng(id);

            //删除这一天的上课考勤记录
            if(kechengById.getKechengname1() != null){
                java.sql.Date shangketime = new java.sql.Date(kechengById.getShangketime().getTime());
                kaoqingService.deleteKaoqinlogByKechengname(kechengById.getKechengname1(), shangketime.toString());
            }
            if(kechengById.getKechengname2() != null){
                java.sql.Date shangketime = new java.sql.Date(kechengById.getShangketime().getTime());
                kaoqingService.deleteKaoqinlogByKechengname(kechengById.getKechengname2(), shangketime.toString());
            }
            if(kechengById.getKechengname3() != null){
                java.sql.Date shangketime = new java.sql.Date(kechengById.getShangketime().getTime());
                kaoqingService.deleteKaoqinlogByKechengname(kechengById.getKechengname3(), shangketime.toString());
            }
            if(kechengById.getKechengname4() != null){
                java.sql.Date shangketime = new java.sql.Date(kechengById.getShangketime().getTime());
                kaoqingService.deleteKaoqinlogByKechengname(kechengById.getKechengname4(), shangketime.toString());
            }
            if(kechengById.getKechengname5() != null){
                java.sql.Date shangketime = new java.sql.Date(kechengById.getShangketime().getTime());
                kaoqingService.deleteKaoqinlogByKechengname(kechengById.getKechengname5(), shangketime.toString());
            }
            if(kechengById.getKechengname6() != null){
                java.sql.Date shangketime = new java.sql.Date(kechengById.getShangketime().getTime());
                kaoqingService.deleteKaoqinlogByKechengname(kechengById.getKechengname6(), shangketime.toString());
            }
            if(kechengById.getKechengname7() != null){
                java.sql.Date shangketime = new java.sql.Date(kechengById.getShangketime().getTime());
                kaoqingService.deleteKaoqinlogByKechengname(kechengById.getKechengname7(), shangketime.toString());
            }

            if(i != 0){
                jsonObject.put("success", true);
            }else {
                jsonObject.put("success", false);
            }
        }else {
            jsonObject.put("success", false);
        }

        return jsonObject;
    }

    @RequestMapping(value = "/kecheng/update", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject updateKecheng(@RequestBody String reqstr){
        System.out.println(reqstr);
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

        System.out.println(kecheng);

        JSONObject jsonObject = new JSONObject();

        if(kecheng.getId() != null && !kecheng.getId().equals("")){
            Integer i = kechengService.updateKechengById(kecheng);
            if(i != null){
                kaoqingService.deleteKaoqinlogByRiqi(kecheng.getShangketime().toString().split(" ")[0]);

                //初始化考勤表
                if(kecheng.getKechengname1() != null){
                    kaoqingService.generateKaoqinglogIfNotExist(kecheng.getBanjinum(),
                            kecheng.getKechengname1(), timeSplit[0],
                            courseService.getTeacherByCourse(kecheng.getKechengname1()).getTeacher(), 1);
                }
                if(kecheng.getKechengname2() != null){
                    kaoqingService.generateKaoqinglogIfNotExist(kecheng.getBanjinum(),
                            kecheng.getKechengname2(), timeSplit[0],
                            courseService.getTeacherByCourse(kecheng.getKechengname2()).getTeacher(), 2);
                }
                if(kecheng.getKechengname3() != null){
                    kaoqingService.generateKaoqinglogIfNotExist(kecheng.getBanjinum(),
                            kecheng.getKechengname3(), timeSplit[0],
                            courseService.getTeacherByCourse(kecheng.getKechengname3()).getTeacher(), 3);
                }
                if(kecheng.getKechengname4() != null){
                    kaoqingService.generateKaoqinglogIfNotExist(kecheng.getBanjinum(),
                            kecheng.getKechengname4(), timeSplit[0],
                            courseService.getTeacherByCourse(kecheng.getKechengname4()).getTeacher(), 4);
                }
                if(kecheng.getKechengname5() != null){
                    kaoqingService.generateKaoqinglogIfNotExist(kecheng.getBanjinum(),
                            kecheng.getKechengname5(), timeSplit[0],
                            courseService.getTeacherByCourse(kecheng.getKechengname5()).getTeacher(), 5);
                }
                if(kecheng.getKechengname6() != null){
                    kaoqingService.generateKaoqinglogIfNotExist(kecheng.getBanjinum(),
                            kecheng.getKechengname6(), timeSplit[0],
                            courseService.getTeacherByCourse(kecheng.getKechengname6()).getTeacher(), 6);
                }
                if(kecheng.getKechengname7() != null){
                    kaoqingService.generateKaoqinglogIfNotExist(kecheng.getBanjinum(),
                            kecheng.getKechengname7(), timeSplit[0],
                            courseService.getTeacherByCourse(kecheng.getKechengname7()).getTeacher(), 7);
                }
                jsonObject.put("success", true);

            }else {
                jsonObject.put("success", false);
            }
        }else {
            Integer i = kechengService.addKecheng(kecheng);
            if(i != null){
                jsonObject.put("success", true);
                //初始化考勤表
                if(kecheng.getKechengname1() != null){
                    kaoqingService.generateKaoqinglogIfNotExist(kecheng.getBanjinum(),
                            kecheng.getKechengname1(), timeSplit[0],
                            courseService.getTeacherByCourse(kecheng.getKechengname1()).getTeacher(), 1);
                }
                if(kecheng.getKechengname2() != null){
                    kaoqingService.generateKaoqinglogIfNotExist(kecheng.getBanjinum(),
                            kecheng.getKechengname2(), timeSplit[0],
                            courseService.getTeacherByCourse(kecheng.getKechengname2()).getTeacher(), 2);
                }
                if(kecheng.getKechengname3() != null){
                    kaoqingService.generateKaoqinglogIfNotExist(kecheng.getBanjinum(),
                            kecheng.getKechengname3(), timeSplit[0],
                            courseService.getTeacherByCourse(kecheng.getKechengname3()).getTeacher(), 3);
                }
                if(kecheng.getKechengname4() != null){
                    kaoqingService.generateKaoqinglogIfNotExist(kecheng.getBanjinum(),
                            kecheng.getKechengname4(), timeSplit[0],
                            courseService.getTeacherByCourse(kecheng.getKechengname4()).getTeacher(), 4);
                }
                if(kecheng.getKechengname5() != null){
                    kaoqingService.generateKaoqinglogIfNotExist(kecheng.getBanjinum(),
                            kecheng.getKechengname5(), timeSplit[0],
                            courseService.getTeacherByCourse(kecheng.getKechengname5()).getTeacher(), 5);
                }
                if(kecheng.getKechengname6() != null){
                    kaoqingService.generateKaoqinglogIfNotExist(kecheng.getBanjinum(),
                            kecheng.getKechengname6(), timeSplit[0],
                            courseService.getTeacherByCourse(kecheng.getKechengname6()).getTeacher(), 6);
                }
                if(kecheng.getKechengname7() != null){
                    kaoqingService.generateKaoqinglogIfNotExist(kecheng.getBanjinum(),
                            kecheng.getKechengname7(), timeSplit[0],
                            courseService.getTeacherByCourse(kecheng.getKechengname7()).getTeacher(), 7);
                }
            }else {
                jsonObject.put("success", false);
            }
        }

        return jsonObject;
    }


    @RequestMapping(value = "/kecheng/teacher/{teacher}", method = RequestMethod.GET)
    @ResponseBody
    public List<JSONObject> getCourseByTeacher(@PathVariable("teacher") String teacher){
        List<Course> coursebyTeacher = courseService.getCoursebyTeacher(teacher);
        //传递给前端日期格式化
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<JSONObject> jsonObjectList = new ArrayList<>();

        for (Course course :
                coursebyTeacher) {
            List<Kecheng> kechengByKechengname1 = kechengService.getKechengByKechengname1(course.getCoursename());
            List<Kecheng> kechengByKechengname2 = kechengService.getKechengByKechengname2(course.getCoursename());
            List<Kecheng> kechengByKechengname3 = kechengService.getKechengByKechengname3(course.getCoursename());
            List<Kecheng> kechengByKechengname4 = kechengService.getKechengByKechengname4(course.getCoursename());
            List<Kecheng> kechengByKechengname5 = kechengService.getKechengByKechengname5(course.getCoursename());
            List<Kecheng> kechengByKechengname6 = kechengService.getKechengByKechengname6(course.getCoursename());
            if(kechengByKechengname1.size() > 0){
                for (Kecheng kecheng :
                        kechengByKechengname1) {
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("course", course);
                    jsonObject.put("banji", kecheng.getBanji());
                    jsonObject.put("kechengname1", kecheng.getKechengname1());
                    jsonObject.put("shangketime", simpleDateFormat.format(kecheng.getShangketime()).toString());
                    jsonObject.put("banjinum", kecheng.getBanjinum());

                    Kaoqinlog kaoqinlogTemp = kaoqingService.getKaoqinlogByBanjinumAndRiqiAndTeacher(kecheng.getBanjinum(),
                            kecheng.getKechengname1(), simpleDateFormat.format(kecheng.getShangketime()).split(" ")[0].toString(), teacher).get(0);
                    jsonObject.put("kechenglock", kaoqinlogTemp.getKechenglock());
                    jsonObject.put("qiandaotype", kaoqinlogTemp.getQiandaotype());

                    jsonObjectList.add(jsonObject);
                }
            }
            if(kechengByKechengname2.size() > 0){
                for (Kecheng kecheng :
                        kechengByKechengname2) {
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("course", course);
                    jsonObject.put("banji", kecheng.getBanji());
                    jsonObject.put("kechengname2", kecheng.getKechengname2());
                    jsonObject.put("shangketime", simpleDateFormat.format(kecheng.getShangketime()).toString());
                    jsonObject.put("banjinum", kecheng.getBanjinum());

                    Kaoqinlog kaoqinlogTemp = kaoqingService.getKaoqinlogByBanjinumAndRiqiAndTeacher(kecheng.getBanjinum(),
                            kecheng.getKechengname2(), simpleDateFormat.format(kecheng.getShangketime()).toString().split(" ")[0], teacher).get(0);
                    jsonObject.put("kechenglock", kaoqinlogTemp.getKechenglock());
                    jsonObject.put("qiandaotype", kaoqinlogTemp.getQiandaotype());
                    jsonObjectList.add(jsonObject);
                }
            }
            if(kechengByKechengname3.size() > 0){
                for (Kecheng kecheng :
                        kechengByKechengname3) {
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("course", course);
                    jsonObject.put("banji", kecheng.getBanji());
                    jsonObject.put("kechengname3", kecheng.getKechengname3());
                    jsonObject.put("shangketime", simpleDateFormat.format(kecheng.getShangketime()).toString());
                    jsonObject.put("banjinum", kecheng.getBanjinum());

                    Kaoqinlog kaoqinlogTemp = kaoqingService.getKaoqinlogByBanjinumAndRiqiAndTeacher(kecheng.getBanjinum(),
                            kecheng.getKechengname3(), simpleDateFormat.format(kecheng.getShangketime()).toString().split(" ")[0], teacher).get(0);
                    jsonObject.put("kechenglock", kaoqinlogTemp.getKechenglock());
                    jsonObject.put("qiandaotype", kaoqinlogTemp.getQiandaotype());
                    jsonObjectList.add(jsonObject);
                }
            }
            if(kechengByKechengname4.size() > 0){
                for (Kecheng kecheng :
                        kechengByKechengname4) {
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("course", course);
                    jsonObject.put("banji", kecheng.getBanji());
                    jsonObject.put("kechengname4", kecheng.getKechengname4());
                    jsonObject.put("shangketime", simpleDateFormat.format(kecheng.getShangketime()).toString());
                    jsonObject.put("banjinum", kecheng.getBanjinum());

                    Kaoqinlog kaoqinlogTemp = kaoqingService.getKaoqinlogByBanjinumAndRiqiAndTeacher(kecheng.getBanjinum(),
                            kecheng.getKechengname4(), simpleDateFormat.format(kecheng.getShangketime()).toString().split(" ")[0], teacher).get(0);
                    jsonObject.put("kechenglock", kaoqinlogTemp.getKechenglock());
                    jsonObject.put("qiandaotype", kaoqinlogTemp.getQiandaotype());
                    jsonObjectList.add(jsonObject);
                }
            }
            if(kechengByKechengname5.size() > 0){
                for (Kecheng kecheng :
                        kechengByKechengname5) {
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("course", course);
                    jsonObject.put("banji", kecheng.getBanji());
                    jsonObject.put("kechengname5", kecheng.getKechengname5());
                    jsonObject.put("shangketime", simpleDateFormat.format(kecheng.getShangketime()).toString());
                    jsonObject.put("banjinum", kecheng.getBanjinum());

                    Kaoqinlog kaoqinlogTemp = kaoqingService.getKaoqinlogByBanjinumAndRiqiAndTeacher(kecheng.getBanjinum(),
                            kecheng.getKechengname5(), simpleDateFormat.format(kecheng.getShangketime()).toString().split(" ")[0], teacher).get(0);
                    jsonObject.put("kechenglock", kaoqinlogTemp.getKechenglock());
                    jsonObject.put("qiandaotype", kaoqinlogTemp.getQiandaotype());
                    jsonObjectList.add(jsonObject);
                }
            }
            if(kechengByKechengname6.size() > 0){
                for (Kecheng kecheng :
                        kechengByKechengname6) {
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("course", course);
                    jsonObject.put("banji", kecheng.getBanji());
                    jsonObject.put("kechengname6", kecheng.getKechengname6());
                    jsonObject.put("shangketime", simpleDateFormat.format(kecheng.getShangketime()).toString());
                    jsonObject.put("banjinum", kecheng.getBanjinum());

                    Kaoqinlog kaoqinlogTemp = kaoqingService.getKaoqinlogByBanjinumAndRiqiAndTeacher(kecheng.getBanjinum(),
                            kecheng.getKechengname7(), simpleDateFormat.format(kecheng.getShangketime()).toString().split(" ")[0], teacher).get(0);
                    jsonObject.put("kechenglock", kaoqinlogTemp.getKechenglock());
                    jsonObject.put("qiandaotype", kaoqinlogTemp.getQiandaotype());
                    jsonObjectList.add(jsonObject);
                }
            }
        }

        return jsonObjectList;
    }
}
