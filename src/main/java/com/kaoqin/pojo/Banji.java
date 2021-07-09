package com.kaoqin.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * t_banji
 * @author 
 */
@Data
public class Banji implements Serializable {
    private Integer id;

    private String banjiname;

    private String banjinum;

    private Date createtime;

    private String yuanxi;

    private String zhuanye;

    private static final long serialVersionUID = 1L;
}