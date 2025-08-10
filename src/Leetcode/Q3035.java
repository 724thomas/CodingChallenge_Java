package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.Arrays;

public class Q3035 {
    class Solution {
        public int maxPalindromesAfterOperations(String[] words) {
            int n = words.length;
            Arrays.sort(words, (a, b)->a.length()-b.length());
            int[] counter = new int[26];

            for (String word: words) {
                for (char c : word.toCharArray()) {
                    counter[c-'a']++;
                }
            }

            int totalEvens = 0;
            int totalRemains = 0;
            for (int i =0; i<26; i++) {
                totalRemains += counter[i]%2;
                totalEvens += counter[i]/2 * 2;
            }

            int impossible = 0;
            for (String word : words) {
                int length = word.length();
                if (length % 2 == 0) {
                    if (totalEvens >= length) {
                        totalEvens-=length;
                    } else {
                        impossible++;
                    }
                } else { //length % 2 == 1
                    if (totalEvens >= length-1) {
                        totalEvens-=length-1;
                        if (totalRemains >= 1) {
                            totalRemains--;
                        } else {
                            totalEvens-=2;
                            totalRemains++;
                        }
                    } else {
                        impossible++;
                    }
                }
            }

            return n - impossible;
        }
    }
}
