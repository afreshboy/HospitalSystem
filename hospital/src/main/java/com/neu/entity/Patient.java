package com.neu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author xumin
 * @since 2020-07-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Patient implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "number", type = IdType.AUTO)
    private Integer number;

    @TableField("ID")
    private String ID;

    @TableField("pname")
    private String pname;

    @TableField("birthday")
    private String birthday;

    @TableField("address")
    private String address;

    @TableField("sex")
    private String sex;

    @TableField("age")
    private Integer age;
    public Patient(int number,String  id,String pname,String birthday,String address,String sex,int age){
        this.number=number;
        this.ID=id;
        this.pname=pname;
        this.birthday=birthday;
        this.address=address;
        this.sex=sex;
        this.age=age;
    }
    public Patient(){

    }



    public static long getSerialVersionUID() {
        return serialVersionUID;
    }


}
