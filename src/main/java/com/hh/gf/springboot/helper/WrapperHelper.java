package com.hh.gf.springboot.helper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;

import java.lang.reflect.Field;

/**
 * <p>
 * 通过反射实现部分字段 Like Wrapper
 * </p>
 *
 * @author 王磊
 * @since 2020-01-10
 */
public class WrapperHelper<T> {

    /**
     * 动态生成标准查询 Wrapper
     * String 类型为模糊查询
     * Long 类型为精确查询
     * @param object
     * @return QueryWrapper
     */
    public QueryWrapper<T> genericQueryWrapper(T object){

        QueryWrapper<T> queryWrapper = new QueryWrapper<T>();

        for (Field field : object.getClass().getDeclaredFields()) {
            if (field.getType() == String.class) {
                String value = (String) ReflectionHelper.invokeGetter(object, field.getName());
                if (StringHelper.isNotBlank(value)){
                    queryWrapper.apply("lower(" + StringUtils.camelToUnderline(field.getName()) + ") like lower({0})", "%" + value + "%");
                }
            }

            if (field.getType() == Long.class) {
                Object value = ReflectionHelper.invokeGetter(object, field.getName());
                if (null != value){
                    queryWrapper.eq(StringUtils.camelToUnderline(field.getName()), value);
                }
            }

        }
//        System.err.println("getDeclaredFields End");

        return queryWrapper;
    }

}
