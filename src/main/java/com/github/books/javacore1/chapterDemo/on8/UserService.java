package com.github.books.javacore1.chapterDemo.on8;

import java.util.Arrays;
import java.util.List;

public class UserService {
    public User login(String username, String passward) throws MyException {
        if (!"admin".equals(username)) {
            throw new MyException("用户名错误！");
        }
        if (!"12345".equals(passward)) {
            throw new MyException("密码错误！");
        }
        User user = new User("admin", "12345", 20, "男");

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        numbers.stream()
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println);

        return user;
    }
}
