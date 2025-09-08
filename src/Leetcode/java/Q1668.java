package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q1668 {
    class Solution {
        public int maxRepeating(String sequence, String word) {
            int ans = 0;
            StringBuilder sb = new StringBuilder(word);
            while (sequence.contains(sb)) {
                ans++;
                sb.append(word);
            }
            return ans;
        }
    }
}
