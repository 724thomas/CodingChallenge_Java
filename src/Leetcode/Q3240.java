package Leetcode;

/*
1. 아이디어 :
- 중앙 row, col를 제외하고는 palindrome을 만들면, 1s % 4 = 0 조건 만족.
- 정중앙 값은 짝수로 맞추기 위해 0으로 무조건 바꿔줘야합니다.

- 중앙 row, col을 순회하면서 1의 갯수를 세고, 0과 1의 갯수가 다르면 diff를 더함. ones % 4 == diff % 4 조건이 항상 만족.
- ans에 diff 만큼 flip해줘야하기때문에 더합니다.
- ones % 4 == 1이면, diff % 4 == (1 or 3) 이므로, 정중앙을 제외한 중앙 아무곳 2개를 바꿔줘야합니다. (ans += 2)
- ones % 4 == 2이면, diff % 4 == (0 or 2) 이므로, 정중앙을 제외한 중앙 아무곳 2개를 바꿔줘야합니다. (ans += 2)
- ones % 4 == 3이면, diff % 4 == (1 or 3) 이므로, 정중앙을 제외한 중앙 아무곳 2개를 바꿔줘야합니다. (ans += 2)

2. 시간복잡도 :
O( n * m )

3. 자료구조/알고리즘 :
배열 / 그리디
 */

public class Q3240 {
    class Solution {
        /*

        */
        int[][] grid;
        int n, m;
        public int oneCount(int row, int col) {
            return grid[row][col]
                    + grid[row][m-1-col]
                    + grid[n-1-row][col]
                    + grid[n-1-row][m-1-col];
        }

        public int minFlips(int[][] grid) {
            this.grid = grid;
            n = grid.length;
            m = grid[0].length;
            int ans = 0;
            int ones = 0;
            int flip = 0;

            // 중앙 제외
            for (int row=0; row < n/2; row++) for (int col=0; col < m/2; col++) {
                int count = oneCount(row, col);
                ans += Math.min(count, 4-count);
            }
            if (n % 2 == 1 && m % 2 == 1) ans += grid[n/2][m/2];
            // 1 % 4 == 0 조건 만족

        /*
        [1, 0, 0, 1]
        [0, 1, 1, 0]
        [0, 1, 1, 0]
        [1, 0, 0, 1]

        [0, 0, 1, 0, 0]
        [0, 0, 1, 0, 0]
        [1, 0, 0, 0, 0]
        [0, 0, 0, 0, 0]
        [0, 0, 0, 0, 0]
        */

            // row mid
            if (n % 2 == 1) {
                for (int col=0; col<m/2; col++) {
                    flip += (grid[n/2][col] != grid[n/2][m-1-col])? 1:0;
                    ones += grid[n/2][col] + grid[n/2][m-1-col];
                }
            }

            // row col
            if (m % 2 == 1) {
                for (int row=0; row<n/2; row++) {
                    flip += (grid[row][m/2] != grid[n-1-row][m/2])? 1:0;
                    ones += grid[row][m/2] + grid[n-1-row][m/2];
                }
            }
            ans += flip;

            if (flip == 0 && ones % 4 != 0) { // 정중앙을 제외한 중앙 아무곳 2개를 바꿈.
                ans += 2;
            }

            return ans;
        }
    }
}
