package com.xinmiao.interesting.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CampusEvent") // 假设对应数据库中 CampusEvent 表，根据实际情况调整表名
public class CampusEvent {

    @Id
    private int Eid;
    private String Ename;
    private String Etime;
    private int Locid;
    private String Eorganizer;
    private String Edesc;

    // 无参构造函数（JPA 要求）
    public CampusEvent() {
    }

    public CampusEvent(int eid, String ename, String etime, int locid, String eorganizer, String edesc) {
        Eid = eid;
        Ename = ename;
        Etime = etime;
        Locid = locid;
        Eorganizer = eorganizer;
        Edesc = edesc;
    }

    // Getter 和 Setter 方法
    public int getEid() {
        return Eid;
    }

    public void setEid(int eid) {
        Eid = eid;
    }

    public String getEname() {
        return Ename;
    }

    public void setEname(String ename) {
        Ename = ename;
    }

    public String getEtime() {
        return Etime;
    }

    public void setEtime(String etime) {
        Etime = etime;
    }

    public int getLocid() {
        return Locid;
    }

    public void setLocid(int locid) {
        Locid = locid;
    }

    public String getEorganizer() {
        return Eorganizer;
    }

    public void setEorganizer(String eorganizer) {
        Eorganizer = eorganizer;
    }

    public String getEdesc() {
        return Edesc;
    }

    public void setEdesc(String edesc) {
        Edesc = edesc;
    }
}