package Leetcode;

/*
1. 아이디어 :
- check 메서드를 이용하여 현재까지 방문한 문자들이 대소문자 쌍을 모두 포함하는지 확인
- 브루트포스로 모든 부분 문자열을 검사하여 가장 긴 "nice" substring을 찾음

2. 시간복잡도 :
O( n**2 * 52 ) - n은 문자열 s의 길이

3. 자료구조/알고리즘 :
해시셋 / 브루트포스
 */

import java.util.HashSet;
import java.util.Set;

public class Q1763 {
    class Solution {
        public boolean check(Set<Character> visited) {
            if (visited.isEmpty()) return false;
            for (char c : visited) {
                if (visited.contains(Character.toUpperCase(c)) != visited.contains(Character.toLowerCase(c))) {
                    return false;
                }
            }
            return true;
        }


        public String longestNiceSubstring(String s) {
            int n = s.length();
            String ans = "";
            for (int i=0; i<n; i++) {
                Set<Character> visited = new HashSet<>();
                StringBuilder sb = new StringBuilder();

                for (int j=i; j<n; j++) {
                    char curr = s.charAt(j);
                    visited.add(curr);
                    sb.append(curr);
                    if (check(visited)) {
                        if (sb.toString().length() > ans.length()) {
                            ans = sb.toString();
                        }
                    }
                }
            }
            return ans;
        }
    }
}
