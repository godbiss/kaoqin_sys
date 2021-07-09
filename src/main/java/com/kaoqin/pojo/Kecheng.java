package com.kaoqin.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * t_kecheng
 * @author 
 */
@Data
public class Kecheng implements Serializable {
    private Integer id;

    private String banji;

    private String banjinum;

    private Date createtime;

    private String kechengname1;

    private String kechengname2;

    private String kechengname3;

    private String kechengname4;

    private String kechengname5;

    private String kechengname6;

    private String kechengname7;

    private Date shangketime;

    private static final long serialVersionUID = 1L;
}