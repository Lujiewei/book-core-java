//package com.github.practice.listClone.org;
//
//
//import java.util.function.Function;
//
///***
// *
// * JieWeiList
// *
// * @author lu.jiewei
// * Create on 2023-11-13
// */
//public class JieWeiList2<E> {
//    private Node<E> head;
//    private Node<E> tail;
//
//    /**
//     * 查找第几个节点。
//     */
//    private int dataIndex = 1;
//
//    private <T> T seekNext(Function function) {
//        var nextNode = head.next;
//        while (!(nextNode == null)) {
//
//            nextNode = nextNode.next;
//        }
//        return null;
//    }
//
//    // 添加节点
//    public void add(E data) {
//        if (head == null) {
//            var first = new Node(data);
//            head = first;
//            tail = first;
//        } else {
//            final Node<E> newNode = new Node(data);
//            tail.next = newNode;
//            newNode.previous = tail;
//            tail = newNode;
//        }
//    }
//
//    // 打印所有节点
//    public void print() {
//        if (head == null) {
//            System.out.println("此链表为空！");
//        } else {
//            System.out.print(head.getData() + "-->");
//            var nextNode = head.next;
//            while (nextNode != null) {
//                System.out.print(nextNode.getData() + "-->");
//                nextNode = nextNode.next;
//            }
//        }
//    }
//
//    // 删除节点
//    public void delete(E data) {
//        if (head == null) return;
//        if (head.getData().equals(data)) {
//            if (head.next == null) {
//                // 只有一个元素
//                head = null;
//            } else {
//                // >=2 个元素
//                head = head.next;
//                head.previous = null;
//            }
//        } else {
//            var nextNode = head.next;
//            while (!(nextNode == null)) {
//                if (nextNode.getData().equals(data)) {
//                    if (nextNode.next == null) {
//                        nextNode.previous.next = null;
//                        tail = nextNode;
//                    } else {
//                        nextNode.previous.next = nextNode.next;
//                        nextNode.next.previous = nextNode.previous;
//                    }
//                    return;
//                }
//                nextNode = nextNode.next;
//            }
//        }
//    }
//
//    // 查找节点是否存在
//    public boolean find(E item) {
//        return getIndex(item) >= 0;
//    }
//
//    /***
//     * 查找Item对应集合中的位置
//     * @param item
//     * @return -1 if not found. other return the index.
//     */
//    public int getIndex(E item) {
//        if (head == null) return -1;
//        if (head.getData().equals(item)) {
//            return 0;
//        } else {
//            int index = 1;
//            var nextNode = head.next;
//            while (!(nextNode == null)) {
//                if (nextNode.getData().equals(item)) {
//                    return index;
//                }
//
//                nextNode = nextNode.next;
//                index ++;
//            }
//            return -1;
//        }
//    }
//
//    // 修改节点数据
//    public void updateData(E item, Object data) {
//        if (head == null) return;
//        if (head.getData().equals(item)) {
//            head.setData(newItem);
//        } else {
//            var nextNode = head.next;
//            while (!(nextNode == null)) {
//                if (nextNode.getData().equals(oldItem)) {
//                    nextNode.setData(newItem);
//                }
//                nextNode = nextNode.next;
//            }
//        }
//    }
//
//    // 从一个节点前插入一个节点
//    public void insert(int index, E data) {
//        if (index < 0) return;
//        if (head == null) {
//            add(data);
//        }
//        if (index == 0) {
//            Node newNode = new Node(data);
//            newNode.next = head;
//            newNode.previous = null;
//            head.previous = newNode;
//            head = newNode;
//        } else {
//            var nextNode = head.next;
//            while (!(nextNode == null)) {
//                if (dataIndex == index) {
//                    Node newNode = new Node(data);
//                    nextNode.previous.next = newNode;
//                    newNode.previous = nextNode.previous;
//                    newNode.next = nextNode;
//                    return;
//                }
//                dataIndex++;
//                nextNode = nextNode.next;
//            }
//            System.out.println("没有索引为" + index + "的节点");
//        }
//    }
//
//    // 求节点长度
//    public int length() {
//        int nodeLength = 0;
//        Node current = head;
//        while (current != null) {
//            nodeLength ++;
//
//            current = current.next;
//        }
//
//        return nodeLength;
//    }
//
//    // 根据索引查找节点
//    public E get(int index) {
//        var nextNode = head;
//        int currentIndex = 0;
//        while (!(nextNode == null)) {
//            if (index == currentIndex) {
//                return (E) nextNode.getData();
//            }
//            currentIndex ++;
//            nextNode = nextNode.next;
//        }
//        return null;
//    }
//}
