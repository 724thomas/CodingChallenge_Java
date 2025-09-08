package Leetcode.java;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.Arrays;

public class Q1288 {
    class Solution {
        public int removeCoveredIntervals(int[][] intervals) {
            Arrays.sort(intervals, (a, b) -> {
                if (a[0]!=b[0]) return a[0]-b[0];
                return b[1]-a[1];
            });

            int curr = -1;
            int ans = 0;

            for (int[] i: intervals) {
                int e=i[1];
                if (curr < e) {
                    ans++;
                    curr = e;
                }
            }
            return ans;
        }
    }
}
