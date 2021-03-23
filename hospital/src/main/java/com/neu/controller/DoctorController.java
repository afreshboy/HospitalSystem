package com.neu.controller;

import com.neu.entity.Doctor;
import com.neu.service.DoctorService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Doctor)表控制层
 *
 * @author makejava
 * @since 2020-07-15 15:31:50
 */
@RestController
@RequestMapping("/doctor")
public class DoctorController {
    /**
     * 服务对象
     */
    @Resource
    private DoctorService doctorService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Doctor selectOne(Integer id) {
        return null;
    }

}