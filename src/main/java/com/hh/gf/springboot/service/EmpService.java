package com.hh.gf.springboot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hh.gf.springboot.entity.Emp;

public interface EmpService  extends IService<Emp> {

    /**
     * 删除员工信息
     * @param empId
     * @return
     */
     boolean deleteEmp(Long empId);
}
