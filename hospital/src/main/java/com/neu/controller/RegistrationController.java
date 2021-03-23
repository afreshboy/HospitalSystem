package com.neu.controller;


import cn.hutool.core.map.MapUtil;
import cn.hutool.db.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.neu.common.dto.LoginDto;
import com.neu.common.dto.RegistDto;
import com.neu.common.lang.Result;
import com.neu.entity.Patient;
import com.neu.entity.Registration;
import com.neu.entity.User;
import com.neu.mapper.PatientMapper;
import com.neu.mapper.RegistrationMapper;
import com.neu.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xumin
 * @since 2020-07-15
 */
@RestController
public class RegistrationController {
    @Autowired
    RegistrationService registionService;

    @Resource
    PatientMapper patientMapper;
    @Resource
    RegistrationMapper registrationMapper;



    @PostMapping("/regist")
    @ResponseBody
    public Result regist(@Validated @RequestBody RegistDto registDto) {
        System.out.println("身份证号:"+registDto.getMan());
        System.out.println(registDto.getName());
        int book=0;
        int number=0;
        int reid=0;
        if(registDto.isBook()){
            book=1;
        }else{
            book=0;
        }

        List<Patient> pl=patientMapper.selectList(new QueryWrapper<Patient>());
        List<Registration> rl=registrationMapper.selectList(new QueryWrapper<Registration>());
        if(rl.size()==0){
            reid=1;
        }
        else{
            reid=rl.get(rl.size()-1).getReid()+1;
        }

        if(pl.size()==0){
            number=1;
        }
        else{

            Patient p=patientMapper.selectOne(new QueryWrapper<Patient>().eq("Id",registDto.getMan()));
            if(p==null){
                number=pl.get(pl.size()-1).getNumber()+1;

                Patient patient=new Patient(number,registDto.getMan(),registDto.getName(),registDto.getBirthday(),registDto.getAddress(),registDto.getSex(),Integer.parseInt(registDto.getAge()));
                patientMapper.insert(patient);
            }

        }
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Registration registration=new Registration(reid,registDto.getMan(),registDto.getName(),registDto.getSex(),Integer.parseInt(registDto.getDepid()),Integer.parseInt(registDto.getDocid()),registDto.getRelevel(),book,number,sdf.format(d),0,0);
        registrationMapper.insert(registration);


        return Result.succ(MapUtil.builder()
                .put("ID", registDto.getMan())
                .put("name",registDto.getName())
                .put("book", book)
                .put("birthday", registDto.getBirthday())
                .map()
        );
    }


}
