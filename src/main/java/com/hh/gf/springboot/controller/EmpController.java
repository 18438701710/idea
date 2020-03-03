package com.hh.gf.springboot.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.hh.gf.springboot.core.jsonResponse.CommonResponse;
import com.hh.gf.springboot.core.jsonResponse.FailedResponse;
import com.hh.gf.springboot.core.jsonResponse.SuccessResponse;
import com.hh.gf.springboot.entity.Emp;
import com.hh.gf.springboot.helper.WrapperHelper;
import com.hh.gf.springboot.service.EmpService;
import io.swagger.annotations.ApiOperation;
import org.hibernate.validator.internal.util.StringHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author gaofei
 * @since 2020-02-14
 */
@RestController
@RequestMapping("/emp")
public class EmpController {

    private static Logger logger = LoggerFactory.getLogger(EmpController.class);

    @Autowired
    private EmpService empService;

    /**
     * 保存員工信息
     *
     * @param emp
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ApiOperation(value = "保存員工信息", notes = "保存員工信息")
    public ResponseEntity<CommonResponse> save(@RequestBody Emp emp) {

        try {
            empService.saveOrUpdate(emp);

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<CommonResponse>(FailedResponse.create(e, "保存員工信息失败"), HttpStatus.INTERNAL_SERVER_ERROR);
        }


        return new ResponseEntity<CommonResponse>(SuccessResponse.create("保存員工信息成功"), HttpStatus.OK);
    }

    /**
     * 查詢員工信息
     *
     * @param id
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "查詢員工信息", notes = "查詢員工信息")
    public ResponseEntity<CommonResponse> get(@PathVariable Long id) {
         Emp emp ;
        try {

            emp =  empService.getById(id);

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<CommonResponse>(FailedResponse.create(e, "查詢員工信息失败"), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<CommonResponse>(SuccessResponse.create(emp ,"查詢員工信息成功"), HttpStatus.OK);
    }

    /**
     * 删除員工信息
     *
     * @param id
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "删除員工信息", notes = "删除員工信息")
    public ResponseEntity<CommonResponse> delete(@PathVariable Long id) {
        try {

          empService.deleteEmp(id);

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<CommonResponse>(FailedResponse.create(e, "删除員工信息失败"), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<CommonResponse>(SuccessResponse.create("删除員工信息成功"), HttpStatus.OK);
    }

    /**
     * 查询员工信息列表
     *
     * @param emp
     */
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ApiOperation(value = "查询员工信息列表", notes = "查询员工信息列表")
    public ResponseEntity<CommonResponse> list(@RequestBody Emp emp) {

        try {

            QueryWrapper<Emp> wrapper = new WrapperHelper<Emp>().genericQueryWrapper(emp);

            List<Emp> list = empService.list(wrapper);

            return new ResponseEntity<CommonResponse>(SuccessResponse.create(list, "查询员工信息列表成功"), HttpStatus.OK);

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<CommonResponse>(FailedResponse.create(e, "查询员工信息列表失败"), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
