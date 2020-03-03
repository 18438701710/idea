package com.hh.gf.springboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@TableName("DEPT")
@ApiModel(value = "部门对象", description = "")
public class Dept {

    @TableId(type = IdType.INPUT)
    private Long deptno;

    @ApiModelProperty(value = "部门姓名")
    private String dname;

    @ApiModelProperty(value = "部门地址")
    private String loc;

    @TableField(exist = false)
    @ApiModelProperty(value = "员工信息")
    private Emp emp;
}
