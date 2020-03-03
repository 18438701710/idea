package com.hh.gf.springboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@TableName("EMP")
@ApiModel(value = "员工对象", description = "")
public class Emp {

    @TableId(type = IdType.INPUT)
    @ApiModelProperty(value = "人员工号")
    private Long empno;

    @ApiModelProperty(value = "人员姓名")
    private String ename;

    @ApiModelProperty(value = "岗位")
    private String job;

    private String mgr;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date hiredate;

    private String sal;

    private String deptno;

}
