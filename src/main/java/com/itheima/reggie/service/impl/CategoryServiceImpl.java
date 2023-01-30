package com.itheima.reggie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.reggie.common.CustomException;
import com.itheima.reggie.entity.Category;
import com.itheima.reggie.entity.Dish;
import com.itheima.reggie.entity.Setmeal;
import com.itheima.reggie.mapper.CategoryMapper;
import com.itheima.reggie.service.CategoryService;
import com.itheima.reggie.service.DishService;
import com.itheima.reggie.service.SetmealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {
    //需要用到的对象使用autowired注入进来
    @Autowired
    private DishService dishService;
    @Autowired
    private SetmealService setmealService;

    /**
     * 根据id删除分类，删除之前需要进行判断
     * @param id
     */
    @Override
    public void remove(Long id) {
        //sql不自己发，由框架来发，要构造一个查询条件

        //1. 查询当前分类是否关联了菜品，如果已经关联，抛出一个业务异常
        //实际上是查dish表中的category_id字段是否包含该分类
        //希望的sql语句：select count(*) from dish where category_id =  ; 根据sql组装查询条件
        LambdaQueryWrapper<Dish> dishLambdaQueryWrapper = new LambdaQueryWrapper<>();
        //添加查询条件，根据分类id进行查询
        dishLambdaQueryWrapper.eq(Dish::getCategoryId,id);
        int count1 = dishService.count(dishLambdaQueryWrapper);//怎样写了右边，自动生成左边的接收返回值？  使用.var回车


        if(count1>0){
            //已经关联菜品，抛出一个业务异常
            throw new CustomException("当前分类下关联了菜品，不能删除");//将异常信息抛出给自定义的异常类
            //要想将提示信息显示给用户，需要在全局异常处理器，统一捕获业务异常

        }

        //2. 查询当前分类是否关联了套餐，如果已经关联，抛出一个业务异常
        LambdaQueryWrapper<Setmeal> setmealLambdaQueryWrapper = new LambdaQueryWrapper<>();
        //添加查询条件
        setmealLambdaQueryWrapper.eq(Setmeal::getCategoryId,id);
        int count2 = setmealService.count();
        if(count2>0){
            //已经关联套餐，抛出一个业务异常
            throw new CustomException("当前分类下关联了套餐，不能删除");
        }
        //3. 正常删除分类
        super.removeById(id);//因为继承自serviceImpl，所有可以使用super调用父接口的方法

    }
    //继承mybatisplus的serviceimpl接口，泛型设置为mapper接口和实体类，同时实现service接口

    //报错java: 找不到符号 符号: 类
    //单独build entity module 就解决了

}
