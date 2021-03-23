package com.neu.common.dto;
import lombok.Data;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class RegistDto implements Serializable {

    @NotBlank(message = "身份证号不能为空")
    private String man;

    @NotBlank(message = "姓名不能为空")
    private String name;

    @NotBlank(message = "性别不能为空")
    private String sex;

    @NotBlank(message = "生日不能为空")
    private String birthday;

    @NotBlank(message = "年龄不能为空")
    private String age;

    @NotBlank(message = "年龄种类不能为空")
    private String agetype;

    @NotBlank(message = "地址不能为空")
    private String address;

    @NotBlank(message = "科室不能为空")
    private String depid;

    @NotBlank(message = "医生不能为空")
    private String docid;

    @NotBlank(message = "挂号等级不能为空")
    private String relevel;


    private boolean book;
}
