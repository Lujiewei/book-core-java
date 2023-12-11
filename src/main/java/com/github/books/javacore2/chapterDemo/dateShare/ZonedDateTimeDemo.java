package com.github.books.javacore2.chapterDemo.dateShare;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * @author lujiewei
 * create on 2023/12/7
 */
public class ZonedDateTimeDemo {
    public static void main(String[] args) {
        System.out.println(ZoneId.getAvailableZoneIds());

        ZonedDateTime now3 = ZonedDateTime.now();
        System.out.println(now3);
        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("Asia/Chongqing"));
        System.out.println(now);

        ZonedDateTime now1 = ZonedDateTime.of(2023, 12, 7, 16, 10, 10, 20, ZoneId.of("Asia/Chongqing"));
        System.out.println(now1);

        LocalDateTime ldt = LocalDateTime.now();
        ZonedDateTime now2 = ZonedDateTime.of(ldt, ZoneId.of("Asia/Chongqing"));
        System.out.println(now2);
    }
}
