package com.hh.gf.springboot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hh.gf.springboot.entity.Dept;
import com.hh.gf.springboot.entity.Emp;
import com.hh.gf.springboot.mapper.DeptMapper;
import com.hh.gf.springboot.mapper.EmpMapper;
import com.hh.gf.springboot.service.DeptService;
import com.hh.gf.springboot.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public boolean deleteDept(Long deptId){

        return deptMapper.deleteById(deptId)>0;
    }
}
