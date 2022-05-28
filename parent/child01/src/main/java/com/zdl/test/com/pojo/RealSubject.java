package com.zdl.test.com.pojo;

public class RealSubject implements Subject {
    /**
     * 你好
     *
     * @param name
     * @return
     */
    @Override
    public void SayHello(String name) {
        System.out.println("你好，这是第一个动态代理小实验"+name);
    }

}
