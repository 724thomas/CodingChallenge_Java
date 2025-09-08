package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.HashMap;
import java.util.Map;

public class Q38 {
    class Solution {
        Map<String, String> cache = new HashMap<>();
        public String helper(String s) {
            StringBuilder sb = new StringBuilder();
            char c = s.charAt(0);
            int count = 1;

            for (int i=1; i<s.length(); i++) {
                if (s.charAt(i) == c) {
                    count++;
                } else {
                    sb.append(count);
                    sb.append(c);
                    c = s.charAt(i);
                    count=1;
                }
            }
            sb.append(count);
            sb.append(c);
            return sb.toString();
        }
        public String countAndSay(int n) {
            String ans = "1";
            for (int i=0; i<n-1; i++) {
                ans = helper(ans);
            }
            return ans;
        }
    }
}
