package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.ArrayList;
import java.util.List;

public class Q2900 {
    class Solution {
        public List<String> getLongestSubsequence(String[] words, int[] groups) {
            List<String> subsequence = new ArrayList<>();
            int n = words.length;
            if(n == 0) return subsequence;

            subsequence.add(words[0]);
            int lastGroup = groups[0];

            for (int i = 1; i < n; i++) {
                if (groups[i] != lastGroup) {
                    subsequence.add(words[i]);
                    lastGroup = groups[i];
                }
            }

            return subsequence;
        }
    }
}
