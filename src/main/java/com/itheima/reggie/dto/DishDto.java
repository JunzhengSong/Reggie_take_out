package com.itheima.reggie.dto;
//DTO(Data Transfer Object 数据传输对象)
//一般用于展示层和服务层之间的数据传输
//传入数据和实体属性并不是一一对应的

import com.itheima.reggie.entity.Dish;
import com.itheima.reggie.entity.DishFlavor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DishDto extends Dish {//用来封装页面提交的菜品数据

    private List<DishFlavor> flavors = new ArrayList<>();

    private String categoryName;

    private Integer copies;
}
