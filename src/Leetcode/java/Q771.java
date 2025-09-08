package Leetcode.java;

import java.util.HashSet;
import java.util.Set;

public class Q771 {
    class Solution {
        public int numJewelsInStones(String jewels, String stones) {
            Set<Character> jewel = new HashSet<>();
            for (var c : jewels.toCharArray()) jewel.add(c);
            int ans = 0;
            for (var c: stones.toCharArray()) if (jewel.contains(c)) ans ++;
            return ans;
        }
    }
}
