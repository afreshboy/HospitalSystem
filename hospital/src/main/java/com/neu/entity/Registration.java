package com.neu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
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
public class Registration implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "reid", type = IdType.AUTO)
    private Integer reid;

    @TableField("ID")
    private String ID;

    @TableField("name")
    private String name;

    @TableField("sex")
    private String sex;

    @TableField("depid")
    private Integer depid;


    @TableField("docid")
    private int docid;

    @TableField("relevel")
    private String relevel;

    @TableField("book")
    private int book;

    @TableField("number")
    private int number;

    @TableField("retime")
    private String retime;

    @TableField("restatus")
    private int restatus;

    @TableField("dstatus")
    private int dstatus;

public Registration(int reid,String ID,String name,String sex,int depid,int docid,String relevel,int book,int number,String retime,int restatus,int dstatus){
    this.reid=reid;
    this.ID=ID;
    this.name=name;
    this.sex=sex;
    this.depid=depid;
    this.docid=docid;
    this.relevel=relevel;
    this.book=book;
    this.number=number;
    this.retime=retime;
    this.restatus=restatus;
    this.dstatus=dstatus;

}
public Registration(){

}


}
