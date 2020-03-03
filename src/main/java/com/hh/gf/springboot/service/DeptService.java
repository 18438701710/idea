package com.hh.gf.springboot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hh.gf.springboot.entity.Dept;
import com.hh.gf.springboot.entity.Emp;

public interface DeptService extends IService<Dept> {

    /**
     * 删除部门信息
     * @param deptId
     * @return
     */
    boolean deleteDept(Long deptId);
}
