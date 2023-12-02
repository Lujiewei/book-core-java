package com.github.books.javacore1.chapterDemo.on8;

import java.util.Objects;

public class User {
    private String username;
    private String passward;
    private int age;
    private String sex;

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", passward='" + passward + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }

    public User() {
    }

    public User(String username, String passward, int age, String sex) {
        this.username = username;
        this.passward = passward;
        this.age = age;
        this.sex = sex;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassward() {
        return passward;
    }

    public void setPassward(String passward) {
        this.passward = passward;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getAge() == user.getAge() && Objects.equals(getUsername(), user.getUsername()) && Objects.equals(getPassward(), user.getPassward()) && Objects.equals(getSex(), user.getSex());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUsername(), getPassward(), getAge(), getSex());
    }
}
