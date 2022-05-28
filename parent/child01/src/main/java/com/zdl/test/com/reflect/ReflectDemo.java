package com.zdl.test.com.reflect;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectDemo {

    public static void main(String[] args){

        try {
            Class clz  =Class.forName("com.zdl.test.com.pojo.Person");
            Constructor constructor = clz.getConstructor(String.class);
            Object object= constructor.newInstance("张飞");
            Constructor constructor2 =clz.getDeclaredConstructor(int.class);
            constructor2.setAccessible(true);
            Object obj= constructor2.newInstance(18);
            Field field =clz.getField("name");
            Object obj2=field.getName();
//            System.out.print(obj2);
            Field field1[] = clz.getDeclaredFields();

            Method m = clz.getMethod("say",String.class);
            Object obj3 = m.invoke(object,"关羽");
            System.out.print(obj3);
        }catch (Exception e){
            e.getCause();
        }


    }
}
