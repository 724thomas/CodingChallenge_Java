package Leetcode.java;

/*
1. 아이디어 :
투포인터와 해시맵으로 매번 확인하면서 순회

2. 시간복잡도 :
O( n * 26 )

3. 자료구조/알고리즘 :
해시맵
 */

public class Q567_2 {
    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            int n = s1.length(), m = s2.length();

            int[] s1Counter = new int[26];
            for (char c : s1.toCharArray()) {
                s1Counter[c-'a']++;
            }

            int[] s2Counter = new int[26];
            int left = 0, right = 0;

            while (right < m) {
                s2Counter[s2.charAt(right) - 'a'] ++;

                while ( check(s1Counter, s2Counter) == 1) {
                    s2Counter[s2.charAt(left) - 'a']--;
                    left++;
                }
                right++;

                if (check(s1Counter, s2Counter) == 0) return true;
            }
            return false;
        }

        public int check(int[] s1Counter, int[] s2Counter) { // -1 부족, 0 정확, 1 오버
            for (int i=0; i<26; i++) {
                if (s1Counter[i] - s2Counter[i] < 0) { // 오버
                    return 1;
                } else if (s1Counter[i] - s2Counter[i] > 0) { // 부족
                    return -1;
                }
            }
            return 0;
        }
    }
}
