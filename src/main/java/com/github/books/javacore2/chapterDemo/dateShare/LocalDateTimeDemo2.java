package com.github.books.javacore2.chapterDemo.dateShare;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeDemo2 {
    public static void main(String[] args) {
        // Get current date and time
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Current date and time: " + now);

        System.out.println(ZoneId.getAvailableZoneIds());
        // Convert to a different time zone
        ZoneId newYorkZone = ZoneId.of("America/New_York");
        LocalDateTime newYorkTime = LocalDateTime.from(now.atZone(ZoneId.systemDefault()).withZoneSameInstant(newYorkZone));
        System.out.println("New York time: " + newYorkTime);

        // Format date and time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedTime = now.format(formatter);
        System.out.println("Formatted time: " + formattedTime);
    }
}
