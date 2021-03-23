package com.neu.common.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class SearchnumberDto implements Serializable {

    @NotBlank(message = "病历号不能为空")
    private String number;


}