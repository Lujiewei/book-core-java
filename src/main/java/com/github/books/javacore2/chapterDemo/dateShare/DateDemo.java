package com.github.books.javacore2.chapterDemo.dateShare;


import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDemo {
    public static void main(String[] args) {


        System.currentTimeMillis();


        Date currentDate = new Date();
        Long time = currentDate.getTime();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd T HH:mm:ss");
        String formattedDate = formatter.format(currentDate);
        System.out.println("格式化后的日期和时间： " + formattedDate);


    }
}
