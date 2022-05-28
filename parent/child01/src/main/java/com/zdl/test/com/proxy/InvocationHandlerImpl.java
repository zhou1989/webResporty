package com.zdl.test.com.proxy;

import com.zdl.test.com.pojo.Subject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class InvocationHandlerImpl implements InvocationHandler {

    Subject subject;

    public InvocationHandlerImpl(Subject subject){

        this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("目标方法前置动作");
        Object obj = method.invoke(subject,args);
        System.out.print("目标方法后置动作");
        return obj;
    }
}
