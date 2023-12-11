package com.github.books.javacore2.chapterDemo.dateShare;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

/**
 * @author lujiewei
 * create on 2023/12/7
 */
public class DateTimeFormatterDemo {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


        Instant instant = Instant.now();
        System.out.println(instant);


        LocalDateTime now = LocalDateTime.now();


        String date = formatter.format(now);
        System.out.println(date);
        TemporalAccessor parse = formatter.parse("2023-12-08 18:10:20");
        System.out.println(formatter.parse(date));
        System.out.println(parse);
    }
}
