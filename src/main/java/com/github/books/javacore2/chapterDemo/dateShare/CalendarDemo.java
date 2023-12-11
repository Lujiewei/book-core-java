package com.github.books.javacore2.chapterDemo.dateShare;

import java.util.Calendar;

/**
 * @author lujiewei
 * create on 2023/12/7
 */
public class CalendarDemo {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();//多态的形式
        //public int get(int field)根据给的日历字段返回对应的值
        int year = calendar.get(Calendar.YEAR);
        //YEAR是Calendar类中的日历字段，都是用static修饰的，用类名直接调用字段
        int month = calendar.get(Calendar.MONTH) + 1;
        //因为月在这里默认从0开始的，所以要得到正确的月需要加1
        int date = calendar.get(Calendar.DATE);
        System.out.println(year + "年" + month + "月" + date + "日");
    }
}
