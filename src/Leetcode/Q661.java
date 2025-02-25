package Leetcode;

/*
1. 아이디어 :
prefixSum으로 범위를 미리 계산합니다.

2. 시간복잡도 :
O( n*m * 2 )

3. 자료구조/알고리즘 :
배열 / 누적합
 */

public class Q661 {
    class Solution {
        int n, m;
        int[][] p;

        public int getAverage(int row, int col) {
            int minRow = Math.max(row - 1, 0), minCol = Math.max(col - 1, 0);
            int maxRow = Math.min(row + 1, n - 1), maxCol = Math.min(col + 1, m - 1);
            int cells = (maxRow - minRow + 1) * (maxCol - minCol + 1);

            int tl = (minRow > 0 && minCol > 0) ? p[minRow][minCol] : 0;
            int tr = (minRow > 0) ? p[minRow][maxCol + 1] : 0;
            int bl = (minCol > 0) ? p[maxRow + 1][minCol] : 0;
            int br = p[maxRow + 1][maxCol + 1];

            int total = br - tr - bl + tl;
            return total / cells;
        }

        public int[][] imageSmoother(int[][] img) {
            n = img.length;
            m = img[0].length;
            p = new int[n + 1][m + 1];

            for (int i = 1; i <= n; i++) for (int j = 1; j <= m; j++) {
                p[i][j] = img[i - 1][j - 1]+ p[i - 1][j]+ p[i][j - 1]- p[i - 1][j - 1];
            }

            int[][] ans = new int[n][m];
            for (int i = 0; i < n; i++) for (int j = 0; j < m; j++) {
                ans[i][j] = getAverage(i, j);
            }

            return ans;
        }
    }

}
