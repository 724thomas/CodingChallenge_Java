package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.ArrayList;
import java.util.List;

public class Q245 {
    class Solution {
        public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
            int n = wordsDict.length;
            int ans = Integer.MAX_VALUE;
            if (word1.equals(word2)) {
                List<Integer> idx1 = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    if (wordsDict[i].equals(word1)) idx1.add(i);
                }
                for (int i = 0; i < idx1.size() - 1; i++) {
                    ans = Math.min(ans, idx1.get(i + 1) - idx1.get(i));
                }
                return ans;
            }

            List<Integer> idx1 = new ArrayList<>();
            List<Integer> idx2 = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                if (wordsDict[i].equals(word1)) idx1.add(i);
                if (wordsDict[i].equals(word2)) idx2.add(i);
            }

            int left = 0, right = 0;
            while (left < idx1.size() && right < idx2.size()) {
                ans = Math.min(ans, Math.abs(idx1.get(left) - idx2.get(right)));
                if (left + 1 < idx1.size()) ans = Math.min(ans, Math.abs(idx1.get(left + 1) - idx2.get(right)));
                if (right + 1 < idx2.size()) ans = Math.min(ans, Math.abs(idx1.get(left) - idx2.get(right + 1)));

                if (idx1.get(left) > idx2.get(right)) right++;
                else left++;
            }
            return ans;
        }
    }
}
