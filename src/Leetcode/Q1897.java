package Leetcode;

/*
1. 아이디어 :
모든 알파벳이 words에 골고루 있어야하기 때문에, 각 알파벳 총합을 words 길이만큼 나눴을때 나머지가 있는지 확인합니다.

2. 시간복잡도 :
O( n )

3. 자료구조/알고리즘 :
배열 / -
 */

public class Q1897 {
    class Solution {
        public boolean makeEqual(String[] words) {
            int n = words.length;
            int[] count = new int[26];
            for (String word : words) for (char c : word.toCharArray()) {
                count[c-'a']++;
            }

            for (int i=0; i<26; i++) {
                if (count[i] % n != 0) return false;
            }
            return true;

        }
    }
}
