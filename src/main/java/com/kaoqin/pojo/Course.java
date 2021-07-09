package com.kaoqin.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * t_course
 * @author 
 */
@Data
public class Course implements Serializable {
    private Integer id;

    private String coursename;

    private String teacher;

    private static final long serialVersionUID = 1L;
}