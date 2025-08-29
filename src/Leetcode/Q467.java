package Leetcode;

/*
1. 아이디어 :
- 1번의 순회로 끝나야함
- 연속된 문자열을 찾고, 찾게 되면 해당 문자열의 인덱스마다 최대 길이를 기록
- 마지막에 26개의 최대 길이를 모두 더함

2. 시간복잡도 :
O( n )

3. 자료구조/알고리즘 :
- / -
 */

import java.util.Set;

public class Q467 {
    class Solution {
        Set<String> candid;
        String s;
        int n;
        int[] maxCount;

        public Character getPrev(Character c) {
            return (char)(((26 + c - 'a' -1) % 26)+'a');
        }

        public void updateCount(String s) {
            int n = s.length();
            for (int i=0; i<n; i++) {
                maxCount[s.charAt(i)-'a'] = Math.max(maxCount[s.charAt(i)-'a'], n-i);
            }
        }

        public int findSubstringInWraproundString(String s) {
            this.s=s;
            n = s.length();
            maxCount = new int[26];

            StringBuilder sb = new StringBuilder();
            sb.append(s.charAt(0));
            for (int i=1; i<n; i++) {
                if (s.charAt(i-1) == getPrev(s.charAt(i))) {
                    sb.append(s.charAt(i));
                } else {
                    updateCount(sb.toString());
                    sb = new StringBuilder();
                    sb.append(s.charAt(i));
                }
            }
            updateCount(sb.toString());

            int ans = 0;
            for (int i=0; i<26; i++) ans += maxCount[i];

            return ans;
        }
    }
}
