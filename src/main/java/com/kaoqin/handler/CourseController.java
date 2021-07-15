package com.kaoqin.handler;

import com.kaoqin.pojo.Course;
import com.kaoqin.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
