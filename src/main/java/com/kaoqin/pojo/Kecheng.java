package com.kaoqin.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * t_kecheng
 * @author 
 */
@Data
public class Kecheng implements Serializable {
    private Integer id;

    private String banji;

    private String banjinum;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createtime;

    private String kechengname1;

    private String kechengname2;

    private String kechengname3;

    private String kechengname4;

    private String kechengname5;

    private String kechengname6;

    private String kechengname7;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date shangketime;

    private static final long serialVersionUID = 1L;
}
