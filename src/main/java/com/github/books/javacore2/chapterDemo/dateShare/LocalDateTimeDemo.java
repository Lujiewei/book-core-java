package com.github.books.javacore2.chapterDemo.dateShare;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author lujiewei
 * create on 2023/12/7
 */
public class LocalDateTimeDemo {
    public static void main(String[] args) {

        /***
         * 日期的加减计算， 与 Date的比较
         *
         * 当需要处理不包含时区信息的日期和时间时，可以使用 LocalDateTime。
         * 当需要在多线程环境下安全地操作日期和时间时，可以使用 LocalDateTime
         */
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        LocalDateTime now1 = LocalDateTime.of(2023, 12, 7, 15, 50, 40, 30);
        System.out.println(now1);

        LocalDate ld = LocalDate.now();
        LocalTime lt = LocalTime.now();
        LocalDateTime now2 = LocalDateTime.of(ld, lt);
        System.out.println(now2);

        LocalDate ldDate = now2.toLocalDate();
        LocalTime ltDate = now2.toLocalTime();
        System.out.println(ldDate + "---" + ltDate);
        System.out.println(now.getDayOfWeek().getValue());
        LocalDateTime now3 = now.plusDays(1);
        System.out.println(now3);
    }
}
