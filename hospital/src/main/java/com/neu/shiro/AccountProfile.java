package com.neu.shiro;


import lombok.Data;

import java.io.Serializable;

@Data
public class AccountProfile implements Serializable {

    private int userid;

    private String username;


    private String position;

}
