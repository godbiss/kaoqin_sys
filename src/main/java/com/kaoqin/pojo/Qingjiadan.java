package com.kaoqin.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * t_qingjiadan
 * @author 
 */
@Data
public class Qingjiadan implements Serializable {
    private Integer id;

    private String banjinum;

    private String codenum;

    private Date createtime;

    private String qjtime1;

    private String qjtime2;

    private String qingjiacontent;

    private String shenhe;

    private String shenhecontent;

    private String username;

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
        Qingjiadan other = (Qingjiadan) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getBanjinum() == null ? other.getBanjinum() == null : this.getBanjinum().equals(other.getBanjinum()))
            && (this.getCodenum() == null ? other.getCodenum() == null : this.getCodenum().equals(other.getCodenum()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getQjtime1() == null ? other.getQjtime1() == null : this.getQjtime1().equals(other.getQjtime1()))
            && (this.getQjtime2() == null ? other.getQjtime2() == null : this.getQjtime2().equals(other.getQjtime2()))
            && (this.getQingjiacontent() == null ? other.getQingjiacontent() == null : this.getQingjiacontent().equals(other.getQingjiacontent()))
            && (this.getShenhe() == null ? other.getShenhe() == null : this.getShenhe().equals(other.getShenhe()))
            && (this.getShenhecontent() == null ? other.getShenhecontent() == null : this.getShenhecontent().equals(other.getShenhecontent()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getBanjinum() == null) ? 0 : getBanjinum().hashCode());
        result = prime * result + ((getCodenum() == null) ? 0 : getCodenum().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        result = prime * result + ((getQjtime1() == null) ? 0 : getQjtime1().hashCode());
        result = prime * result + ((getQjtime2() == null) ? 0 : getQjtime2().hashCode());
        result = prime * result + ((getQingjiacontent() == null) ? 0 : getQingjiacontent().hashCode());
        result = prime * result + ((getShenhe() == null) ? 0 : getShenhe().hashCode());
        result = prime * result + ((getShenhecontent() == null) ? 0 : getShenhecontent().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
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
        sb.append(", qjtime1=").append(qjtime1);
        sb.append(", qjtime2=").append(qjtime2);
        sb.append(", qingjiacontent=").append(qingjiacontent);
        sb.append(", shenhe=").append(shenhe);
        sb.append(", shenhecontent=").append(shenhecontent);
        sb.append(", username=").append(username);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}