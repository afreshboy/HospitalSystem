package com.neu.service.impl;

import com.neu.entity.Registration;
import com.neu.mapper.RegistrationMapper;
import com.neu.service.RegistrationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xumin
 * @since 2020-07-15
 */
@Service
public class RegistrationServiceImpl extends ServiceImpl<RegistrationMapper, Registration> implements RegistrationService {
    @Resource
    private RegistrationMapper registrationMapper;

//    @Override
//    public void regist(String ID,String name,String sex,String birthday,String age,String agetype,String address,String depid,String  docid,String relevel,int book){
//         registrationMapper.regist(ID,name,sex,birthday,Integer.parseInt(age),agetype,address,Integer.parseInt(depid),Integer.parseInt(docid),relevel,book);
//
//    }

}
