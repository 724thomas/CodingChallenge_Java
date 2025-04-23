package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q3456 {
    class Solution {
        public boolean hasSpecialSubstring(String s, int k) {
            int n = s.length();

            for (int start = 0; start + k <= n; start++) {
                int end = start + k - 1;
                char c = s.charAt(start);

                // 윈도우 내부가 모두 같은 문자인지 확인
                boolean allSame = true;
                for (int i = start; i <= end; i++) {
                    if (s.charAt(i) != c) {
                        allSame = false;
                        break;
                    }
                }
                if (!allSame) continue;

                // 경계 검사
                if (start > 0 && s.charAt(start - 1) == c) continue;
                if (end   < n-1 && s.charAt(end + 1)   == c) continue;

                return true;
            }

            return false;
        }
    }
}
