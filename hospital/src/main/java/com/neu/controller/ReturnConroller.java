package com.neu.controller;

import cn.hutool.core.map.MapUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.neu.common.dto.SearchnumberDto;
import com.neu.common.lang.Result;
import com.neu.entity.*;
import com.neu.mapper.DepartmentMapper;
import com.neu.mapper.DoctorMapper;
import com.neu.mapper.PatientMapper;
import com.neu.mapper.RegistrationMapper;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ReturnConroller {
    @Resource
    PatientMapper patientMapper;

    @Resource
    RegistrationMapper registrationMapper;

    @Resource
    DoctorMapper doctorMapper;

    @Resource
    DepartmentMapper departmentMapper;


    @PostMapping("/returnsearch")
    public Result returnsearch(@Validated @RequestBody SearchnumberDto searchnumberDto) {
       Patient p= patientMapper.selectOne(new QueryWrapper<Patient>().eq("number",searchnumberDto.getNumber()));
       System.out.println("性别："+p.getSex());
       System.out.println(p.getAddress());
       System.out.println(p.getID());
       List<Userr>userrlist=new ArrayList<>();
        List<Registration> rl=registrationMapper.selectList(new QueryWrapper<Registration>().eq("number",searchnumberDto.getNumber()));
        for(Registration registration:rl){
            Userr userr=new Userr();
            userr.setNumber(String.valueOf(registration.getNumber()));
            userr.setName(registration.getName());
            userr.setMan(registration.getID());
            userr.setTime(registration.getRetime());
            Doctor doctor=doctorMapper.selectOne(new QueryWrapper<Doctor>().eq("docid",registration.getDocid()));
            Department dep=departmentMapper.selectOne(new QueryWrapper<Department>().eq("depid",registration.getDepid()));
            userr.setDepartment(dep.getDepname());
            userr.setDoctor(doctor.getName());
            if(registration.getRestatus()==1){
                userr.setRestatus("是");
            }else{
                userr.setRestatus("否");
            }
            if(registration.getDstatus()==1){
                userr.setDiagstatus("是");
            }else{
                userr.setDiagstatus("否");
            }
            userrlist.add(userr);

        }
        JSONArray array= JSONArray.parseArray(JSON.toJSONString(userrlist));

        String json= JSON.toJSONString(userrlist);

        System.out.println(array);
        System.out.println("-----------------------------");
        System.out.println(json);



    return Result.succ(MapUtil.builder()
    .put("name",p.getPname())
    .put("address",p.getAddress())
    .put("ID",p.getID())
    .put("list",array)
                    .map()

    );
    }
}
