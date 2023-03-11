package com.itheima.reggie.common;

import lombok.Data;
import java.util.HashMap;
import java.util.Map;

/**
 * 通用的返回结果类
 * @param <T>
 * 因为数据可能是不同的对象所以使用泛型T来提高通用性
 */
@Data
public class R<T> {


    private Integer code; //编码：1成功，0和其它数字为失败

    private String msg; //错误信息

    private T data; //数据

    private Map map = new HashMap(); //动态数据
    //这里提供了几个静态方法来返回一个Result对象
    //之前是直接用构造器的set方法也可以实现同样的功能
    //不过此种方式的复用性更高
    public static <T> R<T> success(T object) {
        R<T> r = new R<T>();
        r.setData(object);//set方法  和使用属性 = 的区别？
        r.setCode(1);
        return r;
    }

    public static <T> R<T> error(String msg) {
        R<T> r = new R<>();
        r.setMsg(msg);
        r.setCode(0);
        return r;
    }

    public R<T> add(String key, Object value) {
        this.map.put(key, value);
        return this;
    }

}
