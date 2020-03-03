package com.hh.gf.springboot.controller;

import com.hh.gf.springboot.core.jsonResponse.CommonResponse;
import com.hh.gf.springboot.core.jsonResponse.FailedResponse;
import com.hh.gf.springboot.core.jsonResponse.SuccessResponse;
import com.hh.gf.springboot.entity.Dept;
import com.hh.gf.springboot.entity.Emp;
import com.hh.gf.springboot.service.DeptService;
import com.hh.gf.springboot.service.EmpService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author gaofei
 * @since 2020-02-14
 */
@RestController
@RequestMapping("/dept")
public class DeptController {

    private static Logger logger = LoggerFactory.getLogger(DeptController.class);

    @Autowired
    private DeptService deptService;

    /**
     * 保存部门信息
     *
     * @param dept
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ApiOperation(value = "保存部门信息", notes = "保存部门信息")
    public ResponseEntity<CommonResponse> save(@RequestBody Dept dept) {

        try {
            deptService.saveOrUpdate(dept);

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<CommonResponse>(FailedResponse.create(e, "保存部门信息失败"), HttpStatus.INTERNAL_SERVER_ERROR);
        }


        return new ResponseEntity<CommonResponse>(SuccessResponse.create("保存部门信息成功"), HttpStatus.OK);
    }

    /**
     * 查詢部门信息
     *
     * @param id
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "查詢部门信息", notes = "查詢部门信息")
    public ResponseEntity<CommonResponse> get(@PathVariable Long id) {
        Dept dept ;
        try {

            dept =  deptService.getById(id);

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<CommonResponse>(FailedResponse.create(e, "查詢部门信息失败"), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<CommonResponse>(SuccessResponse.create(dept ,"查詢部门信息成功"), HttpStatus.OK);
    }

    /**
     * 删除部门信息
     *
     * @param id
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "删除部门信息", notes = "删除部门信息")
    public ResponseEntity<CommonResponse> delete(@PathVariable Long id) {
        try {

            deptService.deleteDept(id);

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<CommonResponse>(FailedResponse.create(e, "删除部门信息失败"), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<CommonResponse>(SuccessResponse.create("删除部门信息成功"), HttpStatus.OK);
    }
}
