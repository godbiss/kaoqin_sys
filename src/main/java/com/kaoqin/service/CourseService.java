package com.kaoqin.service;

import com.kaoqin.dao.CourseDao;
import com.kaoqin.pojo.Course;
import com.kaoqin.pojo.CourseExample;
import com.kaoqin.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseDao courseDao;

    @Autowired
    private KaoqingService kaoqingService;

    @Autowired
    private KechengService kechengService;

    public List<Course> getCoursebyTeacher(String teacher){
        CourseExample courseExample = new CourseExample();
        CourseExample.Criteria criteria = courseExample.createCriteria();
        criteria.andTeacherEqualTo(teacher);
        List<Course> courses = courseDao.selectByExample(courseExample);

        return courses;
    }

    public List<Course> getAllCourse(){
        CourseExample courseExample = new CourseExample();
        CourseExample.Criteria criteria = courseExample.createCriteria();
        criteria.andIdIsNotNull();
        List<Course> courses = courseDao.selectByExample(courseExample);

        return courses;
    }

    public Course getTeacherByCourse(String coursename){
        CourseExample courseExample = new CourseExample();
        CourseExample.Criteria criteria = courseExample.createCriteria();
        criteria.andCoursenameEqualTo(coursename);

        Course course = courseDao.selectByExample(courseExample).get(0);
        return course;
    }

    public Integer addCourse(Course course){
        return courseDao.insert(course);
    }

    public Integer deleteCourseById(Integer id){
        Course course = courseDao.selectByPrimaryKey(id);

        kaoqingService.deleteKaoqinlogByKechengname(course.getCoursename());
        kechengService.deleteKechengByKechengnameAll(course.getCoursename());

        return courseDao.deleteByPrimaryKey(id);
    }

}
