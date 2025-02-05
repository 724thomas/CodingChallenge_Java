package Leetcode;

/*
1. 아이디어 :
길이 n(n>2)인 substring에 대해 true이면, n-1도 true이기때문에 최소길이인 2를 찾으면 됩니다.
n<=100이기 떄문에 2중 for loop을 돌면서 계산할 수 있습니다.

2. 시간복잡도 :
O( n**2 )

3. 자료구조/알고리즘 :
-
 */

public class Q3083 {
    class Solution {
        public boolean isSubstringPresent(String s) {
            int n = s.length();
            for (int i=0; i<n-1; i++) for (int j=0; j<n-1; j++) {
                if (s.charAt(j) == s.charAt(i+1) && s.charAt(j+1) == s.charAt(i)) return true;
            }
            return false;
        }
    }
}
