package com.itheima.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.reggie.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {
    /**
     * Ctrl+B  查看接口 mybatis-plus提供了可继承的BaseMapper替我们实现了很多细节
     */
}
