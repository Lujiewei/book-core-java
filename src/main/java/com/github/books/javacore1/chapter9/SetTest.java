package com.github.books.javacore1.chapter9;

import java.util.*;

/**
 * This program uses a set to print all unique words in System.in.
 *
 * @author Cay Horstmann
 * @version 1.12 2015-06-21
 */
public class SetTest {
    public static void main(String[] args) {
        var words = new HashSet<String>();


        long totalTime = 0;

        int iiii = 1;
        try (Scanner in = new Scanner(System.in)) {
            while (in.hasNext()) {
                iiii++;
                String word = in.next();

                long callTime = System.currentTimeMillis();
                words.add(word);
                callTime = System.currentTimeMillis() - callTime;
                totalTime += callTime;

                if (iiii > 5) {
                    break;
                }
            }
        }


        Iterator<String> iter = words.iterator();
        for (int i = 1; i <= 5 && iter.hasNext(); i++)
            System.out.println(iter.next());
        System.out.println(". . .");
        System.out.println(words.size() + " distinct words. " + totalTime + " milliseconds.");
    }
}
