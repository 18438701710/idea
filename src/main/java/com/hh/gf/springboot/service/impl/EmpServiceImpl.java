package com.hh.gf.springboot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hh.gf.springboot.entity.Emp;
import com.hh.gf.springboot.mapper.EmpMapper;
import com.hh.gf.springboot.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class EmpServiceImpl extends ServiceImpl<EmpMapper, Emp> implements EmpService {

    @Autowired
     private EmpMapper empMapper;

    @Override
    public boolean deleteEmp(Long empId){

        return empMapper.deleteById(empId)>0;
    }
}
