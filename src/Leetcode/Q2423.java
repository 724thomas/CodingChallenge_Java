package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.HashMap;
import java.util.Map;

public class Q2423 {
    class Solution {
        int[] counter = new int[26];
        public boolean check() {
            Map<Integer, Integer> count = new HashMap<>();
            for (int i=0; i<26; i++) {
                if (counter[i] == 0) continue;
                count.put(counter[i], count.getOrDefault(counter[i], 0)+1);
            }
            return count.size()==1;
        }

        public boolean equalFrequency(String word) {
            for (char c : word.toCharArray()) counter[c-'a']++;
            for (char c : word.toCharArray()) {
                counter[c-'a']--;
                if (check()) return true;
                counter[c-'a']++;
            }
            return false;
        }
    }
}
