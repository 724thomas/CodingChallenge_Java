package Leetcode;

/*
1. 아이디어 :
i=0번쨰 열부터 n-1번째 열까지 순회를 합니다.
- 지금까지의 최소값을 저장하는 curr배열을 바탕으로 새롭게 최소값이 저장될 next 배열을 초기화합니다.
- i번째 열의 출발 지점, i+1열의 도착 지점을 순회합니다. O(n**2)
- 출발 지점 값과 도착 지점 값, 그리고 cost를 구합니다.
- next배열의 도착지점의 최소값 = curr[시작점] + cost + 도착 지점값

2. 시간복잡도 :
O( n * m * m )

3. 자료구조/알고리즘 :
배열 / dp
 */

import java.util.Arrays;

public class Q2304 {
    class Solution {
        public int minPathCost(int[][] grid, int[][] moveCost) {
            int n = grid.length, m = grid[0].length;
            int[] curr = grid[0];

            for (int row=0; row<n-1; row++) {
                int[] next = new int[m];
                Arrays.fill(next, Integer.MAX_VALUE);

                for (int start=0; start<m; start++) {
                    int startCell = grid[row][start];
                    for (int end=0; end<m; end++) {
                        int endCell = grid[row+1][end];
                        int cost = moveCost[startCell][end];

                        next[end] = Math.min(next[end], curr[start] + cost + endCell);
                    }
                }
                curr = next;
            }

            int ans = Integer.MAX_VALUE;
            for (int num : curr) ans = Math.min(ans, num);
            return ans;
        }
    }
}
