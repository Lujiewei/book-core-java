package com.github.practice.map;

import com.github.practice.map.org.JieWeiMap;


public class MapTest {

    public static void main(String[] args) {
        var no = new JieWeiMap<>();
        no.put("123", "111");
        no.put("124", "222");
        no.put("125", "333");
        no.put("126", "444");
        no.remove("125");
        JieWeiMap.forEach(no);
    }
}
