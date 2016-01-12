package com.lhy.adminj.basic.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

/**
 * 对象工具类
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015/10/9 19:15 Exp $
 */
public class ObjectUtil {
    /**
     * 把 Object 中所有属性为 "" 转为 null
     */
    public static void nullStringConverNull(Object obj) {
        if (obj != null) {
            Class<? extends Object> classz = obj.getClass();
            // 获取所有该对象的属性值
            Field fields[] = classz.getDeclaredFields();

            // 遍历属性值，取得所有属性为 null 值的
            for (Field field : fields) {
                try {
                    Type t = field.getGenericType();
                    if (!t.toString().equals("boolean")) {
                        Method m = classz.getMethod(getGetter(field.getName()));
                        Object name = m.invoke(obj);// 调用该字段的get方法
                        if (name != null) {
                            if (name instanceof String && "".equals(name)) {
                                Method mtd = classz.getMethod(getSetter(field.getName()),
                                        new Class[]{String.class});// 取得所需类的方法对象
                                mtd.invoke(obj, new Object[]{null});// 执行相应赋值方法
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 获得Getter方法名
     *
     * @param src 源字符串
     * @return 字符串，将src的第一个字母转换为大写，src为空时返回null
     */
    public static String getGetter(String src) {
        if (src != null) {
            StringBuffer sb = new StringBuffer(src);
            sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
            return "get" + sb.toString();
        } else {
            return null;
        }
    }

    /**
     * 获得Setter方法名
     *
     * @param src 源字符串
     * @return 字符串，将src的第一个字母转换为大写，src为空时返回null
     */
    public static String getSetter(String src) {
        if (src != null) {
            StringBuffer sb = new StringBuffer(src);
            sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
            return "set" + sb.toString();
        } else {
            return null;
        }
    }
}
