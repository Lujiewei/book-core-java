package com.github.books.javacore1.chapterDemo.o9;

import java.util.Collections;
import java.util.LinkedList;

public class SingleLinkedList {
    private static Node head = new Node();

    public static void main(String[] args) {
        var staff = new LinkedList<String>();
        Collections.sort(staff);
    }

    public static void addData(int value) {
        Node newNode = new Node(value);
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public static void teaverse(Node head) {

    }
}
