package com.github.practice.list.org;

public class JieWeiList<E> {
    private Node<E> head;

    private int dataIndex = 1;

    // 添加节点
    public void add(E data) {
        if (head == null) {
            head = new Node<>(data);
            head.previous = null;
            head.next = null;
        } else {
//            第 2， 3， 4次
            head.addData(data);
        }
    }

    // 打印所有节点
    public void print() {
        if (head == null) {
            System.out.println("此链表为空！");
        } else {
            System.out.print(head.getData() + "-->");
            head.printData();
        }
    }

    // 删除节点
    public void delete(E data) {
        if (head == null) return;
        if (head.getData().equals(data)) {
            if (head.next == null) {
                head = null;
            } else {
                head = head.next;
                head.previous = null;
            }
        } else {
            head.deleteData(data);
        }
    }

    // 查找节点是否存在
    public boolean find(E data) {
        if (head == null) return false;
        if (head.getData().equals(data)) {
            return true;
        } else {
            return head.findData(data);
        }
    }

    // 修改节点数据
    public void updateData(E oldData, E newData) {
        if (head == null) return;
        if (head.getData().equals(oldData)) {
            head.setData(newData);
        } else {
            head.updataNode(oldData, newData);
        }
    }

    // 从一个节点前插入一个节点
    public void insert(int index, E data) {
        if (index < 0) return;
        if (head == null) {
            head = new Node<>(data);
            head.previous = head;
        }
        if (index == 0) {
            Node<E> newNode = new Node<>(data);
            newNode.next = head;
            newNode.previous = newNode;
            head.previous = newNode;
            head = newNode;
        } else {
            head.insertData(index, data, dataIndex);
        }
    }

    // 求节点长度
    public int length() {
        int nodeLength = 0;
        Node<E> f = head;
        if (f != null) {
            nodeLength++;
            while (f.next != null) {
                f = f.next;
                nodeLength++;
            }
            return nodeLength;
        } else {
            return nodeLength;
        }
    }

    // 查找第几个节点
    public E findIndex(int index) {
        if (index == 0) {
            return (E) head.getData();
        } else {
            return (E) head.findIndexData(index).getData();
        }
    }
}
