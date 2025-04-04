package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.HashMap;
import java.util.Map;

public class Q792 {
    class Solution {
        Map<String, Integer> counter = new HashMap<>();

        public boolean check(String s, String word) {
            int i=0, j=0;
            while (i<s.length() && j<word.length()) {
                if (s.charAt(i) == word.charAt(j)) j++;
                i++;
            }
            return j==word.length();
        }
        public int numMatchingSubseq(String s, String[] words) {
            for (String word: words) counter.put(word, counter.getOrDefault(word, 0)+1);
            int ans = 0;
            for (var entry: counter.entrySet()) {
                if (check(s, entry.getKey())) ans+= entry.getValue();
            }

            return ans;
        }
    }
}
