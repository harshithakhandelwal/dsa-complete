package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Greedy {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int p1 = 0;
        int p2 = 0;

        while(p1<s.length && p2<g.length){
            if(s[p1]>=g[p2]){
                p1++;
                p2++;
            }
            else {
                p1++;
            }
        }

        return p2;
    }

    public boolean lemonadeChange(int[] bills) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int bill : bills) {
            if (bill == 5) {
                map.put(5, map.getOrDefault(5, 0) + 1);
            } else if (bill == 10 && map.get(5) > 0) {
                map.put(5, map.get(5) - 1);
                map.put(10, map.getOrDefault(10, 0) + 1);
            } else if (bill == 20 && map.get(10) > 0 && map.get(5) > 0) {
                map.put(5, map.get(5) - 1);
                map.put(10, map.get(10) - 1);
                map.put(20, map.getOrDefault(20, 0) + 1);
            } else return false;

        }
        return true;
    }
}
