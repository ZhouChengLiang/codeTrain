package org.example;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main5 {
    public static void main(String[] args) {
        // 10是初始大小，0.75是装载因子，true是表示按照访问时间排序
        HashMap<Integer, Integer> m = new LinkedHashMap<>(10, 0.75f, true);
        m.put(3, 11);
        m.put(1, 12);
        m.put(5, 23);
        m.put(2, 22);

        for (Map.Entry e : m.entrySet()) {
            System.out.println(e.getKey());
        }
        System.out.println("===============================================================================");
        m.get(2);
        m.get(5);
        m.get(1);
        m.get(3);

        for (Map.Entry e : m.entrySet()) {
            System.out.println(e.getKey());
        }
    }
}
