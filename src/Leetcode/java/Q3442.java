package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q3442 {
    class Solution {
        public int maxDifference(String s) {
            int[] counter = new int[26];
            for (char c : s.toCharArray()) {
                counter[c-'a']++;
            }

            int ans = Integer.MIN_VALUE;
            for (int i=0; i<26; i++) for (int j=0; j<26; j++) {
                if (counter[i] == 0 || counter[j] == 0 || i==j) continue;
                if (counter[i] % 2 == 1 && counter[j] % 2 == 0) {
                    ans = Math.max(ans, counter[i] - counter[j]);
                }

            }
            return ans;
        }
    }
}
