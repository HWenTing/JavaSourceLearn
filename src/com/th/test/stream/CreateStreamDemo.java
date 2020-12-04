package com.th.test.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


/*
如果是数组的话，可以使用 Arrays.stream() 或者 Stream.of() 创建流；
如果是集合的话，可以直接使用 stream() 方法创建流，因为该方法已经添加到 Collection 接口中
 */
public class CreateStreamDemo {
    public static void main(String[] args) {
        String[] arr = new String[]{"武汉加油", "中国加油", "世界加油"};
        Stream<String> stream = Arrays.stream(arr);

        stream = Stream.of("武汉加油", "中国加油", "世界加油");//实际上  return Arrays.stream(values);

        List<String> list = new ArrayList<>();
        list.add("武汉加油");
        list.add("中国加油");
        list.add("世界加油");
        stream = list.stream();
    }
}
