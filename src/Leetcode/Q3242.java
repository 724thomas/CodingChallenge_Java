package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.HashMap;
import java.util.Map;

public class Q3242 {
    class NeighborSum {
        int[][] grid;
        int n;
        Map<Integer, int[]> cords;

        int[] dx1 = {1,-1,0,0};
        int[] dy1 = {0,0,1,-1};

        int[] dx2 = {1,1,-1,-1};
        int[] dy2 = {1,-1,1,-1};

        public NeighborSum(int[][] grid) {
            this.grid = grid;
            n = grid.length;

            cords = new HashMap<>();
            for (int i=0; i<n; i++) for (int j=0; j<n; j++) {
                cords.put(grid[i][j], new int[]{i,j});
            }
        }

        public int adjacentSum(int value) {
            int[] cord = cords.get(value);
            int ans = 0;
            for (int i=0; i<4; i++) {
                int nx = cord[0] + dx1[i], ny = cord[1] + dy1[i];
                if (nx>=0 && ny>=0 && nx<n && ny<n) ans += grid[nx][ny];
            }
            return ans;
        }

        public int diagonalSum(int value) {
            int[] cord = cords.get(value);
            int ans = 0;
            for (int i=0; i<4; i++) {
                int nx = cord[0] + dx2[i], ny = cord[1] + dy2[i];
                if (nx>=0 && ny>=0 && nx<n && ny<n) ans += grid[nx][ny];
            }
            return ans;
        }
    }

/**
 * Your NeighborSum object will be instantiated and called as such:
 * NeighborSum obj = new NeighborSum(grid);
 * int param_1 = obj.adjacentSum(value);
 * int param_2 = obj.diagonalSum(value);
 */
}
