package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class Q266 {
    class Solution {
        public boolean canPermutePalindrome(String s) {
            Map<Character, Integer> counter = new HashMap<>();
            int odds = 0;
            for (char c : s.toCharArray()) {
                counter.put(c, counter.getOrDefault(c, 0) + 1);
                odds += counter.get(c) % 2 == 0 ? -1 : 1;
            }
            return odds <= 1;
        }
    }

}
