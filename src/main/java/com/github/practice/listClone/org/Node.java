package com.github.practice.listClone.org;


public class Node<E> {
    private E data;
    public Node<E> previous = null;
    public Node<E> next = null;

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public Node(E data) {
        this.data = data;
        this.previous = null;
        this.next = null;
    }
}