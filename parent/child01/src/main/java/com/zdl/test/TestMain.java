package com.zdl.test;

import java.util.HashSet;
import java.util.Set;

public class TestMain {

    public static void main(String[] args){
        Set<String> set = new HashSet<>();
        set.add("1");
        set.add("1");
        System.out.print(set.size());   }
}
