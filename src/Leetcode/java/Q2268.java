package Leetcode.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q2268 {
    class Solution {
        public int minimumKeypresses(String s) {
            Map<Character, Integer> map = new HashMap<>();
            for (Character c : s.toCharArray()){
                map.put(c, map.getOrDefault(c, 0)+1);
            }

            List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
            list.sort((a,b) -> b.getValue() - a.getValue());

            var counter = 0;
            var ans = 0;
            for (Map.Entry<Character, Integer> entry : list) {
                var weight = (counter / 9) + 1;
                ans += weight * entry.getValue();
                counter++;
            }
            return ans;
        }
    }
}
