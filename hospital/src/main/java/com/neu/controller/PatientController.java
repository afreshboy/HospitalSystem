package com.neu.controller;


import com.neu.entity.Patient;
import com.neu.service.PatientService;
import com.neu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xumin
 * @since 2020-07-15
 */
@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    PatientService patientService;
    public Patient selectPatient(){
        return null;
    }
}
