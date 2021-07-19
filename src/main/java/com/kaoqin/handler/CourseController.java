package com.kaoqin.handler;

import com.alibaba.fastjson.JSONObject;
import com.kaoqin.pojo.Course;
import com.kaoqin.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.json.JsonObject;
import java.util.List;

@Controller
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping(value = "/course/list", method = RequestMethod.GET)
    @ResponseBody
    public List<Course> listAllCourse(){
        return courseService.getAllCourse();
    }

    @RequestMapping(value = "/course/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public JSONObject deleteCourse(@PathVariable Integer id){
        JSONObject res = new JSONObject();

        if(courseService.deleteCourseById(id) != 0){
            res.put("success", true);
        }else {
            res.put("success", false);
        }

        return res;
    }

    @RequestMapping(value = "/course/add", method = RequestMethod.PUT)
    @ResponseBody
    public JSONObject addCourse(@RequestBody Course req){
        JSONObject res = new JSONObject();

        if(courseService.addCourse(req) != 0){
            res.put("success", true);
        }else {
            res.put("success", false);
        }

        return res;
    }


}
