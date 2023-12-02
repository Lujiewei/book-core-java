package com.github.books.javacore1.chapter4;

import java.math.BigDecimal;

public class MoneyCalculator {
    public static void main(String[] args) {
        BigDecimal amount1 = new BigDecimal("100.5");
        BigDecimal amount2 = new BigDecimal("200.3");

        // 加法
        BigDecimal sum = amount1.add(amount2);
        System.out.println("加法结果： " + sum);

        // 减法
        BigDecimal difference = amount1.subtract(amount2);
        System.out.println("减法结果： " + difference);

        // 乘法
        BigDecimal product = amount1.multiply(amount2);
        System.out.println("乘法结果： " + product);

        // 除法
        BigDecimal quotient = amount1.divide(amount2, 2, BigDecimal.ROUND_HALF_UP);
        System.out.println("除法结果： " + quotient);
    }
}
