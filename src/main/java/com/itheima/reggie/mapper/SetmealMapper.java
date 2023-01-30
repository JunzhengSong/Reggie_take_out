package com.itheima.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.reggie.entity.Setmeal;
import org.apache.ibatis.annotations.Mapper;

@Mapper //忘了加mapper注释，导致No qualifying bean of type 'com.itheima.reggie.mapper.SetmealMapper' available
public interface SetmealMapper extends BaseMapper<Setmeal> {
}
