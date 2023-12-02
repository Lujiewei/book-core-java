package com.github.practice.map.org;

//import com.github.practice.list.org.JieWeiList;

import com.github.practice.listClone.org.JieWeiList;

public class JieWeiMap<K, V> {
    private static final int GROUP_LENGTH = 16;
    private JieWeiList<Pair<K, V>>[] table;

    public JieWeiList<Pair<K, V>>[] getTable() {
        return table;
    }

    public void setTable(JieWeiList<Pair<K, V>>[] table) {
        this.table = table;
    }

    private int size;

    public JieWeiMap() {
        table = new JieWeiList[GROUP_LENGTH];
        size = 0;
    }

    // 添加键值对
    public void put(K key, V value) {
        int index = hash(key);
        if (table[index] == null) {
            table[index] = new JieWeiList<>();
        }

        for (int i = 0; i < table[index].length(); i++) {
            if (table[index].getNodeData(i).equals(getPair(key))) {
                table[index].getNodeData(i).value = value;
                return;
            }
        }

        table[index].add(new Pair<>(key, value));
        size++;
        if (size > table.length * 0.75) {
            resize();
        }

    }

    // 移除键值对
    public void remove(K key) {
        int index = hash(key);
        table[index].delete(getPair(key));
    }

    // 自动扩充
    private void resize() {
        JieWeiList<Pair<K, V>>[] oldTable = table;
        JieWeiList[] table = new JieWeiList[oldTable.length * 2];
        size = 0;
        for (JieWeiList<Pair<K, V>> bucket : oldTable) {
            if (bucket != null) {
                for (int in = 0; in < bucket.length(); in++) {
                    put(bucket.getNodeData(in).key, bucket.getNodeData(in).value);
                }
            }
        }
    }

    // 根据键获取value的值
    public V get(K key) {
        int index = hash(key);

        if (table[index] != null) {
            for (int i = 0; i < table[index].length(); i++) {
                if (table[index].getNodeData(i).equals(key)) {
                    return table[index].getNodeData(i).value;
                }
            }
        }
        return null;
    }

    // 遍历
    public static void forEach(JieWeiMap<Object, Object> jMap) {
        var jList = jMap.table;
        for (JieWeiList<Pair<Object, Object>> jieWeiList : jList) {
            if (!(jieWeiList == null)) {
                for (int in = 0; in < jieWeiList.length(); in++) {
                    System.out.println(jieWeiList.getNodeData(in));
                }
            }
        }
    }

    public K value(V val) {
        return null;
    }

    public Pair<K, V> getPair(K key) {
        return new Pair<>(key, get(key));
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % table.length;
    }
}
