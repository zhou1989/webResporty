package com.zdl.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class DynamicProxyDemonstration {

    public static void main(String [] args){

        Subject realSubject = new RealSubject();
        InvocationHandler handler =new InvocationHandlerImpl(realSubject);

        Subject obj =(Subject) Proxy.newProxyInstance(RealSubject.class.getClassLoader(),RealSubject.class.getInterfaces(),handler);

        obj.SayHello("傻逼");

    }
}
