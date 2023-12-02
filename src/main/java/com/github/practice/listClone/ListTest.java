package com.github.practice.listClone;

import com.github.practice.listClone.org.JieWeiList;


public class ListTest {
    public static void main(String[] args) {
        JieWeiList<Integer> nm = new JieWeiList<>();
        System.out.println("-----添加节点-----");
        nm.add(1);
        nm.add(2);
        nm.add(3);
        nm.add(5);
        nm.add(6);
        nm.print();
        System.out.println();
        System.out.println("-----删除节点-----");
        nm.delete(5);
        nm.print();
        System.out.println();
        System.out.println("-----查找节点-----");
        System.out.println(nm.find(1));
        System.out.println(nm.find(3));
        System.out.println(nm.find(6));
        System.out.println(nm.find(7));
        System.out.println("-----修改节点数据-----");
        nm.updateData(6, 20);
        nm.print();
        System.out.println();
        System.out.println("-----插入节点-----");
        nm.insert(3, 36);
        nm.insert(7, 10);
        nm.print();
        System.out.println();
        System.out.println(nm.length());
    }
}
