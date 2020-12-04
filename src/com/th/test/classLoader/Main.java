package com.th.test.classLoader;


import java.io.FileInputStream;
import java.lang.reflect.Method;

/**
 * 自定义classloader
 * extends ClassLoader 然后覆盖findClass方法即可
 * class文件不能四处放 因为class文件中会包含package的信息， 如果位置变了 classloader的时候会出现错误。
 */
public class Main {
    static class MyClassLoader extends ClassLoader {
        private String classPath;

        public MyClassLoader(String classPath) {
            this.classPath = classPath;
        }

        private byte[] loadByte(String name) throws Exception {
            name = name.replaceAll("\\.", "/");

            FileInputStream fis = new FileInputStream(classPath + "/" + name
                    + ".class");
            int len = fis.available();
            byte[] data = new byte[len];
            fis.read(data);
            fis.close();
            System.out.println(data.length);
            return data;

        }

        protected Class<?> findClass(String name) throws ClassNotFoundException {
            try {
                byte[] data = loadByte(name);//获得二进制
                return defineClass(name, data, 0, data.length);//将 class字节流转为 class instance
            } catch (Exception e) {
                e.printStackTrace();
                throw new ClassNotFoundException();
            }
        }

    };

    public static void main(String args[]) throws Exception {
        MyClassLoader classLoader = new MyClassLoader("D:/intellij_workspace/JavaSourceLearn/out/production/JavaSourceLearn");
        Class clazz = classLoader.findClass("com.th.test.classLoader.Test");//class com.th.test.classLoader.Main$MyClassLoader 加载
        Object obj = clazz.newInstance();
        Method helloMethod = clazz.getDeclaredMethod("hello", null);
        helloMethod.invoke(obj, null);

        MyClassLoader classLoader2 = new MyClassLoader("D:/intellij_workspace/JavaSourceLearn/out/production/JavaSourceLearn");
        Class clazz2 = classLoader2.loadClass("com.th.test.classLoader.Test");//class sun.misc.Launcher$AppClassLoader 加载
//        与上边的区别在于双亲委派模型
        Object obj2 = clazz2.newInstance();
        Method helloMethod2 = clazz2.getDeclaredMethod("hello", null);
        helloMethod2.invoke(obj2, null);

    }
}