package com.itheima.reggie.controller;

import com.itheima.reggie.common.R;
import com.itheima.reggie.entity.Employee;
import com.itheima.reggie.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RestController = @Controler+@ResponseBody（用法看一下springboot md）
 */
@Slf4j
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/login")
    /**
     * 因为前端发送的是post请求，所以使用@PostMapping
     * 因为发送的数据是json格式，所以在接收参数时要使用@RequestBody注解
     * json中的key要与类中的属性名相同才能封装成功
     */
    public R<Employee> login(@RequestBody Employee employee){
        return null;
    }
}
