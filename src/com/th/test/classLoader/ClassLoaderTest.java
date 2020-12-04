package com.th.test.classLoader;

public class ClassLoaderTest {
    public static void cl() {
        System.out.println(ClassLoader.getSystemClassLoader());//sun.misc.Launcher$AppClassLoader@18b4aac2
    }

//            父加载器
    public static void clp() {
        System.out.println(ClassLoader.getSystemClassLoader().getParent());//sun.misc.Launcher$ExtClassLoader@12a3a380
    }

//            ExtClassLoader的父加载器
    public static void clpp() {
        System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());
    }



    public static void main(String[] args) {
        cl();
        clp();
        clpp();
    }

}
