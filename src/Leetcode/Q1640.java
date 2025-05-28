package Leetcode;

/*
1. 아이디어 :
구현.
중복된 숫자가 없으니, arr의 각 숫자에 대해 pieces를 순회하며 비교.

2. 시간복잡도 :
O( m * k )

3. 자료구조/알고리즘 :
- / 구현
 */

public class Q1640 {
    class Solution {
        public boolean canFormArray(int[] arr, int[][] pieces) {
            int n = arr.length, m = pieces.length;

            for (int i=0; i<n; i++) {
                int num = arr[i];
                boolean found = false;
                for (int j=0; j<m; j++) {
                    if (num == pieces[j][0]) {
                        found = true;
                        for (int k=0; k<pieces[j].length; k++) {
                            if (arr[i+k] != pieces[j][k]) return false;
                        }
                        i += pieces[j].length-1;
                    }
                }
                if (!found) return false;
            }
            return true;

        }
    }
}
