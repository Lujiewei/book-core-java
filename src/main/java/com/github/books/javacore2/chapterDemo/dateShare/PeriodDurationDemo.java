package com.github.books.javacore2.chapterDemo.dateShare;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

/**
 * @author lujiewei
 * create on 2023/12/7
 */
public class PeriodDurationDemo {
    public static void main(String[] args) {

        LocalDate startDate = LocalDate.of(2023, 11, 5);
        LocalDate endDate = LocalDate.of(2023, 12, 7);

        LocalDateTime startTime = LocalDateTime.now();
        LocalDateTime endTime = startTime.plusHours(2).plusMinutes(20).plusSeconds(40);
        periodTest(startDate, endDate);
        durationTest(startTime, endTime);


    }

    public static void periodTest(LocalDate startDate, LocalDate endDate) {
        Period period = Period.between(startDate, endDate);
        System.out.println("日期间隔: " + period);
        int year = period.getYears();
        int month = period.getMonths();
        int day = period.getDays();
        System.out.println("年" + year);
        System.out.println("月" + month);
        System.out.println("日" + day);
    }

    public static void durationTest(LocalDateTime startTime, LocalDateTime endTime) {
        Duration duration = Duration.between(startTime, endTime);
        System.out.println(duration);
        System.out.println(duration.getSeconds());
    }
}
