package com.neu.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.neu.entity.Patient;
import com.neu.mapper.PatientMapper;
import com.neu.service.PatientService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xumin
 * @since 2020-07-15
 */
@Service
public class PatientServiceImpl extends ServiceImpl<PatientMapper, Patient> implements PatientService {

    @Override
    public Patient getOne(Wrapper<Patient> queryWrapper, boolean throwEx) {
        return super.getOne(queryWrapper, throwEx);
    }

    @Override
    public boolean save(Patient entity) {
        return super.save(entity);
    }

    @Override
    public boolean update(Patient entity, Wrapper<Patient> updateWrapper) {
        return super.update(entity, updateWrapper);
    }

    @Override
    public boolean removeById(Serializable id) {
        return super.removeById(id);
    }
}
