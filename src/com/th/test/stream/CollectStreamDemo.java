package com.th.test.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
Collectors 是一个收集器的工具类，内置了一系列收集器实现，
 */
public class CollectStreamDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("周杰伦");
        list.add("王力宏");
        list.add("陶喆");
        list.add("林俊杰");

        String[] strArray = list.stream().toArray(String[]::new);
        System.out.println(Arrays.toString(strArray));

        //当我们需要把一个集合按照某种规则转成另外一个集合的时候，就可以配套使用 map() 方法和 collect() 方法。
        List<Integer> list1 = list.stream().map(String::length).collect(Collectors.toList());// toList() 方法将元素收集到一个新的 java.util.List 中
        List<String> list2 = list.stream().collect(Collectors.toCollection(ArrayList::new));//toCollection() 方法将元素收集到一个新的 java.util.ArrayList 中
        System.out.println(list1);
        System.out.println(list2);

        String str = list.stream().collect(Collectors.joining(", ")).toString();//joining() 方法将元素收集到一个可以用分隔符指定的字符串中
        System.out.println(str);
    }
}
