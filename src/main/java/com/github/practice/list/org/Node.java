package com.github.practice.list.org;


public class Node<E> {
    private E data;
    public Node<E> previous;
    public Node<E> next;

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

    public void addData(E data) {
        if (this.next == null) {
            this.next = new Node(data);
            this.next.previous = this;
        } else {
            this.next.addData(data);
        }
    }

    public void printData() {
        if (this.next == null) {
            return;
        } else {
            System.out.print(this.next.data + "-->");
            this.next.printData();
        }
    }

    public void deleteData(E data) {
        if (this.next == null) return;
        if (this.next.data.equals(data)) {
            this.next = this.next.next;
            this.next.previous = this;
        }
    }

    public boolean findData(E data) {
        if (this.next == null) return false;
        if (this.next.data.equals(data)) {
            return true;
        } else {
            return this.next.findData(data);
        }
    }

    public void updataNode(E oldData, E newData) {
        if (this.next == null) return;
        if (this.next.data == oldData) {
            this.next.data = newData;
        } else {
            this.next.updataNode(oldData, newData);
        }
    }

    public void insertData(int index, E data, int dataIndex) {
        if (this.next == null) {
            this.next = new Node(data);
            this.next.previous = this;
            return;
        }
        if (dataIndex == index) {
            Node newNode = new Node(data);
            newNode.next = this.next;
            this.next = newNode;
            newNode.previous = this;
            newNode.next.previous = newNode;
        } else {
            dataIndex++;
            this.next.insertData(index, data, dataIndex);
        }
    }

    public Node<E> findIndexData(int index) {

//        LinkedList a = new LinkedList<>()

        int in = 1;
        if (in == index) {
            return this.next;
        } else {
            return this.next.findIndexData(index);
        }
    }
}