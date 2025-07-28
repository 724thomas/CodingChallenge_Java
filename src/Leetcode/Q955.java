package Leetcode;

/*
1. 아이디어 :
- strs[i][j] > strs[i+1][j] 이면, 해당 j는 삭제 대상.
- strs[i][j] = strs[i+1][j] 이면, j+1을 검사해야함.
- strs[i][j] < strs[i+1][j] 이면, 해당 j는 정렬된 상태이므로, 다음 문자를 검사 안해도됨.
- boolean[] sorted의 목적은 j에서 이미 정렬됬는지 확인하기 위함.

2. 시간복잡도 :
O( n * m )

3. 자료구조/알고리즘 :
- / 그리디
 */

public class Q955 {
    class Solution {
        public int minDeletionSize(String[] strs) {
            int n =strs.length, m = strs[0].length();
            boolean[] sorted = new boolean[n-1];
            int ans = 0;

            for (int idx = 0; idx < m; idx++) { //char idx
                boolean inOrder = true;
                for (int i = 0; i<n-1; i++) { // str idx
                    if (sorted[i]) continue; // 정렬되어 있는 상태면 검사안해도됨
                    if (strs[i].charAt(idx) > strs[i+1].charAt(idx)) {
                        inOrder = false;
                        break;
                    }
                }

                if (!inOrder) {
                    ans++;
                    continue;
                }

                for (int i=0; i<n-1; i++) {
                    if (strs[i].charAt(idx) < strs[i+1].charAt(idx)) {
                        sorted[i] = true;
                    }
                }
            }
            return ans;
        }
    }
}
