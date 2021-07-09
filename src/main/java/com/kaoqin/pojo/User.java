package com.kaoqin.pojo;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * t_user
 * @author 
 */
@JsonIgnoreProperties(value = {"handler"})
@Data
public class User implements Serializable {
    private Integer id;

    private String banjinum;

    private String codenum;

    private Date createtime;

    private String password;

    private String email;

    private Integer role;

    private String room;

    private String username;

    private Banji banji;


}
