package com.github.books.javacore1.chapterDemo.o9;

public class Node {
    public Integer data;
    public Node next;

    public Node() {
    }

    public Node(Integer data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Node(Integer data) {
        this.data = data;
    }
}
