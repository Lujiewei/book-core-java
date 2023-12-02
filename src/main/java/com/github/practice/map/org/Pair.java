package com.github.practice.map.org;

public class Pair<K, V> {
    K key;
    V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (Pair.class == obj.getClass()) {
            Pair<K, V> pair = (Pair) obj;
            return this.key.equals(pair.key);
        } else {
            return this.key.equals(obj);
        }
    }

}
