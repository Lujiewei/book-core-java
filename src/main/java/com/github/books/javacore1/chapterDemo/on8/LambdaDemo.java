package com.github.books.javacore1.chapterDemo.on8;

import java.util.Arrays;
import java.util.Comparator;

public class LambdaDemo {
    public static void main(String[] args) {
        var plants = new Integer[]{32, 43, 123, 543, 123, 4, 123, 45, 1, 5};
//        for (int a : plants) {
//            System.out.println(a);
//        }
//        Arrays.sort(plants);
//        for (int a : plants) {
//            System.out.println(a);
//        }


        Arrays.sort(plants, (first, second) -> second - first);


        Comparator comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer first, Integer second) {
                return second - first;
            }
        };

        Arrays.sort(plants, comparator);

        for (Integer a : plants) {
            System.out.println(a);
        }
    }
}
