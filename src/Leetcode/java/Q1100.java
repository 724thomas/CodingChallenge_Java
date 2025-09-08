package Leetcode.java;

import java.util.HashMap;
import java.util.Map;

public class Q1100 {
    class Solution {
        public int numKLenSubstrNoRepeats(String s, int k) {
            Map<Character, Integer> counter = new HashMap<>();
            int ans = 0;
            int left = 0;

            for (int right=0; right<s.length(); right++) {
                char currR = s.charAt(right);
                counter.put(currR, counter.getOrDefault(currR, 0)+1);

                if (right - left+1 > k) {
                    char currL = s.charAt(left++);
                    counter.put(currL, counter.get(currL)-1);
                    if (counter.get(currL) == 0) counter.remove(currL);
                }
                if (counter.keySet().size() == k) ans++;
            }

            return ans;
        }
    }
}
