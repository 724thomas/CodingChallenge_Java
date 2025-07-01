package Leetcode;

/*
1. 아이디어 :
전 행의 값보다 1 큰 값으로 채워 넣습니다.

2. 시간복잡도 :
O( n * m )

3. 자료구조/알고리즘 :
- / 브루트 포스
 */

public class Q3402 {
    class Solution {
        public int minimumOperations(int[][] grid) {
            int n = grid.length, m = grid[0].length;
            int ans = 0;
            for (int row = 1; row<n; row++) {
                for (int col = 0; col<m; col++) {
                    int prev = grid[row-1][col];
                    ans+= Math.max(0, (prev+1) - grid[row][col]);
                    grid[row][col] = Math.max(grid[row][col], prev+1);
                }
            }
            return ans;
        }
    }
}
