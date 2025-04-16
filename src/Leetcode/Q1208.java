package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.ArrayList;
import java.util.List;

public class Q1208 {
    class Solution {
        String s, t;
        public int getCost(int i) {
            return Math.abs(s.charAt(i)-t.charAt(i));
        }
        public int equalSubstring(String s, String t, int maxCost) {
            int n = s.length();
            this.s = s;
            this.t = t;
            List<Integer> candid = new ArrayList<>();
            for (int i=0; i<n; i++) {
                candid.add(getCost(i));
            }

            int left = 0, right = 0;
            int curr = 0;
            int ans = 0;
            while (right < n) {
                curr += candid.get(right);
                right++;

                while (curr > maxCost) {
                    curr-= candid.get(left);
                    left++;
                }

                ans = Math.max(ans, right - left);
            }

            return ans;
        }
    }
}
