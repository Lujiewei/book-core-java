package com.github.practice.listClone.org;


import java.util.LinkedList;
import java.util.List;

/***
 *
 * JieWeiList
 *
 * @author lu.jiewei
 * Create on 2023-11-13
 */
public class JieWeiList<E> {
    private Node<E> head;
    private Node<E> tail;

    // 添加节点
    public void add(E data) {
        if (head == null) {
            var first = new Node<>(data);
            head = first;
            tail = first;
        } else {
            final Node<E> newNode = new Node<>(data);
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }
    }

    // 打印所有节点
    public void print() {
        for (int i = 0; i < length(); i++) {
            var nodeData = getNodeData(i);
            System.out.print(nodeData + "-->");
        }
    }

    // 删除节点
    public void delete(E item) {
        int itemIndex = getDataIndex(item);
        if (itemIndex == 0) {
            head = head.next;
            if (head == null) {
                return;
            }
            head.previous = null;
        }
        if (itemIndex > 0) {
            var findNode = getNode(itemIndex);
            if (findNode.next == null) {
                tail = findNode.previous;
                tail.next = null;
            } else {
                findNode.previous.next = findNode.next;
                findNode.next.previous = findNode.previous;
            }
        }
    }

    // 查找节点是否存在
    public boolean find(E item) {
        return getDataIndex(item) >= 0;
    }

    // 修改节点数据
    public void updateData(E item, E data) {
        int itemIndex = getDataIndex(item);
        var findItem = getNode(itemIndex);
        if (findItem != null) {
            findItem.setData(data);
        }
    }

    // 从一个节点前插入一个节点
    public void insert(int index, E data) {
        if (index < 0) return;
        var listLength = length();
        Node<E> newNode = new Node<>(data);
        if (head == null || listLength == index) {
            add(data);
        }
        if (index == 0) {
            newNode.next = head;
            newNode.previous = null;
            head.previous = newNode;
            head = newNode;
        } else {
            var findNode = getNode(index);
            if (findNode != null) {
                findNode.previous.next = newNode;
                newNode.previous = findNode.previous;
                newNode.next = findNode;
                findNode.previous = newNode;
                return;
            }
        }
        System.out.println("没有索引为" + index + "的节点");
    }

    // 获取节点索引
    public int getDataIndex(E item) {
        var nextNode = head;
        int dataIndex = 0;
        while (nextNode != null) {
            if (nextNode.getData().equals(item)) {
                return dataIndex;
            }
            dataIndex++;
            nextNode = nextNode.next;
        }
        return -1;
    }

    // 求节点长度
    public int length() {
        int length = 0;
        Node<E> f = head;
        while (f != null) {
            f = f.next;
            length++;
        }
        return length;
    }

    // 根据索引查找节点的数据
    public E getNodeData(int index) {
        Node<E> findNode = getNode(index);
        if (findNode != null) {
            return findNode.getData();
        }
        return null;
    }

    // 根据索引查找节点
    public Node<E> getNode(int index) {
        var itemLength = length();
        if (index >= itemLength || index < 0) {
            return null;
        } else {
            var nextNode = head;
            for (int i = 0; i < index; i++) {
                nextNode = nextNode.next;
            }
            return nextNode;
        }
    }
}
