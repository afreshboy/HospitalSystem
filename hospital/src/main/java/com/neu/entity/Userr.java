package com.neu.entity;

import com.alibaba.fastjson.annotation.JSONType;

@JSONType(orders={"number" ,"name","man","time","department","doctor","restatus","diagstatus"})
public class Userr {
    private String number;
    private String name;
    private String man;
    private String time;
    private String department;
    private String doctor;
    private String restatus;
    private String diagstatus;
    public Userr(){}

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMan() {
        return man;
    }

    public void setMan(String man) {
        this.man = man;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getRestatus() {
        return restatus;
    }

    public void setRestatus(String restatus) {
        this.restatus = restatus;
    }

    public String getDiagstatus() {
        return diagstatus;
    }

    public void setDiagstatus(String diagstatus) {
        this.diagstatus = diagstatus;
    }
}
