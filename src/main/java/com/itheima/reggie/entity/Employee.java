package com.itheima.reggie.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 员工实体
 * 使用lombok的@Getter和@Setter注解后，与在类中生成getter、setter方法效果相同
 * @Data = @Getter+@Setter+@ToString+@EqualsAndHashCode+@RequiredArgsConstructor
 */
@Data
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String username;

    private String name;

    private String password;

    private String phone;

    private String sex;

    private String idNumber;

    private Integer status;

    //哪些属性是公共字段就在哪些属性上添加该注解，mybatisplus注解，
    @TableField(fill = FieldFill.INSERT)//插入时填充字段（填充=填充策略）
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)//插入和更新时填充字段
    private LocalDateTime updateTime;

    @TableField(fill = FieldFill.INSERT)
    private Long createUser;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long updateUser;

}
