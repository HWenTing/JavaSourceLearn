package com.th.test.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/*
Stream 类提供了很多有用的操作流的方法，
 */
public class OpreateStreamDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("周杰伦");
        list.add("王力宏");
        list.add("陶喆");
        list.add("林俊杰");

        //通过 filter() 方法可以从流中筛选出我们想要的元素。
        Stream<String> stream = list.stream().filter(element -> element.contains("王"));
        stream.forEach(System.out::println);
        System.out.println("----------------");

        //如果想通过某种操作把一个流中的元素转化成新的流中的元素，可以使用 map() 方法。
        Stream<Integer> stream1 = list.stream().map(String::length);
        stream1.forEach(System.out::println);
        System.out.println("----------------");

        //Stream 类提供了三个方法可供进行元素匹配，它们分别是：
        //anyMatch()，只要有一个元素匹配传入的条件，就返回 true。
        boolean  anyMatchFlag = list.stream().anyMatch(element -> element.contains("王"));
        //allMatch()，只有有一个元素不匹配传入的条件，就返回 false；如果全部匹配，则返回 true。
        boolean  allMatchFlag = list.stream().allMatch(element -> element.length() > 1);
        //noneMatch()，只要有一个元素匹配传入的条件，就返回 false；如果全部不匹配，则返回 true。
        boolean  noneMatchFlag = list.stream().noneMatch(element -> element.endsWith("沉"));
        System.out.println(anyMatchFlag);
        System.out.println(allMatchFlag);
        System.out.println(noneMatchFlag);
        System.out.println("----------------");

//        reduce() 方法的主要作用是把 Stream 中的元素组合起来，它有两种用法：

        Integer[] ints = {0, 1, 2, 3};
        List<Integer> list2 = Arrays.asList(ints);
//        Optional<T> reduce(BinaryOperator<T> accumulator)
//        没有起始值，只有一个参数，就是运算规则，此时返回 Optional。
        Optional<Integer> optional = list2.stream().reduce((a, b) -> a + b);
        Optional<Integer> optional1 = list2.stream().reduce(Integer::sum);
        System.out.println(optional.orElse(0));
        System.out.println(optional1.orElse(0));
//        T reduce(T identity, BinaryOperator<T> accumulator)
//        有起始值，有运算规则，两个参数，此时返回的类型和起始值类型一致。
        int reduce = list2.stream().reduce(6, (a, b) -> a + b);
        System.out.println(reduce);
        int reduce1 = list2.stream().reduce(6, Integer::sum);
        System.out.println(reduce1);


    }
}
