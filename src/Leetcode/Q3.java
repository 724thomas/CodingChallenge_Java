package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.HashSet;
import java.util.Set;

public class Q3 {
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            int n = s.length();
            Set<Character> visited = new HashSet<>();
            int ans = 0;
            for (int left = 0, right = 0; right<n; right++) {
                char curr = s.charAt(right);
                while (visited.contains(curr)) {
                    char prev = s.charAt(left++);
                    visited.remove(prev);
                }
                visited.add(curr);
                ans = Math.max(ans, right - left + 1);
            }
            return ans;
        }
    }
}
