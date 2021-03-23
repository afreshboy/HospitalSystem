package com.neu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * (Doctor)实体类
 *
 * @author makejava
 * @since 2020-07-15 15:31:50
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Doctor implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId(value = "docid", type = IdType.AUTO)
    private int docid;
    private int userid;
    private String name;
    private int depid;
    private String doctitle;
    private String doclevel;
    private String sex;
    private int age;
    private int initialnumber;
    private int usednumber;
    public Doctor(){}

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getDocid() {
        return docid;
    }

    public void setDocid(int docid) {
        this.docid = docid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDepid() {
        return depid;
    }

    public void setDepid(int depid) {
        this.depid = depid;
    }

    public String getDoctitle() {
        return doctitle;
    }

    public void setDoctitle(String doctitle) {
        this.doctitle = doctitle;
    }

    public String getDoclevel() {
        return doclevel;
    }

    public void setDoclevel(String doclevel) {
        this.doclevel = doclevel;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getInitialnumber() {
        return initialnumber;
    }

    public void setInitialnumber(int initialnumber) {
        this.initialnumber = initialnumber;
    }

    public int getUsednumber() {
        return usednumber;
    }

    public void setUsednumber(int usednumber) {
        this.usednumber = usednumber;
    }
}