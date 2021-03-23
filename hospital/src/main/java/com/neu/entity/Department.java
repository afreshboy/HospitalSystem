package com.neu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * @since 2020-07-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Department implements Serializable {
    public Department(){}


    private static final long serialVersionUID = 1L;

    @TableId(value = "depid", type = IdType.AUTO)
    private Integer depid;

    private String depcode;

    private String depname;

    private Integer depcategoryid;

    private Integer deptype;


}
