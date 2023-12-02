package com.github.books.javacore2.chapter1.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author Cay Horstmann
 * @version 1.02 2019-08-28
 */
public class CountLongWords {
    public static void main(String[] args) throws IOException {
        var contents = Files.readString(
                Paths.get("src/main/java/com/github/books/javacore2/chapter1/bookWord/alice15.txt"));
        List<String> words = List.of(contents.split("\\PL+"));

        long count = 0;
        for (String w : words) {
            if (w.length() > 12) count++;
        }
        System.out.println(count);

        count = words.stream().filter(w -> w.length() > 12).count();
        System.out.println(count);

        count = words.parallelStream().filter(w -> w.length() > 12).count();
        System.out.println(count);
    }
}
