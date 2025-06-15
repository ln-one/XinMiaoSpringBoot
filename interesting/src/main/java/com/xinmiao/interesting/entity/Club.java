package com.xinmiao.interesting.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Club") // 假设对应数据库中 Club 表，根据实际情况调整表名
public class Club {

    @Id
    private int Cid;
    private String Cname;
    private String Ctype;
    private String Cdesc;
    private String Ccontact;

    // 无参构造函数（JPA 要求）
    public Club() {
    }

    public Club(int cid, String cname, String ctype, String cdesc, String ccontact) {
        Cid = cid;
        Cname = cname;
        Ctype = ctype;
        Cdesc = cdesc;
        Ccontact = ccontact;
    }

    // Getter 和 Setter 方法
    public int getCid() {
        return Cid;
    }

    public void setCid(int cid) {
        Cid = cid;
    }

    public String getCname() {
        return Cname;
    }

    public void setCname(String cname) {
        Cname = cname;
    }

    public String getCtype() {
        return Ctype;
    }

    public void setCtype(String ctype) {
        Ctype = ctype;
    }

    public String getCdesc() {
        return Cdesc;
    }

    public void setCdesc(String cdesc) {
        Cdesc = cdesc;
    }

    public String getCcontact() {
        return Ccontact;
    }

    public void setCcontact(String ccontact) {
        Ccontact = ccontact;
    }
}