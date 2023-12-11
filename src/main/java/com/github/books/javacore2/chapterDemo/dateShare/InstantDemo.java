package com.github.books.javacore2.chapterDemo.dateShare;

import java.time.Instant;

/**
 * 获取当前时间的毫秒时间戳：通过调用静态方法now()，可以方便快捷地获取到当前时间的Instant实例，然后通过toEpochMilli()方法转化为时间戳。
 * 记录事件时间戳：由于Instant的精度高，因此可以用于在应用程序中记录事件的精确发生时间。例如，计算某个操作的执行时间，或者记录某个事件发生的具体时间点等。
 * 与日期和时间的操作：虽然Instant类本身只代表一个时间点，不处理年、月、日等单位，但可以通过与其他日期和时间相关类的配合，进行更复杂的时间和日期操作。
 *
 * @author lujiewei
 * create on 2023/12/7
 */
public class InstantDemo {
    public static void main(String[] args) {

        Instant instant = Instant.now();
        System.out.println("当前时间点：" + instant);

        System.out.println("获取当前秒数" + instant.getEpochSecond());
        System.out.println("获取不足一秒的纳秒数" + instant.getNano());
        System.out.println("--------------------------------------");
        Instant instant1 = instant.plusSeconds(1);
        System.out.println("获取当前秒数" + instant1.getEpochSecond());
        System.out.println("获取不足一秒的纳秒数" + instant1.getNano());
        System.out.println("--------------------------------------");
        Instant instant2 = instant.plusNanos(1);
        System.out.println("获取当前秒数" + instant2.getEpochSecond());
        System.out.println("获取不足一秒的纳秒数" + instant2.getNano());

        // 比较先后
        boolean isBefore = instant.isBefore(instant1);
        System.out.println(isBefore);
        boolean isAfter = instant.isAfter(instant1);
        System.out.println(isAfter);
    }
}
