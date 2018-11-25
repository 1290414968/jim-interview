package org.study.jim.interview;

import java.io.File;
import java.lang.reflect.Field;

/**
 * @Auther: jim
 * @Date: 2018/9/25 20:41
 * @Description:
 */
public class P3 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Integer a  = 1;
        Integer b = 2;
        System.out.println("a="+a+",b="+b);
        swap(a,b);
        System.out.println("a="+a+",b="+b);
    }
    public static void swap(Integer i,Integer j) throws NoSuchFieldException, IllegalAccessException {
        Field field =  Integer.class.getDeclaredField("value");
        field.setAccessible(true);
//        Integer tmp = new Integer(i.intValue());
//        field.set(i,j);
//        field.set(j,tmp);
        int tmp = i.intValue();
        field.setInt(i,j.intValue());
        field.setInt(j,tmp);
    }
}
