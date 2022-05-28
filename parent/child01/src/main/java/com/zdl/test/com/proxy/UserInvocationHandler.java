package com.zdl.test.com.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class UserInvocationHandler implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // object的公用方法直接调用当前invoke对象的。
        if (Object.class.equals(method.getDeclaringClass())) {
            System.out.println("*****************"+method.getDeclaringClass()+"**************");
            return method.invoke(this, args);
            // 针对接口的不同方法书写我们具体的实现
        } else if ("showName".equals(method.getName())) {
            System.out.println("张三");
        } else if ("saying".equals(method.getName())) {
            System.out.println("我叫张三");
        }
        return null;
    }

}
