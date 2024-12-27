package Leetcode;

import java.util.Arrays;
import java.util.Map;

public class Q1657 {
    class Solution {
        public int[] counter(String word) {
            int[] counter = new int[26];;
            for (char c : word.toCharArray()) {
                counter[c-'a']++;
            }
            return counter;
        }

        public boolean check(Map<Character, Integer> c1, Map<Character, Integer> c2) {
            for (var key : c1.keySet()) {
                if (!c2.containsKey(key)) return false;
            }
            return true;
        }

        public boolean closeStrings(String word1, String word2) {
            int[] c1 = counter(word1);
            int[] c2 = counter(word2);

            for (int i=0; i<26; i++) {
                if ((c1[i] == 0 && c2[i] != 0) || (c1[i] != 0 && c2[i] == 0)) return false;
            }

            Arrays.sort(c1);
            Arrays.sort(c2);

            for (int i=0; i<26; i++) {
                if (c1[i] != c2[i]) return false;
            }
            return true;
        }
    }
}
