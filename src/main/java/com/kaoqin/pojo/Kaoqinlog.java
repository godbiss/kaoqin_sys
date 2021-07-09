package com.kaoqin.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * t_kaoqinlog
 * @author 
 */
@Data
public class Kaoqinlog implements Serializable {
    private Integer id;

    private String banjinum;

    private String codenum;

    private Date createtime;

    private Integer iskuangke;

    private String kechengname;

    private Integer kuangkenum;

    private String riqi;

    private String teacher;

    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Kaoqinlog other = (Kaoqinlog) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getBanjinum() == null ? other.getBanjinum() == null : this.getBanjinum().equals(other.getBanjinum()))
            && (this.getCodenum() == null ? other.getCodenum() == null : this.getCodenum().equals(other.getCodenum()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getIskuangke() == null ? other.getIskuangke() == null : this.getIskuangke().equals(other.getIskuangke()))
            && (this.getKechengname() == null ? other.getKechengname() == null : this.getKechengname().equals(other.getKechengname()))
            && (this.getKuangkenum() == null ? other.getKuangkenum() == null : this.getKuangkenum().equals(other.getKuangkenum()))
            && (this.getRiqi() == null ? other.getRiqi() == null : this.getRiqi().equals(other.getRiqi()))
            && (this.getTeacher() == null ? other.getTeacher() == null : this.getTeacher().equals(other.getTeacher()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getBanjinum() == null) ? 0 : getBanjinum().hashCode());
        result = prime * result + ((getCodenum() == null) ? 0 : getCodenum().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        result = prime * result + ((getIskuangke() == null) ? 0 : getIskuangke().hashCode());
        result = prime * result + ((getKechengname() == null) ? 0 : getKechengname().hashCode());
        result = prime * result + ((getKuangkenum() == null) ? 0 : getKuangkenum().hashCode());
        result = prime * result + ((getRiqi() == null) ? 0 : getRiqi().hashCode());
        result = prime * result + ((getTeacher() == null) ? 0 : getTeacher().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", banjinum=").append(banjinum);
        sb.append(", codenum=").append(codenum);
        sb.append(", createtime=").append(createtime);
        sb.append(", iskuangke=").append(iskuangke);
        sb.append(", kechengname=").append(kechengname);
        sb.append(", kuangkenum=").append(kuangkenum);
        sb.append(", riqi=").append(riqi);
        sb.append(", teacher=").append(teacher);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}