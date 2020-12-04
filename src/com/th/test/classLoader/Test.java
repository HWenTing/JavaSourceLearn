package com.th.test.classLoader;

public class Test {
    public void hello() {
        System.out.println(getClass().getClassLoader().getClass() + " 加载");
    }
}