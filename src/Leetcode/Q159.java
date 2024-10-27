package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class Q159 {
    class Solution {
        public int lengthOfLongestSubstringTwoDistinct(String s) {
            Map<Character, Integer> counter = new HashMap<>();
            int distinct = 0;
            int ans = 0;

            int left = 0;
            for (int right =0; right<s.length(); right++){
                char currR = s.charAt(right);
                counter.put(currR, counter.getOrDefault(currR, 0)+1);
                if (counter.get(currR) == 1) distinct++;

                while (distinct == 3) {
                    char currL = s.charAt(left++);
                    counter.put(currL, counter.get(currL)-1);
                    if (counter.get(currL) == 0) distinct--;
                }
                ans = Math.max(ans, right-left+1);
            }
            return ans;
        }
    }
}
