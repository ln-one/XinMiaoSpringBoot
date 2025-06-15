package com.xinmiao.interesting.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "User") // 假设对应数据库中 User 表，根据实际情况调整表名
public class Freshman {

    @Id
    private int Uid;
    private String Uname;
    private String Upassword;
    private String Uemail;
    private String Uphone;
    private Date Uregtime;

    // 无参构造函数（JPA 要求）
    public Freshman() {
    }

    public Freshman(int uid, String uname, String upassword, String uemail, String uphone, Date uregtime) {
        Uid = uid;
        Uname = uname;
        Upassword = upassword;
        Uemail = uemail;
        Uphone = uphone;
        Uregtime = uregtime;
    }

    // Getter 和 Setter 方法
    public int getUid() {
        return Uid;
    }

    public void setUid(int uid) {
        Uid = uid;
    }

    public String getUname() {
        return Uname;
    }

    public void setUname(String uname) {
        Uname = uname;
    }

    public String getUpassword() {
        return Upassword;
    }

    public void setUpassword(String upassword) {
        Upassword = upassword;
    }

    public String getUemail() {
        return Uemail;
    }

    public void setUemail(String uemail) {
        Uemail = uemail;
    }

    public String getUphone() {
        return Uphone;
    }

    public void setUphone(String uphone) {
        Uphone = uphone;
    }

    public Date getUregtime() {
        return Uregtime;
    }

    public void setUregtime(Date uregtime) {
        Uregtime = uregtime;
    }
}