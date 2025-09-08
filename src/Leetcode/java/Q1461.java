package Leetcode.java;

/*
1. 아이디어 :
- 해시셋을 통해 모든 k-길이의 이진 문자열을 저장한다.
- k-길이의 이진 문자열은 슬라이딩 윈도우를 사용하여 생성한다.

2. 시간복잡도 :
O( n * k ). k = sb에서 제일 앞 문자열을 삭제할때 O(k)이 걸림

3. 자료구조/알고리즘 :
해시셋 / 슬라이딩 윈도우
 */

import java.util.HashSet;
import java.util.Set;

public class Q1461 {
    class Solution {
        public boolean hasAllCodes(String s, int k) {
            if (k > s.length()) return false;

            int n = s.length();
            Set<String> visited = new HashSet<>();
            StringBuilder sb = new StringBuilder();
            for (int i=0; i<k; i++) {
                sb.append(s.charAt(i));
            }
            visited.add(sb.toString());

            for (int i=k; i<n; i++) {
                sb.deleteCharAt(0);
                sb.append(s.charAt(i));
                visited.add(sb.toString());
            }

            return visited.size() == Math.pow(2, k);
        }
    }
}
