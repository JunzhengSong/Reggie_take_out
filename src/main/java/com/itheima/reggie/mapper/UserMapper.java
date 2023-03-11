package com.itheima.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.reggie.entity.User;
import org.apache.ibatis.annotations.Mapper;


/**
 * @author sjz
 * @version 1.0
 * @description TODO
 * @date 2023/3/6 14:25
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
