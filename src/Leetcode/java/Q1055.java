package Leetcode.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Q1055 {
    class Solution {
        Map<Character, ArrayList<Integer>> map = new HashMap<>();
        public int get_smallest(Character c, int curr){
            var idxs = map.get(c);
            for (int idx : idxs) if (idx > curr) return idx;
            return idxs.get(0);
        }

        public int shortestWay(String source, String target) {
            for (int i=0; i<source.length(); i++) {
                char c = source.charAt(i);
                map.putIfAbsent(c, new ArrayList<>());
                map.get(c).add(i);
            }

            int ans = 0;
            int curr = Integer.MAX_VALUE;

            for (int i=0; i<target.length(); i++) {
                char currChar = target.charAt(i);
                if (!map.containsKey(currChar)) return -1;
                int smallestIdx = get_smallest(currChar, curr);
                if (smallestIdx <= curr) ans++;
                curr = smallestIdx;
            }
            return ans;
        }
    }
}
