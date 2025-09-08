package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.HashMap;
import java.util.Map;

public class Q2981 {
    class Solution {
        public boolean check(String s) {
            int n = s.length();
            if (n==1) return true;
            for (int i=1; i<n; i++) {
                if (s.charAt(i-1) != s.charAt(i)) return false;
            }
            return true;
        }
        public int maximumLength(String s) {
            Map<String, Integer> counter = new HashMap<>();
            int n = s.length();
            for (int i=0; i<n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j=i; j<n; j++) {
                    sb.append(s.charAt(j));
                    String sub = sb.toString();
                    if (check(sub)) {
                        counter.put(sub, counter.getOrDefault(sub, 0)+1);
                    } else {
                        break;
                    }

                }
            }

            int ans = -1;
            for (var entry : counter.entrySet()) {
                if (entry.getValue() >= 3) {
                    ans = Math.max(ans, entry.getKey().length());
                }
            }
            return ans;
        }
    }
}
