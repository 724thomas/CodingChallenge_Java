package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( 2**n )

3. 자료구조/알고리즘 :
backtrack
 */

import java.util.ArrayList;
import java.util.List;

public class Q131 {
    class Solution {
        int n;
        List<List<String>> ans = new ArrayList<>();

        public List<List<String>> partition(String s) {
            n = s.length();
            backtrack(s, 0, new ArrayList<>());
            return ans;
        }

        public void backtrack(String s, int idx, List<String> candid) {
            if (idx >= n) {
                ans.add(new ArrayList<>(candid));
                return;
            }
            for (int i=idx; i<n; i++) {
                if (isPalindrome(s, idx, i)) {
                    candid.add(s.substring(idx, i+1));
                    backtrack(s, i+1, candid);
                    candid.remove(candid.size()-1);
                }
            }
        }

        public boolean isPalindrome(String s, int left, int right) {
            while (left < right) {
                if (s.charAt(left) != s.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }
    }
}
