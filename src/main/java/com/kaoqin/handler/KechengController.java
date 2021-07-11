package com.kaoqin.handler;

import com.alibaba.fastjson.JSONObject;
import com.kaoqin.pojo.Course;
import com.kaoqin.pojo.Kecheng;
import com.kaoqin.service.CourseService;
import com.kaoqin.service.KechengService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Controller
public class KechengController {

    @Autowired
    private KechengService kechengService;

    @Autowired
    private CourseService courseService;


    @RequestMapping(value = "/kecheng/{banjinum}", method = RequestMethod.GET)
    @ResponseBody
    public List<Kecheng> listKecheng(@PathVariable("banjinum") String banjinum){
        return kechengService.getKechengByBanjinum(banjinum);
    }

    @RequestMapping(value = "/kecheng/teacher/{teacher}", method = RequestMethod.GET)
    @ResponseBody
    public List<JSONObject> getCourseByTeacher(@PathVariable("teacher") String teacher){
        List<Course> coursebyTeacher = courseService.getCoursebyTeacher(teacher);
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
                    jsonObjectList.add(jsonObject);
                }
            }
        }

        return jsonObjectList;
    }
}
