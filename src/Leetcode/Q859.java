package Leetcode;

/*
1. 아이디어 :
- 길이가 같아야함
- 캐릭터의 갯수가 같아야함
- 다른 문자의 갯수가 2개 이하여야함
- 문자의 갯수가 2개 이상인 문자가 있으면 스왑없이도 가능

2. 시간복잡도 :
O( Math.max(n, 26) )

3. 자료구조/알고리즘 :
- / -
 */

public class Q859 {
    class Solution {
        public boolean buddyStrings(String s, String goal) {
            int diff = 0;
            int n = s.length();
            if (s.length() != goal.length()) return false;
            int[] c1 = new int[26], c2 = new int[26];

            for (int i=0; i<n; i++) {
                if (s.charAt(i) != goal.charAt(i)) diff++;
                c1[s.charAt(i)-'a']++;
                c2[goal.charAt(i)-'a']++;
            }

            for (int i=0; i<26; i++) {
                if (c1[i] != c2[i]) return false;
            }

            if (diff >2 || diff%2 == 1) return false;
            if (diff == 2) return true;

            for (int i=0; i<26; i++) {
                if (c1[i] >= 2) return true;
            }

            return false;
        }
    }
}
