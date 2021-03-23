package com.neu.controller;


import com.neu.common.lang.Result;
import com.neu.entity.User;
import com.neu.service.UserService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xumin
 * @since 2020-07-14
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @RequiresAuthentication
    @GetMapping("/index")
    public Result index() {
        User user = userService. getById(1L);
        return Result.succ(user);
    }

    @RequestMapping("/index")
    public String sayHello(){
        return "index";
    }

    @PostMapping("/save")
    public Result save(@Validated @RequestBody User user) {
        return Result.succ(user);
    }
}
